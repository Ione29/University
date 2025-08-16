import os
import io
import base64
from flask import Flask, render_template, request, redirect, url_for, abort, jsonify
from lxml import etree
import rdflib
import networkx as nx
import matplotlib
matplotlib.use('Agg')  # Use non-interactive backend for generating images
import requests
import matplotlib.pyplot as plt
import json
from sentence_transformers import SentenceTransformer
import chromadb

# base directories
BASE      = os.path.dirname(__file__)
DATA_DIR  = os.path.join(BASE, 'data')
THEMES_DIR = os.path.join(BASE, 'themes')
SCHEMA_DIR= os.path.join(BASE, 'schemas')
XSLT_DIR  = os.path.join(BASE, 'xslt')

# XML paths
BOOKS_XML = os.path.join(DATA_DIR, 'books.xml')
THEMES_XML = os.path.join(THEMES_DIR, 'themes.xml')
USERS_XML = os.path.join(DATA_DIR, 'users.xml')
BOOKS_RDF = os.path.join(DATA_DIR, 'books.rdf')

# XSD paths
BOOKS_XSD = os.path.join(SCHEMA_DIR, 'books.xsd')
USERS_XSD = os.path.join(SCHEMA_DIR, 'users.xsd')
BOOKS_XSL = os.path.join(XSLT_DIR, 'books.xsl')


def load_xml(path):
    return etree.parse(path)

# Initialize embedding model and ChromaDB client
embedding_model = SentenceTransformer('all-MiniLM-L6-v2')
chroma_client = chromadb.Client()
collection_name = "books"
if not chroma_client.list_collections() or collection_name not in [c.name for c in chroma_client.list_collections()]:
    books_collection = chroma_client.create_collection(collection_name)
else:
    books_collection = chroma_client.get_collection(collection_name)

def index_books_for_rag():
    # Load books from XML
    books_doc = load_xml(BOOKS_XML)
    books = []
    ids = []
    for b in books_doc.findall('//book'):
        title = b.findtext('title')
        level = b.findtext('readingLevel')
        themes = [t.text for t in b.findall('themes/theme')]
        text = f"Title: {title}, Level: {level}, Themes: {', '.join(themes)}"
        books.append(text)
        ids.append(b.get('id'))
    # Embed and add to ChromaDB
    embeddings = embedding_model.encode(books).tolist()
    # Remove previous and re-add for simplicity (idempotent for demo)
    if books_collection.count() > 0:
        books_collection.delete(where={})
    books_collection.add(documents=books, embeddings=embeddings, ids=ids)

app = Flask(__name__)
index_books_for_rag()

def query_ollama(prompt, model='llama3'):
    url = 'http://localhost:11434/api/chat'
    data = {
        "model": model,
        "messages": [
            {"role": "user", "content": prompt}
        ]
    }
    response = requests.post(url, json=data, timeout=120, stream=True)
    response.raise_for_status()
    # Ollama streams JSON lines; collect the 'message' content from each line
    full_response = ""
    for line in response.iter_lines():
        if line:
            part = line.decode('utf-8')
            try:
                obj = json.loads(part)
                if 'message' in obj and 'content' in obj['message']:
                    full_response += obj['message']['content']
            except Exception as e:
                print(f"Error parsing Ollama stream: {e}")
    return full_response if full_response else "Sorry, I couldn't get a response from the model."


def load_rdf_graph():
    """Load the RDF graph from file."""
    g = rdflib.Graph()
    if os.path.exists(BOOKS_RDF):
        g.parse(BOOKS_RDF, format="xml")
    return g

def save_rdf_graph(g):
    """Save the RDF graph to file."""
    g.serialize(destination=BOOKS_RDF, format="xml")

def book_exists_in_xml(title):
    """Check if a book with the given title exists in XML."""
    doc = load_xml(BOOKS_XML)
    return doc.find(f'//book[title="{title}"]') is not None

def book_exists_in_rdf(title):
    """Check if a book with the given title exists in RDF."""
    g = load_rdf_graph()
    query = """
    PREFIX ex: <http://example.org/books#>
    SELECT ?book WHERE {
        ?book ex:hasTitle ?title .
        FILTER(str(?title) = "%s")
    }
    """ % title
    
    results = g.query(query)
    return len(list(results)) > 0

def add_book_to_rdf(title, themes, level):
    """Add a book to the RDF graph."""
    g = load_rdf_graph()
    
    # Check if book already exists first
    if book_exists_in_rdf(title):
        # If it exists, update it instead of adding a new one
        return update_book_in_rdf(title, themes, level)
    
    # Create a URI for the book (using title with spaces replaced by underscores)
    book_uri = rdflib.URIRef(f"http://example.org/books/{title.replace(' ', '_')}")
    
    # Define namespaces
    ex = rdflib.Namespace("http://example.org/books#")
    rdf = rdflib.Namespace("http://www.w3.org/1999/02/22-rdf-syntax-ns#")
    
    # Add triples
    g.add((book_uri, rdf.type, ex.Book))
    g.add((book_uri, ex.hasTitle, rdflib.Literal(title)))
    for theme in themes:
        g.add((book_uri, ex.hasGenre, rdflib.Literal(theme)))
    g.add((book_uri, ex.hasReadingLevel, rdflib.Literal(level)))
    
    # Save the graph
    save_rdf_graph(g)
    return book_uri

def update_book_in_rdf(title, themes, level):
    """Update a book in the RDF graph."""
    g = load_rdf_graph()
    
    # Create a URI for the book
    book_uri = rdflib.URIRef(f"http://example.org/books/{title.replace(' ', '_')}")
    
    # Define namespaces
    ex = rdflib.Namespace("http://example.org/books#")
    rdf = rdflib.Namespace("http://www.w3.org/1999/02/22-rdf-syntax-ns#")
    
    # Check if book exists, if not - create it
    book_exists = False
    for s, p, o in g.triples((book_uri, ex.hasTitle, None)):
        book_exists = True
        break
    
    if not book_exists:
        # Add type and title if book doesn't exist
        g.add((book_uri, rdf.type, ex.Book))
        g.add((book_uri, ex.hasTitle, rdflib.Literal(title)))
    
    # Remove existing genre and level triples
    g.remove((book_uri, ex.hasGenre, None))
    g.remove((book_uri, ex.hasReadingLevel, None))
    
    # Add updated triples
    for theme in themes:
        g.add((book_uri, ex.hasGenre, rdflib.Literal(theme)))
    g.add((book_uri, ex.hasReadingLevel, rdflib.Literal(level)))
    
    # Save the graph
    save_rdf_graph(g)
    return book_uri

def search_book_in_rdf(title):
    """Search for a book in the RDF graph and return its properties."""
    g = load_rdf_graph()
    
    # Define namespaces
    ex = rdflib.Namespace("http://example.org/books#")
    
    # Query for book details
    query = """
    PREFIX ex: <http://example.org/books#>
    SELECT ?book ?title ?genre ?level WHERE {
        ?book ex:hasTitle ?title .
        ?book ex:hasGenre ?genre .
        ?book ex:hasReadingLevel ?level .
        FILTER(str(?title) = "%s")
    }
    """ % title
    
    results = list(g.query(query))
    if not results:
        return None
    
    # Extract genres
    genres = [str(row.genre) for row in results]
    book_uri = str(results[0].book)
    
    index_books_for_rag()

    # Return book properties
    return {
        'uri': book_uri,
        'title': str(results[0].title),
        'genres': genres,
        'level': str(results[0].level)
    }

def load_themes():
    doc = etree.parse(THEMES_XML)
    return [el.text for el in doc.findall('//theme')]

def validate_xml(xml_doc, xsd_path):
    schema = etree.XMLSchema(etree.parse(xsd_path))
    if not schema.validate(xml_doc):
        raise ValueError(schema.error_log)

def save_xml(tree, path):
    tree.write(path, pretty_print=True, xml_declaration=True, encoding='UTF-8')

def get_next_id(xml_doc, tag):
    ids = [int(e.get('id')) for e in xml_doc.findall(f'//{tag}')]
    return str(max(ids) + 1) if ids else '1'

def process_rdf_file(file_content):
    """Process an RDF file and return the graph and triples."""
    g = rdflib.Graph()
    try:
        g.parse(data=file_content, format="xml")
        
        # Extract all triples
        triples = [(s.n3(), p.n3(), o.n3()) for s, p, o in g]
        
        # Create a NetworkX graph from the RDF graph
        G = nx.DiGraph()
        
        # Add nodes and edges to the graph
        for s, p, o in g:
            s_label = s.n3()
            o_label = o.n3()
            G.add_node(s_label)
            G.add_node(o_label)
            G.add_edge(s_label, o_label, label=p.n3())
            
        return G, triples, None
    except Exception as e:
        return None, None, str(e)

def visualize_rdf_graph(graph):
    """Create a visualization of the RDF graph."""
    plt.figure(figsize=(12, 10))
    
    # Position the nodes using spring layout
    pos = nx.spring_layout(graph)
    
    # Draw nodes
    nx.draw_networkx_nodes(graph, pos, node_size=700, node_color='skyblue')
    
    # Draw edges
    nx.draw_networkx_edges(graph, pos, arrowsize=20, width=2, edge_color='gray')
    
    # Draw node labels (shortened for readability)
    node_labels = {node: node.split('/')[-1].replace('>', '') for node in graph.nodes()}
    nx.draw_networkx_labels(graph, pos, labels=node_labels, font_size=8)
    
    # Draw edge labels
    edge_labels = {(s, o): p.split('/')[-1].replace('>', '') 
                  for s, o, p in [(s, o, graph[s][o]['label']) for s, o in graph.edges()]}
    nx.draw_networkx_edge_labels(graph, pos, edge_labels=edge_labels, font_size=8)
    
    plt.axis('off')
    plt.tight_layout()
    
    # Save the figure to a BytesIO object
    img_data = io.BytesIO()
    plt.savefig(img_data, format='png', dpi=150)
    img_data.seek(0)
    
    # Encode the image to base64
    graph_image = base64.b64encode(img_data.read()).decode('utf-8')
    plt.close()
    
    return graph_image

@app.route('/')
def index():
    return redirect(url_for('display'))

# 3 & 8: display books via XSLT, allowing user selection
@app.route('/display', methods=['GET','POST'])
def display():
    users_doc = load_xml(USERS_XML)
    validate_xml(users_doc, USERS_XSD)
    users = users_doc.findall('//user')
    selected = users[0].get('id')
    if request.method=='POST':
        selected = request.form['user_id']
    user_el = users_doc.find(f'//user[@id="{selected}"]')
    user_level = user_el.findtext('readingLevel')
    user_theme = user_el.findtext('preferredTheme')
    user_name = user_el.findtext('name')

    books_doc = load_xml(BOOKS_XML)
    validate_xml(books_doc, BOOKS_XSD)
    xslt = etree.XSLT(etree.parse(BOOKS_XSL))
    result = xslt(books_doc, userLevel=etree.XSLT.strparam(user_level))
    table_html = str(result)
    return render_template('display.html', 
                           users=users, 
                           selected=selected, 
                           user_level=user_level,
                           user_theme=user_theme,
                           user_name=user_name,
                           table_html=table_html, 
                           is_book_list=True)

# 4: add a book
@app.route('/add_book', methods=['GET','POST'])
def add_book():
    themes_list = load_themes()
    levels = ['Beginner','Intermediate','Advanced']
    if request.method=='POST':
        title = request.form['title'].strip()
        themes = request.form.getlist('themes')
        level = request.form['readingLevel']
        if not title or len(themes)!=2 or level not in levels:
            return "Invalid input", 400

        doc = load_xml(BOOKS_XML)
        root= doc.getroot()
        bid = get_next_id(doc, 'book')
        book_el = etree.SubElement(root, 'book', id=bid)
        etree.SubElement(book_el, 'title').text = title
        themes_el = etree.SubElement(book_el, 'themes')
        for t in themes:
            etree.SubElement(themes_el, 'theme').text = t
        etree.SubElement(book_el, 'readingLevel').text = level
        validate_xml(doc, BOOKS_XSD)
        save_xml(doc, BOOKS_XML)

        # Add to RDF graph
        add_book_to_rdf(title, themes, level)
        
        return redirect(url_for('display'))

    return render_template('add_book.html',
                           themes=themes_list,
                           levels=levels)

# 5: add a user
@app.route('/add_user', methods=['GET','POST'])
def add_user():
    themes_list = load_themes()
    levels = ['Beginner','Intermediate','Advanced']
    if request.method=='POST':
        name = request.form['name'].strip()
        surname = request.form['surname'].strip()
        level = request.form['readingLevel']
        pref  = request.form['preferredTheme']
        if not name or not surname or level not in levels or pref not in themes_list:
            return "Invalid input", 400

        doc = load_xml(USERS_XML)
        root= doc.getroot()
        uid = get_next_id(doc, 'user')
        user_el = etree.SubElement(root, 'user', id=uid)
        etree.SubElement(user_el, 'name').text = name
        etree.SubElement(user_el, 'surname').text = surname
        etree.SubElement(user_el, 'readingLevel').text = level
        etree.SubElement(user_el, 'preferredTheme').text = pref
        validate_xml(doc, USERS_XSD)
        save_xml(doc, USERS_XML)
        return redirect(url_for('display'))

    return render_template('add_user.html',
                           levels=levels,
                           themes=themes_list)

# 6: recommend by reading level
@app.route('/recommend/level', methods=['GET', 'POST'])
def rec_by_level():
    users_doc = load_xml(USERS_XML)
    validate_xml(users_doc, USERS_XSD)
    users = users_doc.findall('//user')
    selected = users[0].get('id')  # first user is the default one
    if request.method == 'POST':
        selected = request.form['user_id']
    u = users_doc.find(f'//user[@id="{selected}"]')
    lvl = u.findtext('readingLevel')

    books_doc = load_xml(BOOKS_XML)
    xpath = f'//book[readingLevel="{lvl}"]'
    matches = books_doc.xpath(xpath)
    return render_template('recommend_level.html',
                           users=users,
                           selected=selected,
                           user=u,
                           books=matches)

# 7: recommend by level + theme
@app.route('/recommend/level_theme', methods=['GET', 'POST'])
def rec_by_level_theme():
    users_doc = load_xml(USERS_XML)
    validate_xml(users_doc, USERS_XSD)
    users = users_doc.findall('//user')
    selected = users[0].get('id')  # first user is the default one
    if request.method == 'POST':
        selected = request.form['user_id']
    u = users_doc.find(f'//user[@id="{selected}"]')
    lvl = u.findtext('readingLevel')
    pref = u.findtext('preferredTheme')

    books_doc = load_xml(BOOKS_XML)
    xpath = f'//book[readingLevel="{lvl}" and themes/theme="{pref}"]'
    matches = books_doc.xpath(xpath)
    return render_template('recommend_level_theme.html',
                           users=users,
                           selected=selected,
                           user=u,
                           books=matches)

# 9: book detail
@app.route('/book/<bid>')
def book_detail(bid):
    doc = load_xml(BOOKS_XML)
    b = doc.find(f'//book[@id="{bid}"]')
    if b is None:
        abort(404)
    # Pass book info to template for JS
    return render_template('book_detail.html', book=b, 
                           book_title=b.findtext('title'),
                           book_themes=[t.text for t in b.findall('themes/theme')])

# 10: filter by theme
@app.route('/filter/theme', methods=['GET', 'POST'])
def filter_theme():
    # load themes from XML
    themes_doc = load_xml(THEMES_XML)
    all_themes = sorted([t.text for t in themes_doc.findall('//theme')])

    # get the books with the selected theme
    doc = load_xml(BOOKS_XML)
    matches = None
    if request.method == 'POST':
        sel = request.form['theme']
        matches = doc.xpath(f'//book[themes/theme="{sel}"]')
        return render_template('theme_filter.html',
                               themes=all_themes,
                               selected=sel,
                               books=matches)
    return render_template('theme_filter.html',
                           themes=all_themes,
                           selected=None,
                           books=None)

# 11: RDF Visualization
@app.route('/rdf_visualize', methods=['GET', 'POST'])
def rdf_visualize():
    if request.method == 'POST':
        if 'rdf_file' not in request.files:
            return render_template('rdf_visualize.html', error='No file part')
            
        rdf_file = request.files['rdf_file']
        
        if rdf_file.filename == '':
            return render_template('rdf_visualize.html', error='No selected file')
            
        if rdf_file:
            try:
                file_content = rdf_file.read()
                
                # Process the RDF content
                graph, triples, error = process_rdf_file(file_content)
                
                if error:
                    return render_template('rdf_visualize.html', error=error)
                    
                # Generate graph visualization
                graph_image = visualize_rdf_graph(graph)
                
                # Limit the number of triples displayed to prevent overwhelming the UI
                display_triples = triples[:100]
                
                return render_template('rdf_visualize.html', 
                                      graph_image=graph_image,
                                      triples=display_triples)
                                      
            except Exception as e:
                return render_template('rdf_visualize.html', error=f'Error processing file: {str(e)}')
                
    return render_template('rdf_visualize.html')

# 12: modify a book
@app.route('/edit_book/<bid>', methods=['GET', 'POST'])
def edit_book(bid):
    doc = load_xml(BOOKS_XML)
    book = doc.find(f'//book[@id="{bid}"]')
    if book is None:
        abort(404)
    
    # Get all themes and current book's themes
    themes_list = load_themes()
    book_themes = [t.text for t in book.findall('themes/theme')]
    levels = ['Beginner', 'Intermediate', 'Advanced']
    
    if request.method == 'POST':
        title = request.form['title'].strip()
        themes = request.form.getlist('themes')
        level = request.form['readingLevel']
        
        # Validate input
        if not title or len(themes) != 2 or level not in levels:
            return "Invalid input", 400
        
        # Update book in XML
        book.find('title').text = title
        themes_el = book.find('themes')
        # Clear existing themes
        for t in themes_el.findall('theme'):
            themes_el.remove(t)
        # Add new themes
        for t in themes:
            etree.SubElement(themes_el, 'theme').text = t
        book.find('readingLevel').text = level
        
        # Validate and save XML
        validate_xml(doc, BOOKS_XSD)
        save_xml(doc, BOOKS_XML)
        
        # Update or add book in RDF
        update_book_in_rdf(title, themes, level)
        
        # Redirect to book detail page
        return redirect(url_for('book_detail', bid=bid))
    
    return render_template('edit_book.html',
                          book=book,
                          book_themes=book_themes,
                          themes=themes_list,
                          levels=levels)

# 13: add book with RDF integration
@app.route('/add_book_rdf', methods=['GET', 'POST'])
def add_book_rdf():
    themes_list = load_themes()
    levels = ['Beginner', 'Intermediate', 'Advanced']
    
    if request.method == 'POST':
        title = request.form['title'].strip()
        themes = request.form.getlist('themes')
        level = request.form['readingLevel']
        
        if not title or len(themes) != 2 or level not in levels:
            return "Invalid input", 400

        # Add book to XML (reusing existing code)
        doc = load_xml(BOOKS_XML)
        root = doc.getroot()
        bid = get_next_id(doc, 'book')
        book_el = etree.SubElement(root, 'book', id=bid)
        etree.SubElement(book_el, 'title').text = title
        themes_el = etree.SubElement(book_el, 'themes')
        for t in themes:
            etree.SubElement(themes_el, 'theme').text = t
        etree.SubElement(book_el, 'readingLevel').text = level
        validate_xml(doc, BOOKS_XSD)
        save_xml(doc, BOOKS_XML)
        
        # Add book to RDF
        add_book_to_rdf(title, themes, level)
        
        return redirect(url_for('display'))

    return render_template('add_book.html',
                          themes=themes_list,
                          levels=levels)

# 14: RDF query interface
@app.route('/rdf_books', methods=['GET', 'POST'])
def rdf_books():
    themes_list = load_themes()
    levels = ['Beginner', 'Intermediate', 'Advanced']
    
    if request.method == 'POST':
        action = request.form.get('action', 'search')
        
        if action == 'search':
            title = request.form.get('search_title', '').strip()
            if title:
                book_data = search_book_in_rdf(title)
                return render_template('rdf_books.html', 
                                     book=book_data, 
                                     title=title, 
                                     themes=themes_list,
                                     levels=levels)
        
        elif action == 'update':
            title = request.form.get('book_title', '').strip()
            new_level = request.form.get('reading_level', '')
            themes = request.form.getlist('themes')
            
            if title and new_level and themes:
                # Update book in RDF
                update_book_in_rdf(title, themes, new_level)
                
                # Check if book exists in XML
                doc = load_xml(BOOKS_XML)
                book = doc.find(f'//book[title="{title}"]')
                if book is not None:
                    # Update in XML as well
                    book.find('readingLevel').text = new_level
                    
                    # Update themes if needed
                    themes_el = book.find('themes')
                    theme_texts = [t.text for t in themes_el.findall('theme')]
                    if set(theme_texts) != set(themes):
                        # Clear existing themes
                        for t in themes_el.findall('theme'):
                            themes_el.remove(t)
                        # Add new themes
                        for t in themes:
                            etree.SubElement(themes_el, 'theme').text = t
                    
                    validate_xml(doc, BOOKS_XSD)
                    save_xml(doc, BOOKS_XML)
                
                # Fetch updated book data
                book_data = search_book_in_rdf(title)
                return render_template('rdf_books.html', 
                                     book=book_data, 
                                     title=title,
                                     update_success=True,
                                     themes=themes_list,
                                     levels=levels)
        
        elif action == 'add':
            title = request.form.get('new_title', '').strip()
            themes = request.form.getlist('new_themes')
            level = request.form.get('new_level', '')
            
            if title and level and len(themes) == 2:
                if not book_exists_in_rdf(title) and not book_exists_in_xml(title):
                    # Add to RDF
                    add_book_to_rdf(title, themes, level)
                    
                    # Add to XML
                    doc = load_xml(BOOKS_XML)
                    root = doc.getroot()
                    bid = get_next_id(doc, 'book')
                    book_el = etree.SubElement(root, 'book', id=bid)
                    etree.SubElement(book_el, 'title').text = title
                    themes_el = etree.SubElement(book_el, 'themes')
                    for t in themes:
                        etree.SubElement(themes_el, 'theme').text = t
                    etree.SubElement(book_el, 'readingLevel').text = level
                    validate_xml(doc, BOOKS_XSD)
                    save_xml(doc, BOOKS_XML)
                    
                    return redirect(url_for('rdf_books'))
                else:
                    return render_template('rdf_books.html', 
                                     error=f"Book '{title}' already exists",
                                     themes=themes_list,
                                     levels=levels)
    
    # Get all book titles from RDF
    titles = get_all_rdf_titles()
    
    return render_template('rdf_books.html', 
                         titles=titles,
                         themes=themes_list,
                         levels=levels)

def get_all_rdf_titles():
    """Get all book titles from the RDF graph."""
    g = load_rdf_graph()
    
    query = """
    PREFIX ex: <http://example.org/books#>
    SELECT DISTINCT ?title
    WHERE {
        ?book ex:hasTitle ?title .
    }
    ORDER BY ?title
    """
    
    return [str(row.title) for row in g.query(query)]

def delete_book_from_rdf(title):
    """Delete a book from the RDF graph."""
    g = load_rdf_graph()
    
    # Create a URI for the book (using title with spaces replaced by underscores)
    book_uri = rdflib.URIRef(f"http://example.org/books/{title.replace(' ', '_')}")
    
    # Define namespaces
    ex = rdflib.Namespace("http://example.org/books#")
    
    # Remove all triples related to this book
    g.remove((book_uri, None, None))
    
    # Also check for any variant URIs that might exist
    # For example, if the title was added without spaces
    variant_uri = rdflib.URIRef(f"http://example.org/books/{title.replace(' ', '')}")
    g.remove((variant_uri, None, None))
    
    # Save the graph
    save_rdf_graph(g)
    return True

@app.route('/delete_book', methods=['POST'])
def delete_book():
    title = request.form.get('title')
    if title:
        # Delete from RDF first
        delete_book_from_rdf(title)
        
        # Then delete from XML
        doc = load_xml(BOOKS_XML)
        book = doc.find(f'//book[title="{title}"]')
        if book is not None:
            doc.getroot().remove(book)
            save_xml(doc, BOOKS_XML)
        
        return redirect(url_for('display'))
    
    return "Invalid request", 400

# 15: Test RDF operations for specific books
@app.route('/test_book_operations')
def test_book_operations():
    results = []
    
    # First, let's clean up any duplicates
    if book_exists_in_rdf("Harry Potter"):
        delete_book_from_rdf("Harry Potter")
        results.append("Cleaned up existing Harry Potter entries")
    
    # Test adding Harry Potter
    themes = ["Fantasy", "Adventure"]
    add_book_to_rdf("Harry Potter", themes, "Intermediate")
    results.append("Added Harry Potter book to RDF")
    
    # Test finding Harry Potter
    hp_data = search_book_in_rdf("Harry Potter")
    if hp_data:
        results.append(f"Found Harry Potter: {hp_data}")
    
    # Test updating Hunger Games reading level
    hg_data_before = search_book_in_rdf("Hunger Games")
    if hg_data_before:
        old_level = hg_data_before.get('level')
        # Change level (toggle between Beginner and Advanced)
        new_level = "Advanced" if old_level == "Beginner" else "Beginner"
        update_book_in_rdf("Hunger Games", hg_data_before.get('genres', []), new_level)
        results.append(f"Updated Hunger Games reading level from {old_level} to {new_level}")
        
        # Verify the change
        hg_data_after = search_book_in_rdf("Hunger Games")
        if hg_data_after:
            results.append(f"Verified Hunger Games level is now: {hg_data_after.get('level')}")
    else:
        results.append("Hunger Games not found in RDF")
    
    return render_template('test_cases.html', 
                         title="Book Operations Test",
                         results=results)

@app.route('/chat_api', methods=['POST'])
def chat_api():
    data = request.get_json()
    user_message = data.get('message', '')
    user_context = data.get('user_context', {})
    print(f"User message: {user_message}")  # Debug print
    print(f"User context: {user_context}")  # Debug print
    
    # --- RAG: Retrieve all books from your XML ---
    books_doc = load_xml(BOOKS_XML)
    books = []
    for b in books_doc.findall('//book'):
        title = b.findtext('title')
        level = b.findtext('readingLevel')
        themes = [t.text for t in b.findall('themes/theme')]
        books.append(f"Title: {title}, Level: {level}, Themes: {', '.join(themes)}")
    books_context = "\n".join(books)
    
    # --- Get user preferences ---
    user_info = ""
    if user_context:
        user_id = user_context.get('user_id')
        if user_id:
            users_doc = load_xml(USERS_XML)
            user_el = users_doc.find(f'//user[@id="{user_id}"]')
            if user_el is not None:
                name = user_el.findtext('name')
                level = user_context.get('user_level') or user_el.findtext('readingLevel')
                theme = user_context.get('user_theme') or user_el.findtext('preferredTheme')
                user_info = f"User: {name}, Reading Level: {level}, Preferred Theme: {theme}"

    # --- Compose prompt for Ollama ---
    prompt = (
        "You are a helpful assistant. Answer ONLY using the following book collection:\n"
        f"{books_context}\n\n"
    )
    
    if user_info:
        prompt += f"Current user info: {user_info}\n\n"
        
    prompt += (
        f"User question: {user_message}\n"
        "If the answer is not in the collection, say you don't know. "
        "If the user asks for recommendations, consider their reading level and preferred theme."
    )

    try:
        answer = query_ollama(prompt)
        print(f"Ollama response: {answer}")  # Debug print
    except Exception as e:
        print(f"Ollama error: {e}")  # Debug print
        answer = f"Error: {str(e)}"
    return jsonify({'answer': answer})

@app.route('/get_user_preferences')
def get_user_preferences():
    user_id = request.args.get('user_id')
    if not user_id:
        return jsonify({"error": "No user ID provided"}), 400
    
    users_doc = load_xml(USERS_XML)
    user_el = users_doc.find(f'//user[@id="{user_id}"]')
    
    if user_el is None:
        return jsonify({"error": "User not found"}), 404
        
    user_data = {
        "level": user_el.findtext('readingLevel'),
        "theme": user_el.findtext('preferredTheme'),
        "name": user_el.findtext('name')
    }
    
    return jsonify(user_data)

if __name__=='__main__':
    app.run(debug=True)
