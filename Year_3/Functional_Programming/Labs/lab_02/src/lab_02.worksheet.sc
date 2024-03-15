import scala.annotation.tailrec
// ex 1: Write a tail-recursive function that computes the factorial of a natural number.
def fact (n : Int) : Int = {
    def aux_fact(i: Int, acc : Int): Int =
        if(i == 1) acc
        else aux_fact(i - 1, acc * i)
    aux_fact(n, 1) 
}

fact(11)

// ex 2: Implement a tail-recursive function that computes the greatest common divisor of a natural number: 

def gcd(a: Int, b: Int): Int = {
    if(b == 0) a
    else gcd(b, a % b)
}

gcd(21, 7)

// ex 3: Write a tail-recursive function takes an integer n and computes the value 1+2^2+3^2+…+(n−1)^2+n^2 . (Hint: use inner functions).
def sumSquares(n : Int): Int = {
    def aux_sum(i: Int, acc: Int): Int =
        if(i == 0) acc
        else aux_sum(i - 1, acc + math.pow(i, 2).asInstanceOf[Int])
    aux_sum(n, 0)
}

sumSquares(5)

// ex 4: Write a function which computes the sum of all natural numbers within a range. Use two styles to write this function: direct recursion, and tail recursion.

def sumNats(start: Int, stop : Int): Int = {
    def aux_sum(start: Int, stop: Int): Int = {
        if(start > stop) 0
        else start + aux_sum(start + 1, stop)
    }

    aux_sum(start, stop)
}

sumNats(1, 3)

def tailSumNats(start: Int, stop: Int): Int ={
    def aux_sum(start: Int, stop: Int, acc: Int): Int = {
        if(start > stop) acc
        else aux_sum(start + 1, stop, acc + start)
    }

    aux_sum(start, stop, 0)
}

tailSumNats(1, 3)

// ex 5: Write a function which takes an initial value x and a range of values x0,x1,…,xn and computes ((x−x0)−x1)−…xn . Use the most appropriate type of recursion for this task. 
// the most appropiate is tail recusrion

def tailSubtractRange(x: Int, start: Int, stop: Int): Int = {
    def aux_sub(start: Int, acc: Int): Int = {
        if(start > stop) acc
        else aux_sub(start + 1, acc - start)
    }

    aux_sub(start, x)
}

tailSubtractRange(10, 1, 4)

// ex 6: Write a function which takes an initial value x and a range of values x0,x1,…,xn and computes x0−(x1−(x2−(…−(xn−x)…) . Use the most appropriate type of recursion for this task. 
// the most appropiate is direct recursion

def directSubtractRange(x: Int, start: Int, stop: Int): Int = {
    if(start > stop) x
    else start - directSubtractRange(x, start + 1, stop)
}

directSubtractRange(10, 1, 4)

// ex 7: Implement the function improve which takes an estimate xn of √a and improves it (computes xn+1 ).

//def improve