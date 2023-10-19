import maths
import random
import datetime
import os

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
    os.makedirs("madeDir")
    os

def ex6():
    systemInfo = os.uname()
    print("The operating system information is: ", systemInfo[0])

#ex6()