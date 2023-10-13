#1.
def ex1():
    print("Excersise 1:")
    for i in range(40, 71):
        if i % 3 == 0:
            print(i)    

#2
def ex2():
    print("Excersise 2:")
    firstName = input("Enter your first name: ")
    lastName = input("Enter your last name: ")
    nameList = [firstName, lastName]
    nameList.reverse()
    print(nameList)

#3
def ex3():
    print("Excersise 3:")
    number = int(input("Give a number:"))
    sum = 0
    for i in range(1, number + 1):
        sum += i
    print("The sum from 1 to ", number, " is ", sum)

#4
def ex4():
    print("Excersise 4:")
    for i in range(1, 11):
        if i < 5:
            print(i, "Failure")
        else:
            print(i, "Success")

#5
def ex5():
    print("Excersise 5:")
    text = "Welcome to the lab!"
    charCount = {}
    charCount.update({"m":text.count("m")})
    charCount.update({"l":text.count("l")})
    charCount.update({"c":text.count("c")})
    charCount.update({"a":text.count("a")})
    charCount.update({"e":text.count("e")})
    print(charCount)

#6
def ex6():
    print("Excersise 6:")
    number = int(input("Give a number:"))
    factorial = 1
    for i in range(1, number + 1):
        factorial *= i
    print("The factorial of ", number, " is ", factorial)

#7
def ex7():
    print("Excersise 7:")
    number = int(input("Give a number: "))
    if number <= 100:
        number *= 3
        number -= 200
    else:
        number /= 2
        number += 20
    print("The new number is ", number)

#8
def ex8():
    print("Excersise 8:")
    numbers = input("Give the numbers, separated by a \",\":")
    numbersList = numbers.split(",")
    print(numbersList)
    numbersTuple = tuple(map(int, numbers.split(",")))
    print(numbersTuple)

#9
def ex9():
    print("Excersise 9:")
    number = int(input("Give a number:"))
    for i in range(1, number + 1):
        print(i * i)

ex1()
ex2()
ex3()
ex4()
ex5()
ex6()
ex7()
ex8()
ex9()
