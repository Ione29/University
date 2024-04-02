object FSets{

  type Set = Int => Boolean

  def profileID: Int = ???

  def member(e: Int)(s: Set): Boolean = ???

  def singleton(x: Int): Set = ???

  def ins(x: Int)(s: Set): Set = ???

  def fromBounds(start: Int, stop: Int): Set = ???

  def union (s1: Set, s2: Set): Set = ???

  def complement(s1: Set): Set = ???

  def sumSet(b: Int)(start: Int, stop: Int)(s: Set): Int = {
    def aux(crt: Int, acc: Int): Int = ???
    ???
  }

  def foldLeftSet(b:Int)(op: (Int,Int) => Int)(start: Int, stop: Int)(s: Set): Int = {
    def aux(crt: Int, acc: Int): Int = ???
    ???
  }

  def foldRightSet(b:Int)(op: (Int,Int) => Int)(start: Int, stop: Int)(s: Set): Int = ???

  def filter(p: Int => Boolean)(s: Set): Set = ???

  def partition(p: Int => Boolean)(s: Set): (Set,Set) = ???

  def forall(cond: Int => Boolean)(start: Int, stop: Int)(s: Set): Boolean = ???

  def exists(cond: Int => Boolean)(start: Int, stop: Int)(s: Set): Boolean = ???

  def setOfDivByK(k: Int): Set = ???

  def moreDivs(k: Int)(start: Int, stop:Int)(s1: Set, s2: Set): Boolean = ???

}
