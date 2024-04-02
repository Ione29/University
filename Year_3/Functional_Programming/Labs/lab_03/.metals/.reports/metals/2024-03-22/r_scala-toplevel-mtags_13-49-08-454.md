error id: file://<WORKSPACE>/src/main/scala/lab_03.worksheet.sc:[4258..4262) in Input.VirtualFile("file://<WORKSPACE>/src/main/scala/lab_03.worksheet.sc", "import scala.annotation.tailrec
//recap:

//lambda
val f: Int => Int = x => x * x

//higher-order functions
def sumWithF(start: Int, stop: Int, f: Int => Int): Int ={
    def aux(crt: Int, acc: Int): Int = 
        if(crt > stop) acc
        else aux(crt + 1, acc + f(crt))

    aux(start, 0)
}


sumWithF(1, 7, f)

// curry functions

def f(x: Int)(y: Boolean)(z: Char): String = x.toString + y.toString + z.toString

val g: Boolean => Char => String = f(2)

g(true)('a')

// x, y) => x + y IS THE SAME THING AS (_ + _)

//3.1. Define the function foldWith which uses an operation op, and an initial value b to reduce a range of integers to a value. For instance, given that op is addition (+), the result of folding the range 1 to 3 with b = 0 will be ( ( 0 + 1 ) + 2 + 3 = 6. foldWith should be curried (it will take the operation and return another function which expects the bounds). 

def foldWith(op: (Int, Int) => Int)(res: Int)(start: Int, stop: Int): Int = {
    def aux(crt: Int, acc: Int): Int =
        if (crt > stop) acc
        else aux(crt + 1, op(acc, crt))

    aux(start, res)
}

// 1 + 2 + 3 = 6
foldWith(_ + _)(0)(1, 3)

//3.2. Define the function foldConditional which extends foldWith by also adding a predicate p: Int ⇒ Int. foldConditional will reduce only those elements of a range which satisfy the predicate.

def foldConditional(res: Int)(op: (Int,Int) => Int, conditionalFunction: Int => Boolean)(start: Int, stop: Int): Int = {
    def aux(crt: Int, acc: Int): Int ={
        if(crt > stop) acc
        else if (conditionalFunction(crt) == true) aux(crt + 1, acc)
        else aux(crt + 1, op(crt, acc))
    }

    aux(start, res)
}

def conditionalFunction(x: Int) : Boolean ={
    if(x % 2 == 0) true
    else false
}

// 1 + 3 + 5 + 7 + 9 = 25
foldConditional(0)(_ + _, conditionalFunction)(1, 10)

//3.3. Implement the function foldRight which has the same behaviour as foldWith, but the order in which the operation is performed is now: 1+(2+(3+0))=6. What is the simplest way to implement it? 

//easiest way is direct recursion; foldWith si implemented as tail recursion

def foldRight(op: (Int, Int) => Int)(start: Int, stop: Int): Int = {
    def aux(crt: Int): Int ={
        if(crt > stop) 0
        else op(crt, aux(crt + 1))
    }

    aux(start)
}

foldRight((x, y) => x + y)(1, 5)

//3.4. Write a function foldMap which takes values a1,a2,…,ak from a range and computes f(a1) op f(a2) op …f(ak)

val func: Int => Int = x => x * x

def foldMap(op: (Int,Int) => Int, f: Int => Int)(start: Int, stop: Int): Int = {
    def auxSum(crt: Int, acc: Int): Int = 
        if(crt > stop) acc
        else auxSum(crt + 1, op(f(crt), acc))

    auxSum(start, 0)
}

foldMap(_ + _, func)(1, 3)

//3.5. Write a function which computes 1+2^2+3^2+…+(n−1)^2+n^2 using foldMap.

def sumSquares(n: Int): Int ={
    foldMap((x, y) => x + y, x => x * x)(1, n)
}

sumSquares(5)

//3.6. Write a function hasDivisor which checks if a range contains a multiple of k. Use foldMap and choose f carefully.
/* 
def hasDivisor(k: Int, start: Int, stop: Int): Boolean = {
    foldMap((x, y) => x || y, x => x % k == 0)(start, stop)
} */

//hasDivisor(9, 13, 19)

/* 
3.7. We can compute the sum of an area defined by a function within a range a,b (the integral of that function given the range), using the following recursive scheme:
 - if the range is small enough, we treat f as a line (and the area as a trapeze). It's area is (f(a)+f(b))(b−a)/2
 - otherwise, we compute the mid of the range, we recursively compute the integral from a to mid and from mid to b, and add-up the result.
Implement the function integrate which computes the integral of a function f given a range:
 */
def integrate(f: Double => Double)(start: Double, stop: Double, eps: Double = 1e-6): Double = {
    val mid = (start + stop) / 2
    if (stop - start < eps) (f(start) + f(stop)) * (stop - start) / 2
    else integrate(f)(start, mid, eps) + integrate(f)(mid, stop, eps)
}

integrate(x => x * x)(0, 1)
// 3.8. We define Line2D to be lines in a 2-dimensional space, and we represent them as functions. Write a function which takes a Line2D and translates it up on the Ox axis by a given offset. For instance, translateOx of 2 on y=x+1 will return y=x+3.

object type Line2D{
    type coord = Int
}

def translateOx(offset: Int)(l: Line2D): Line2D = {

}")
file://<WORKSPACE>/src/main/scala/lab_03.worksheet.sc
file://<WORKSPACE>/src/main/scala/lab_03.worksheet.sc:122: error: expected identifier; obtained type
object type Line2D{
       ^
#### Short summary: 

expected identifier; obtained type