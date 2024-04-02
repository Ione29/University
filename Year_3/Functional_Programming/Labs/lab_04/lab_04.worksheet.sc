import scala.collection.immutable.LazyList.cons
trait IList
case object Void extends IList
case class Cons(x: Int, xs: IList) extends IList

val list1 : IList = Cons(1, Cons(2, Cons(3, Cons(4, Void))))
val list2 : IList = Cons(10, Cons(3, Cons(5, Cons(2, Cons(10, Cons(7, Void))))))
val eList: IList = Void

// 4.1. Consider the following axioms for the operator isEmpty. 
def isEmpty(list :IList) : Boolean ={
    list match {
        case Void => true
        case Cons(h, t) => false
    }
}

isEmpty(list1)
isEmpty(eList)

// 4.2. Write down axioms for size : IList → Int and implement the operator in Scala: 

def size(list: IList): Int = {
    def counter(list: IList, count: Int): Int ={
        list match {
            case Void => count
            case Cons(_, tail) => counter(tail, count + 1)
        }
    }

    counter(list: IList, 0)
}


size(list1)

// 4.3. Implement contains which checks if an element is a member of a list.

def contains(e: Int, list: IList): Boolean = 
    list match{
        case Void => false
        case Cons(x, tail) => 
            if(x == e) true 
            else contains(e, tail)
    }

contains(5, list1)

//  4.4. Implement max which returns the largest integer from a list:

def max(l: IList): Int = {
    def findMax(max: Int)(list: IList): Int ={
        list match{
            case Void => max
            case Cons(x, tail) => 
                if (x > max) findMax(x)(tail)
                else findMax(max)(tail)
        }
    }
    findMax(Int.MinValue)(l)
}

max(list1)
max(list2)

// 4.5. Implement take which returns a new list containing the first n elements of the original list:

def take(n: Int)(list: IList): IList = {
    list match{
        case Cons(x, tail) if (n > 0) => Cons(x, take(n - 1)(tail))
        case _ => Void
    }
}

take(2)(list1)
take(5)(list2)

// 4.6. Implement drop which returns a new list containing the original list without the first n elements:

def drop(n: Int)(list: IList): IList = {
    list match {
        case Cons(x, tail) if (n > 0) => drop(n - 1)(tail)
        case _ => list 
    }
}

drop(2)(list2)

// 4.7. Implement append which concatenates two lists:

/* def append(list1: IList, list2: IList): IList = {
    def aux(currentElem: IList): IList ={
        currentElem match{
            case Cons(x, tail) if (tail == Void) => Cons() = list2
            case _ => append(tail, list2)
        }  
    }
} */

// 4.8. (!) Implement last which returns the last element from a list:

def last(list: IList): Int ={
    list match{
        case Cons(x, Void) => x 
        case Cons(x, Cons(xs, xss)) => last(Cons(xs, xss))
        case Void => throw new IllegalArgumentException("The List is empty")
    }
}

last(list1)
last(list2)
//last(eList)


