import math
#find the n-th prime 


if __name__ == "__main__":
    n = int(input("Give n: "))

    result = (math.factorial(n) % (n + 1) / n ) * (n - 1) + 2

    print (result)
