/* val n = 5
var i = 1
var factorial = 1

while(i <= n){
    factorial *= i
    i += 1
}

factorial

"matei"
1 + 2

if(1 == 2) true //this is not a nice expression
if(1 == 2) true else false //this is good becuase we define both cases

val m = 5

def fact(n : Int): Int = {
    if (n == 0) 1
    else n* fact(n - 1)
}

fact(5)

// we are given with an interval [a, b] and we want to tcheck if there is a prime number between a and b

def checkPrime(a: Int, b: Int): Boolean = {
    
    def isPrime(i: Int, n: Int): Boolean = {
        if(i >= n) true
        else if(n % i == 0) false
        else isPrime(i + 1, n)
    }

    if(isPrime(2, a)) true
    else if (a == b) false
    else checkPrime(a + 1, b)   
}

checkPrime(8, 10)
checkPrime(10, 20)

//implement a function that computes the fibonacci number
 */

def findFibo(n: Float, res: Float): Float = {
    if (n < 0) 0
    else if(n == 0) res
    else findFibo(n - 1, res + n)
}

findFibo(10100, 0)
