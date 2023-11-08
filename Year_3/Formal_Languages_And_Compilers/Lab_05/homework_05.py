import re
import openpyxl

def ex1():
    with open('file.html', 'r') as file:
        content = file.read()
        print(re.findall(r'https://\w*.\w*.\w*/\w*', content))
        print(re.findall(r'<label[^>]*>\s*Last Name\s*<\/label>|<label[^>]*>\s*First Name\s*<\/label>', content))
        print(re.findall(r'<input[^>]*\s+type\s*=\s*["\']?(text|number|email)["\']?[^>]*>', content))
        print(re.findall(r'<option\s+value\s*=\s*["\']?\s*(PhD student|Professor)\s*["\']?\s*>', content))
        print(re.findall(r'id\s*=\s*["\']?(lname|fname)["\']?', content))
        print(re.findall(r'(<p>\s*\w*\s*(?:\w+\s*)*<\/p>)', content))

def ex2():
    wb = openpyxl.Workbook()
    sheet_counter = len(wb)

    ws = wb.create_sheet(f'Sheet{sheet_counter}')
    with open('text.txt', 'r+') as text:
        lines = text.read().split(',')
    
        for line in lines:
            rows = line.split('\n')
            
            for row in rows:
                ws.append(row)
                wb.save('result.xlsx')   
        
        wb.save('result.xlsx')



dfa = {
        0: {'a': 1, 'b': 2},
        1: {'a': 2, 'b': 4}, #ab 1-2-4
        2: {'a': 3, 'b': 2},
        3: {'a': 4, 'b': 2},
        4: {'a': 4, 'b': 4}
    }

def checking(transitions, start, final, string):
    
    state = start
    try:
        for x in string:
            state = transitions[state][x]
        
        if state in final:
            return "True";
        else:
            return "False";
    except:
        return "False But with error";



def main():
    #ex1();
    print(checking(dfa, 0, {4}, "aabba"))



if __name__ == "__main__":
    main()