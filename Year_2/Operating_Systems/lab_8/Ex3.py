from tkinter import *

def factorial(n):
    factorial = 1
    for i in n:
        factorial *= i
    result.config(text=factorial)
    

def power():
    power = int(mEntry.get()) * int(nEntry.get())
    result.config(text=power)


window = Tk()
window.title("Factorial and power")
mEntry = Entry(text='m')
mEntry.pack()
nEntry = Entry(text="n")
nEntry.pack()
factBtn = Button(text="FACTORIAL!", command=factorial(mEntry.get()))
factBtn.pack()
powBtn = Button(text="POWER!", command=power())
powBtn.pack()
result = Label(text="result")
result.pack()
window.mainloop()