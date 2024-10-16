object FSets {
  type Set = Int => Boolean

  def profileID: Int = 294083

  //2. Write a function member which takes an integer e and a set s and checks if e∈s . Note that member should be defined and called as a curry function:
  def member(e: Int)(s: Set): Boolean = s(e)

  //1. Write a function singleton which takes an integer and returns the set containing only that integer:
  def member(x: Int): Set = (e: Int) => e == x

  //3. Write a function ins which inserts a new element in a set. More precisely, given x and s , ins returns the new set {x}∪s .
  def ins(x: Int)(s: Set): Set = (e: Int) => e == x || s(e)

  //4. Write a function fromBounds which takes two integer bounds start and stop and returns the set {start,start+1,…,stop} . It is guaranteed that start≤stop (you do not need to check this condition in your implementation).
  def fromBounds(start: Int, stop: Int): Set = (e: Int) => e >= start && e <= stop

  //5. Write the function which performs the union of two sets:
  def union(s1: Set, s2: Set): Set = (e: Int) => s1(e) || s2(e)

  //6. Write a function which computes the complement of a set with respect to the set of integers:
  def complement(s1: Set): Set = (e: Int) => !s1(e)

  //7. Write a function which computes the sum b+e0+e1+…en where each ei is in the interval [start,stop] and also in s . Use a tail-end recursive function:
  def sumSet(b: Int)(start: Int, stop: Int)(s: Set): Int = {
    @annotation.tailrec
    def aux(crt: Int, acc: Int): Int =
      if (crt > stop) acc
      else if (s(crt)) aux(crt + 1, acc + crt)
      else aux(crt + 1, acc)

    aux(start, 0) + b
  }

  // 8. Generalise the previous function such that we can fold a set using any binary commutative operation over integers. Make sure this is a left fold: Folding the set: {x,y,z} with initial value b should produce: ( (b op x) op y) op z
  def foldLeftSet(b: Int)(op: (Int, Int) => Int)(start: Int, stop: Int)(s: Set): Int = {
    @annotation.tailrec
    def aux(crt: Int, acc: Int): Int =
      if (crt > stop) acc
      else if (s(crt)) aux(crt + 1, op(acc, crt))
      else aux(crt + 1, acc)

    aux(start, b)
  }

  //9. Implement an alternative to the previous function, namely foldRight. Applying foldRight on the set {x,y,z} with initial value b should produce``: x op (y op (z op b)). Use direct recursion instead of tail recursion.
  def foldRightSet(b: Int)(op: (Int, Int) => Int)(start: Int, stop: Int)(s: Set): Int = {
    def aux(crt: Int): Int =
      if (crt > stop) b
      else if (s(crt)) op(crt, aux(crt + 1))
      else aux(crt + 1)

    aux(start)
  }

  //10. Implement operation filter which takes a set and returns the set containing only those elements e for which p(e) is true:
  def filter(p: Int => Boolean)(s: Set): Set = (e: Int) => s(e) && p(e)

  //11. Implement a function which partitions a set into two sets. The left-most contains those elements that satisfy the predicate p , while the right-most contains those elements that do not satisfy the predicate. Use pairs. A pair is constructed with simple parentheses. E.g. (1,2) is a pair of two integers. Suppose val p: (Int,Int) is a pair of two integers. Then p._1 is the left-most part of the pair while p._2 is the right-most part of the pair.
  def partition(p: Int => Boolean)(s: Set): (Set, Set) = (filter(p)(s), filter(!p(_))(s))

  //12. Implement a function forall which checks if all elements in a given range from a set satisfy the predicate p . (For instance p might be used to describe even numbers).
  def forall(cond: Int => Boolean)(start: Int, stop: Int)(s: Set): Boolean = {
    @annotation.tailrec
    def aux(crt: Int): Boolean =
      if (crt > stop) true
      else if (s(crt)) cond(crt) && aux(crt + 1)
      else aux(crt + 1)

    aux(start)
  }

  //13. Implement a function exists which checks if a predicate holds for some element from the range of a set. Hint: it is easier to implement exists using the logical relation: ∃x.P(X)⟺¬∀x.¬P(X) .
  def exists(cond: Int => Boolean)(start: Int, stop: Int)(s: Set): Boolean = {
    @annotation.tailrec
    def aux(crt: Int): Boolean =
      if (crt > stop) false
      else if (s(crt)) cond(crt) || aux(crt + 1)
      else aux(crt + 1)

    aux(start)
  }

  //14. Implement the function setOfDivByK which returns the set of integers divisible by a value k. Use the appropriate functions you have defined previously in the homework.
  def setOfDivByK(k: Int): Set = {
    //(e: Int) => true <----- a set that contains all of the integers
    filter((e: Int) => e % k == 0)((e: Int) => true)

    //(e: Int) => e % k == 0 <----- In my opinion, using this makes a lot more sense than having to especially call filter
  }

  //15. Implement the function moreDivs which verifies if set1 contains more divisors of k than set2, over the range [start,stop]. Use any combination of the previous functions you have defined for your implementation.
  def moreDivs(k: Int)(start: Int, stop: Int)(s1: Set, s2: Set): Boolean = {
    val count1 = foldLeftSet(0)((acc, crt) => if (crt % k == 0) acc + 1 else acc)(start, stop)(s1)
    val count2 = foldLeftSet(0)((acc, crt) => if (crt % k == 0) acc + 1 else acc)(start, stop)(s2)

    count1 > count2
  }
}
