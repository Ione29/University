#   print("Hello World")
#   x = 34.53
#   y = 'bruh'
#   print(type(x))
#   print(type(y))

import random

def testFunc():
    x = 2
    y = 3.456
    z = -5j
    
    print("Ints: ") 
    print(int(x), " ",  int(y))
    print("Floats: ")
    print(float(x), " ", float(y))
    print("Complex: ")
    print(complex(x), " ", complex(y), " ", complex(z))

#testFunc()

def inText():
    find = "sunt"
    text = "eu sunt un om"
    if find not in text:
        print("e ok")
    else: 
        print("nu e ok")

#inText()

def sliceIt():
    text = "acesta este un test"
    felie = text[:6]
    print(felie)

#sliceIt()

def upperLower():
    text = "bAzAt Si RoSu PaStIlAt"
    print(text)
    print(text.upper())
    print(text.lower())
    print(text.split(" "))

#upperLower()

def testList():
    list = ["mere", "pere", True, 45, 3+7j, "sunt", "un om"]
    print(type(list))
    print(list[2:5])
    print(list[:4])
    print(list[2:])
    print(list[-4:-2])
    if "mere" in list:
        print("mere e in lista")
    if "mami" not in list:
        print("mami nu e in lista")

testList()
