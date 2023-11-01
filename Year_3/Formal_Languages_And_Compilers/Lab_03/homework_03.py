import maths
import random
import datetime
import os
import platform

def ex1():
    a = int(input("Give the first number: "))
    b = int(input("Give the second number: "))
    maths.sum(a, b)

#ex1()

def ex2():
    list = []
    for i in range(0, 5):
        list.append(random.randint(1, 10000))
    print("The list is: ", list)

#ex2()

def ex3():
    for i in range(1, 6):
        print(f"Number {i}: {random.randint(40, 70)}")

#ex3()

def ex4():
    currentDate = datetime.datetime.now()
    print(currentDate.strftime('%A'))

#ex4()

def ex5():
    directoryName = input("Give the name of the directory: ")
    os.makedirs(directoryName)

    fileName = input("Give the name of the file: ")
    path = f"{directoryName}/{fileName}"

    with open(path, "w") as f:
        f.write("This is line 1.\n")
        f.write("This is line 2.\n")
        f.write("This is line 3.\n")

    with open(path, "r") as f:
        lines = f.readlines()
        print("The first 2 lines of the file are:")
        print(lines[0])
        print(lines[1])

    with open(path, "w") as f:
        f.write("This is the new text.")
    
    with open(path, "r") as f:
        lines = f.readlines()
        print("The new contents of the file are:")
        print(lines)

#ex5()

def ex6():
    print("The operating system information is: ",platform.system())

#ex6()

def ex7():
    n = datetime.datetime.now() - datetime.timedelta(days=10)
    print(n)

#ex7()