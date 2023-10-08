# I
print("I:")
list1 =["Math", "English", "History", "Chemistry", "Biology"]

#1
print("#1", list1[1])

#2
print("#2", len(list1))

#3
print("#3", list1[1:4])

#4
print("#4", list1[-4])

#5
newList = list1.copy()
newList.remove("Chemistry")
print("#5")
print("list1: ", list1)
print("newList: ", newList)

#6
newList = list1.copy()
newList.insert(2, "Geography")
print("#6")
print("list1: ", list1)
print("newList: ", newList)

#7
newList = list1.copy()
newList.remove("English")
newList.insert(1, "Romanian")
print("#7")
print("list1: ", list1)
print("newList: ", newList)

# II
print("\nII:")
dict1 = {"Fname":"Jane", "Lname":"Doe","age":23}

#1
print("#1", dict1.get("Lname"))

#2
newDict = dict1.copy()
newDict.update({"age":21})
print("#2", newDict.get("age"))

#3
dict1.update({"occupation":"student"})
print("#3", dict1)

#4
newDict = dict1.copy()
newDict.pop("Fname")
print("#4", newDict)

#5
pairsTuple = dict1.items()
print("#5", pairsTuple)

#6
valueList = dict1.values()
print("#5 valueList: ", valueList)

#7
dict1.setdefault("hobby","chess")
print("#7", dict1)

#8
dict1.clear()
print("#8", dict1)