def sumOfDivizors(number):
    sum = 0
    for i in range(1, number - 1):
        if number % i == 0:
            sum = sum + i
            
    return sum

if __name__ == "__main__":
    number = int(input("Give a number: "))
    print("All the perfect numbers up to " + str(number) + " are: ")
    
    for i in range(1, number):
        if i == sumOfDivizors(i):
            print(i)
    
    
