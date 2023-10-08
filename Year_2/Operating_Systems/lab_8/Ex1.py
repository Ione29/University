from tkinter import *
import string
import os

def getFolders():
    folderPath = entry.get()
    folderPath = folderPath.replace("//", "//")
    for files in os.walk(folderPath):
        for filename in files:
           print(filename)


window = Tk()
label = Label(window, text="Enter the path: ")
label.pack()
folderPath = StringVar()
folderPath.set("path...")
entry = Entry(window, textvariable=string, width=40)
entry.pack()
button = Button(text="FIND!", command=getFolders)
button.pack()
window.mainloop()
