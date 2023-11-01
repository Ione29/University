import re

def ex1():
    list = ["rectangle", "square", "sphere", "triangle", "cone", "cube", "cylinder"]

    pattern = re.compile(r"^[cs].*e$")

    for word in list:
        if pattern.match(word):
            print(word)

ex1()

def ex2():
    words = "car, cat, dog, pool, bath, cone, cube, ring, int"

    pattern = r"\b\w{4}\b"

    print("Ex2: The words that match the pattern are: ")
    matches = re.findall(pattern, words)
    print(matches)

ex2()

def ex3():
    words = ["square", "triangle", "cube", "sphere", "circle", "pentagon", "hexagon", "rectangle", "parallelogram", "trapezoid"]

    pattern = r"\w+re\b"

    print("Ex3; The words that match the pattern are: ")

    for word in words:
        if re.match(pattern, word):
            print(word)

ex3()

def ex4():
    words = ["square", "triangle", "cube", "sphere", "circle", "pentagon", "hexagon", "rectangle", "parallelogram", "trapezoid"]
    geo = "A square has 4 sides, a triangle has 3, a pentagon has 5, a hexagon has 6. While a square has 4 equal sides, a triangle can have 0, 2 or 3 equal sides."
    pattern = r"\b(" + "|".join(words) + r")\b"

    matches = re.findall(pattern, geo)

    print("Ex4; The strings that match the pattern are: ", matches)

    
    digits = re.findall(r"\d", geo)
    non_digits = re.findall(r"\D", geo)

    # Print the digits and non-digits characters
    print("The digit characters that we find are:", digits)
    print("The non-digit characters that we find are:", non_digits)

ex4()

def ex5():
    link = "https://www.newyorker.com/magazine/2021/11/01/the-book-of-form-and-emptiness-the-war-for-gloria-read-until-you-understand-and-the-end-of-bias"

    pattern = r"/(\d{4})/(\d{2})/(\d{2})/"

    matches = re.findall(pattern, link)
    print("Ex5:")
    print("Year:", matches[0][0])
    print("Month:", matches[0][1])
    print("Date:", matches[0][2])

ex5()

def ex6():
    date = "2021-11-02"

    pattern = r"(\d{4})-(\d{2})-(\d{2})"

    new_date = re.sub(pattern, r"\3-\2-\1", date)

    print("Ex6:")
    print(f"The date with the new format is: {new_date}")

ex6()    

def ex7():
    print("Ex7:")
    pattern = r"^\d"
    string1 = input("Give the first string: ")
    string2 = input("Give the second string: ")

    check1 = re.findall(pattern, string1)
    check2 = re.findall(pattern, string2)

    print(f"The status for {string1} is {check1}")
    print(f"The status for {string2} is {check2}")

ex7()

def ex8():
    print("Ex8:")
    pattern = r"\d$"
    string1 = input("Give the first string: ")
    string2 = input("Give the second string: ")

    check1 = re.findall(pattern, string1)
    check2 = re.findall(pattern, string2)

    print(f"The status for {string1} is {check1}")
    print(f"The status for {string2} is {check2}")

ex8()

def ex9():
    print("Ex9:")
    pattern = r"\d"
    string1 = input("Give the first string: ")
    string2 = input("Give the second string: ")

    check1 = re.findall(pattern, string1)
    check2 = re.findall(pattern, string2)

    print(f"The status for {string1} is {check1}")
    print(f"The status for {string2} is {check2}")

ex9()