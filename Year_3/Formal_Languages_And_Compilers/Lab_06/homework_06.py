import requests
from bs4 import BeautifulSoup
#import openpyxl

def get_title(url):
    try:
        response = requests.get(url)
        if response.status_code == 200:
            soup = BeautifulSoup(response.text, 'html.parser')

            tag = soup.find_all('div', class_='col-md-4 country')
            for text in tag:
                print(text.get_text().strip() + '\n')
                #wb = openpyxl.Workbook()
                #ws = wb.create_sheet(f'Sheet{sheet_counter}')
                #ws.append(tex.get_text().strip())
                #wb.save('result.xlsx')  

            tag = soup.find('nav')
            print(tag.get_text().strip())
            tag = soup.find('section', id='footer')
            print(tag.get_text().strip())
            tag = soup.find('div', class_='col-md-6')
            print(tag.get_text().strip())
            tag = soup.find('div', class_='col-md-6 text-right')
            print(tag.get_text().strip())


        else:
            print(f'Error: Unable to fetch content (Status Code: {response.status_code})')

    except Exception as e:
        print(f'Error:', {e})

def hw():
    url = 'https://www.scrapethissite.com/pages/simple/'
    get_title(url)

hw()