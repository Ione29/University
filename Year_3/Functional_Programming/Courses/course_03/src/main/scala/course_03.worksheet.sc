/* def sumInt(start : Int, stop: Int): Int = {
    def loop(i : Int, acc: Int): Int = {
        if(i > stop)  acc
        else loop(i + 1, acc + i)
    }

    loop(start, 0)
}

/* 
    [start, stop]
    x0, x1, x2, ...., xn
    x0^2, x1^2, ....., xn^2
*/

def sumSquares(start: Int, stop: Int): Int = {
    def loop(i : Int, acc: Int): Int =
        if(i > stop) acc
        else loop(i + 1, i*i + acc)

    loop(start, 0)
}
 */
def sumWithF(f: Int => Int, start: Int, stop: Int): Int = {
    def loop(i: Int, acc: Int): Int =
        if(i > stop) acc
        else loop(i + 1, f(i) + acc)

    loop(start, 0)
}

def sumInt(start:Int, stop: Int): Int = sumWithF(x => x, start, stop)
def sumSquares(start: Int, stop: Int): Int = sumWithF(x => x * x, start, stop)

def compose(f: Int => Int, g: Int => Int): Int => Int ={
    x => f(g(x))
}