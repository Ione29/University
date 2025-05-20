import os
from flask import Flask, render_template, request, redirect, url_for, abort
from lxml import etree

app = Flask(__name__)

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

# XSD paths
BOOKS_XSD = os.path.join(SCHEMA_DIR, 'books.xsd')
USERS_XSD = os.path.join(SCHEMA_DIR, 'users.xsd')
BOOKS_XSL = os.path.join(XSLT_DIR, 'books.xsl')

def load_xml(path):
    return etree.parse(path)

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

@app.route('/')
def index():
    return redirect(url_for('display'))

# 3 & 8: display books via XSLT
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

    books_doc = load_xml(BOOKS_XML)
    validate_xml(books_doc, BOOKS_XSD)
    xslt = etree.XSLT(etree.parse(BOOKS_XSL))
    result = xslt(books_doc, userLevel=etree.XSLT.strparam(user_level))
    table_html = str(result)
    return render_template('display.html',
                           users=users,
                           selected=selected,
                           table_html=table_html)

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
    selected = users[1].get('id')  # first user is the default one
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
    return render_template('book_detail.html', book=b)

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

if __name__=='__main__':
    app.run(debug=True)
