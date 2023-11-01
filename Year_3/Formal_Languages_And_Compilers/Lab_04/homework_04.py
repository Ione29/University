import re

def ex1():
    print("Ex.1:")
    str1 = "there are no upper case letter here but we have a 1"
    str2 = "here we have 1 Upper case letter!"
    strings = [str1, str2]

    pattern = re.compile(r"^[a-z0-9*]+$")
    
    for word in strings:
        if pattern.match(word):
            print(f"{word}:\n respects the conditions")
        else:
            print(f"{word}:\n does not respect the conditions")


def ex2():
    print("Ex2.:")
    string = ["FILS_student", "fils_STUDENT"]

    pattern = re.compile(r"^[A-Z]+_[a-z]+$")
    
    for word in string:
        if pattern.match(word):
            print(f"{word} has the correct pattern")
        else:
            print(f"{word} does not have the correct pattern")
    
ex2()

import re

def ex3():
    print("Ex.3:")
    string = "rectangle square sphere triangle cone cube cylinder"
    words = string.split()

    pattern = re.compile(r"(le|re)$")
    for word in words:
        if pattern.search(word):
            print(word)

ex3()

def ex4():
    print("Ex.4:")
    text = "The quick brown fox jumps over the lazy dog. The lazy dog sleeps."
    pattern = re.compile(r"(The) (quick|lazy)")

    matches = pattern.finditer(text)
    for match in matches:
        print(f"Full match: {match.group(0)}")
        print(f"Group 1: {match.group(1)}")
        print(f"Group 2: {match.group(2)}")

ex4()

def ex5():
    print("Ex.5:")
    date = "10-01-02"
    months = {
        "01": "January",
        "02": "February",
        "03": "March",
        "04": "April",
        "05": "May",
        "06": "June",
        "07": "July",
        "08": "August",
        "09": "September",
        "10": "October",
        "11": "November",
        "12": "December"
    }

    splitDate = re.split("-", date)

    day = splitDate[2]
    month = months[splitDate[1]]
    year = splitDate[0]

    print(f"{day} {month} {year}")

def ex6():
    print("Ex.6:")
    words = ['man', 'maaan']

    pattern = r'^m.{3}n$'
    for word in words:
        if re.search(pattern, word):
            print(word)

ex6()

def ex7():
    print("Ex.7:")
    words = ['h','hi', 'hii', 'hiii', 'hiiii']
    pattern = r'^hii{2,3}$'
    for word in words:
        if re.search(pattern, word):
            print(word)

ex7()

def ex8():
    print("Ex.8:")
    words = ['quartz', 'ooqxdsfn', 'Iraq']
    pattern = r'\Bq\B'
    for word in words:
        if re.search(pattern, word) and word[0] != 'q' and word[-1] != 'q':
            print(word)

ex8()

def ex9():
    print("Ex.9:")
    string = "aeiou"

    string = string.replace('a', 'u')
    string = string.replace('i', 'e')
    print(string)

ex9()

