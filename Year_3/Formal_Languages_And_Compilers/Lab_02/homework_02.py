#1
def ex1():
    fibonacciSequence = [0, 1]
    number = int(input("Give a number:"))
    for i in range(2, number):
        fibonacciSequence.append(fibonacciSequence[i - 1] + fibonacciSequence[i - 2])

    print(fibonacciSequence)

#2
def ex2():
    m = int(input("Give the first number:"))
    n = int(input("Give the second number:"))
    o = m
    p = n

    while n != m:
        if n > m:
            n -=m
        else:
            m -=n

    print("The great common divisor of ", o, " and ", p, " is: ", m)

def ex3():
    m = int(input("Give the first number:"))
    n = int(input("Give the second number:"))
    smaller = min(m, n) 
    bigger = max(m, n) 
    for i in range(bigger, m*n+1, bigger): 
        if i % smaller == 0: 
            print("The least coommon multiple of ", m, " and ", n, " is ", i)
            return 0

def ex4():
    numbers = input("Give the list of numbers, separated by a space:")
    oddList = []
    evenList = []
    numbersList = numbers.split(" ")
    for i in range(0, len(numbersList) - 1):
        if numbersList[i] % 2 == 1:
            oddList.append(numbersList[i])
        else:
            evenList.append(numbersList[i])
    
    print("oddList = ", oddList)
    print("evenList = ", evenList)

class Cube:
    def __init__(self, length):
        self.length = length

    def sideArea(self):
        return pow(self.length, 2)
    
    def fullArea(self):
        return 6 * self.sideArea()
    
    def volume(self):
        return pow(self.length, 3)

def ex5():
    cube = Cube(int(input("Give the length of the cube")))
    print("The area of one side of the cube is: ", cube.sideArea())
    print("The area of the all sides of the cube is: ", cube.fullArea())
    print("The volume of the cube is: ", cube.volume())

def ex6():
    x = int(input("Give the numerator of the power: "))
    y = int(input("Give the denominator of the power: "))
    z = int(input("Give the base:"))
    newNumerator = lambda x, z: x ** z 
    newDenominator = lambda y, z : y ** z
    
    print(f"{z} raised to the power of {x}/{y} is {newNumerator(z, x)} / {newDenominator(z, y)}")

ex6()