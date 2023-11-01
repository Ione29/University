def ex1():
    print("Ex.1:")
    string = input("Give a string:")

    flag = True

    if len(string) == 0:
        flag = False

    for char in string:
        if char != "1":
            flag = False

    if flag is False:
        print(f"The string {string} does not belong to the language \"1+\"")
    else:
        print(f"The string {string} belongs to the language \"1+\"")

ex1()

def ex2():
    print("Ex.2:")
    string = input("Give a string:")
    state = 0
    flag = True
    for char in string:
        if state == 0:
            if char == '0':
                state = 1
            else:
                flag = False
        elif state == 1:
            if char == '0':
                state = 2
            else:
                flag = False
        elif state == 2:
            if char == '0':
                state = 1
            elif char == '1':
                state = 3
            else:
                flag = False
        elif state == 3:
            if char == '1':
                state = 3
            else:
                flag = False

    if flag is True:
        print(f"{string} belongs to the language")
    else:
        print(f"{string} does not belong to the language")
        
ex2()

def ex3():
    ok = True
    string = input("Give the string:")

    if(string[0] != string[len(string)-1]):
        ok = False

    if ok == True:
        print (f"{string} does belong to the language")
    else: 
        print (f"{string} does not belong to the language")

ex3()