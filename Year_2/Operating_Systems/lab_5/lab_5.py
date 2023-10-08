import sys
import random
import time

def ex1():
    name = input("Enter your name")
    print("Greetings, " + name + "!")
    
def ex3_4():
    a = input("Give a:")
    b = input("Give b:")
    c = input("Give c:")
    d = input("Give d:")
    if a > 10 or b > 10 or c > 10 or d > 10:
        print("One or more numbers are above 10!")
    else:
        print("The result is: " + (a + b * c + d))
    
def ex4():
    try:
        a = int(input("Enter a:"))
        b = float(input("Give b:"))
    except:
        print("Error, enter numeric input!")
        sys.exit(1)

def ex5_6():
    solution = [0, 0, 0, 0]
    for i in range(4):
        solution[i] = random.randint(1, 9)
    
    solved = False
    round = 1
    startTimer = time.time()
    
    while solved == False:
        bull = 0
        cow = 0
        
        #get input
        print("Round " + round + "!")
        inp = input("Enter the code:")
        if(inp == "exit"):
            return 0
        else:
            code = inp.split()
        
        #check the code
        for i in range(4):
            if code[i] in solution:
                for j in range(4):
                    if code[i] == solution[j]:
                        bull = bull + 1
                        break
            else:
                cow = cow + 1
        
        if bull == 4:
            print("The code was guessed!")
            endTimer = time.time()
            print("Your time was: " + (endTimer - startTimer) + "!")
            return 0
        else:
            print("Bulls = " + bull + " | Cow: " + cow)
            
def ex7(readFileName, writeFileName):
    readFile = open(readFileName)
    writeFile = open(writeFileName, mode = "rw")
    
    string = readFile.read()
    
    writeFile.write(string.upper())
    
    readFile.close()
    writeFile.close()
    