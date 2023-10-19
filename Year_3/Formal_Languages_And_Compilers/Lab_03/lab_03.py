import random
import math
import datetime

def ex1():
    x = datetime.datetime.now()
    print(x, x.strftime('%B'))

#ex1()

def ex2():
    radius = int(input("Give the radius of a circle: "))
    area = pow(radius, 2) * math.pi
    print(f"The area of the circle is: {area}")

#ex2()

def ex3():
    list = [1, 2, 3, 4, 5]
    number = random.choice(list)
    print("The list is: ", list)
    print(f"A random number from the list is: {number}")

#ex3()

def ex4():
    list = [1, 2, 3, 4, 5]
    print("The initial list was: ", list)
    random.shuffle(list)
    print("The new list is: ", list)

#ex4()

def ex5():
    a = int(input("Give the first number: "))
    b = int(input("Give the second number: "))
    print(f"The greatest common divisor of {a} and {b} is: {math.gcd(a, b)}")
    print(f"The least common multiple of {a} and {b} is: {math.lcm(a, b)}")

#ex5()

def ex6():
    number = int(input("Give a number: "))
    print(f"The factorial of {number} is {math.factorial(number)}")

#ex6()

def ex7():
    date = datetime.datetime.now()
    weekNumber = date.isocalendar()[1]
    print(f"This week is number {date.isocalendar()[1]}")

#ex7()

def ex8():
    x1 = int(input("Give the x coordinate of the first point: "))
    y1 = int(input("Give the y coordinate of the first point: "))
    x2 = int(input("Give the x coordinate of the second point: "))
    y2 = int(input("Give the y coordinate of the second point: "))
    distance = math.sqrt(pow(x1 - x2, 2) + pow(y1 - y2, 2))
    print(f"The distance between ({x1}, {y1}) and ({x2}, y2) is: {distance}")

ex8()