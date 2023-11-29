import numpy as npy
import matplotlib.pyplot as mpl

#ex1
def ex1():
    print("Ex. 1:")
    list1 = [1.4, 5.9, 2.6, 7.3, 8.5, 9.3, 6.1]
    a1 = npy.array(list1)
    print(a1)

#ex2
def ex2():
    print("\nEx. 2:")
    print(npy.arange(70, 91, 2))

def ex3():
    print("Ex. 3:")
    m1 = npy.matrix([[3, 0, 0],
                    [0, 7, 0],
                    [0, 0, 11]])
    print(npy.diag(m1))

def ex4():
    print("\nEx. 4:")
    print(npy.arange(10, 16).reshape(2, 3))

def ex5():
    print("\nEx. 5:")
    array = npy.array([[10, 50, 70, 20, 40], [5, 45, 95, 35, 65]])

    for i in range(array.size):
        if array.item(i) < 43:
            print('below:', array.item(i))
        elif array.item(i) > 43:
            print('above:', array.item(i))

def ex6():
    print("\nEx. 6:")
    file = open('/home/ione/Documents/University/Year_3/Formal_Languages_And_Compilers/Lab_07/numbers.txt', 'w')
    file.write(str(ex5))
    file.close()
    print("File created succesfully!")


def ex7():
    print("\nEx. 7:")
    x = npy.array(["Tennis Rackets", "Baseball Bats"])
    y = npy.array([165, 349])
    
    mpl.bar(x, y, color = "yellow", width=0.5)
    mpl.title("Tennis Rackets Sold (Vertical)")
    mpl.show()

    mpl.barh(x,y, color="red", height=0.3)
    mpl.title("Tennis Rackets Sold (Horizontal)")
    mpl.show()


def ex8():
    print("\nEx. 8:")
    arrayX1 = npy.array([0, 7])
    arrayY1 = npy.array([7,  0])
    arrayX2 = npy.array([0, 11])
    arrayY2 = npy.array([0, 11])

    mpl.plot(arrayX1, arrayY1, linestyle = "-.", color = "blue", linewidth = "10")
    mpl.plot(arrayX2, arrayY2, linestyle = "-.", color = "red", linewidth = "10")
    mpl.title("Ex. 8")
    mpl.show()
    

def ex9():
    print("\nEx. 9:")
    x9 = npy.array([1, 2, 3, 4, 5])
    mycolors = ['cyan', 'blue', 'yellow', 'pink', 'red']

    mpl.pie(x9, colors = mycolors, shadow = True)
    mpl.title('Ex. 9')
    mpl.show()

ex1()
ex2()
ex3()
ex4()
ex5()
ex6()
ex7()
ex8()
ex9()