object ExamFP {

  def profileID = 294083

  /*
    1. Write a function which takes a list of int values "boxed" as options: a "box" is
    either empty of contains an integer.
    The function should return a "boxed" list of integers, if _all_ non-empty "boxes" are strictly
    positive, and None, otherwise.
   */
  def positiveValues(l: List[Option[Int]]): Option[List[Int]] = {
    if (l.flatten.forall(_ > 0)) Some(l.flatten) else None 
  }
  /*
    2. Write a function that takes a list of pairs (xi,yj) from i = 0,n-1 and
    computes x0 + x1 + ... xn-1 + y0 + y1 + ... + yn-1.
   */

  def sumpairs(l: List[(Int,Int)]): Int = {
    // apply the lambda function to all of the pairs and get the sum of them
    l.map { case (x, y) => x + y}.sum
  }

  trait Container
  case class Empty(id: String) extends Container
  case class Single(id: String, e: Container) extends Container
  case class Double(id: String, e1: Container, e2: Container) extends Container

/*
    3. Write a function which takes an arbitrary container c, and counts
       the number of possibly nested "double" containers it contains.
   */

  def howMany(c: Container): Int = ???

  /*
     4. Write a function that takes a container and returns the ids of all possible
     nested containers it contains, including itself.
   */
  def ids(c: Container): List[String] = {
    c match {
      //empty container, get just his id
      case Empty(id) => List(id)
      //single container, get his id and the container that's stored
      case Single(id, e) => id :: ids(e)
      //double container, get his id and the id's of the 2 inner containers
      case Double(id, e1, e2) => id :: ids(e1) ::: ids(e2)
    }
  }

  /* 5. Write a function which checks if there is at least one "Double" container
        containing two Single containers, in a container c.
   */
  def twoSinOneD(c: Container): Boolean = ???

  case class Set[A](f: A => Boolean)
  
  /*  
    6. Given a list of sets represented using characteristic functions and
         a value x, check if x belongs in all sets.
  */

  def inall[A](x: A, l: List[Set[A]]): Boolean = {
    //for all sets in the list, check if the f(x) function gets true
    //if even one fails, we get false
    l.forall(_.f(x))
  }
  
  /*
      7. Convert a list of values of type A to a Set of type A.
   */
  def convert[A](l: List[A]): Set[A] = {
    Set(l.contains)
  }  

  /*
  8. Count the number of strings of length larger than 3, whose fourth character
      is a digit.
  */
  def count(l: List[String]): Int = {
    //self explanatory
    l.count(s => s.length > 3 && s.charAt(3).isDigit)
  }

  /*
      9. Build the cartesian product of two lists.
   */
  def cart[A,B](l: List[A], lp: List[B]): List[(A,B)] = ???

  /*
    10. From a list of x1, x2, ... xn, build a list of pairs
    (x1,x2), (x3,x4), ... (xn-1, xn) if n is even and
    (x1,x2), (x3,x4), .... (xn, -1) otherwise
   */
  def pair(l: List[Int]): List[(Int,Int)] = {
    // even size case
    if (l.length % 2 == 0) {
      l.grouped(2).map { case List(x, y) => (x, y) }.toList
    } 
    // odd size case
    else {
      l.grouped(2).collect { case List(x, y) => (x, y) }.toList :+ (l.last, -1) 
    }
  }
}
