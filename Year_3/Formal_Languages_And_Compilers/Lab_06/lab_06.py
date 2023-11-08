import re
import requests
from bs4 import BeautifulSoup

def get_price(s:str)->None:
    print(re.findall(r'£\d*\.\d*', s))

def get_name(s:str)->None:
    print(re.findall(r'title="(.*?)"', s))

def get_alts(s:str)->None:
    print(re.findall(r'alt="(.*?)"', s))

def get(url)->None:
    try:
        response = requests.get(url)
        if response.status_code == 200:
            soup = BeautifulSoup(response.text, 'html.parser')
            soup.prettify()

            tag = soup.find('div', class_='col-sm-8')
            print(tag.text.strip())
            
            tag = soup.find('li', class_='current')
            print(tag.text.strip() if tag else 'Not found')
            
            tag = soup.find('button')
            print(tag.text.strip() if tag else 'Not found')
            
            tag = soup.find_all('article', class_='product_pod')
            for result in tag:
                get_name(str(result))
                get_price(result.text.strip())
            
            tag = soup.find_all('div', class_='side_categories')

            for result in tag:
                word = [str(result.text).strip()]
                print('\n'.join(word))
                    

            tag = soup.find_all('div', class_='image_container')

            for result in tag:
                get_alts(str(result))


    except Exception as e:
        print(e)

 



def main():
    url = 'https://books.toscrape.com/'
    get(url)
    

if __name__ == "__main__":
    main();