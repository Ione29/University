import ExamFP._

class Tests extends munit.FunSuite {

  test("Valid profile id:"+profileID){
    assert(profileID > 0)
  }


  test("E1 (1p):") {
    assert(positiveValues(List(Some(1), Some(2), Some(3))) == Some(List(1,2,3)))
    assert(positiveValues(List(Some(1), None, Some(3))) == Some(List(1,3)))
    assert(positiveValues(List(None)) == Some(Nil))
    assert(positiveValues(List(Some(-1), Some(2), Some(3))) == None)
    assert(positiveValues(List(Some(-1), None, Some(3))) == None)
  }

  test("E2 (1p):"){
    assert(sumpairs(Nil) == 0)
    assert(sumpairs(List((0,1),(2,3),(4,5),(6,7),(8,9),(10,11),(12,20), (29,39), (100,1))) == 267)
  }

  test("E3 (1p):"){
    assert(howMany(Empty("")) == 0)
    assert(howMany(Single("",Empty(""))) == 0)
    assert(howMany(Double("",Empty(""),Empty(""))) == 1)
    assert(howMany(Single("",Double("",Double("",Single("", Double("",Empty(""),Empty(""))), Double("",Double("",Empty(""), Single("",Empty(""))),Empty(""))),Empty("")))) == 5)
  }

  test("E4 (1p):"){
    val c = Single("A",Double("B",Double("C",Single("D", Double("E",Empty("F"),Empty("G"))), Double("H",Double("I",Empty("J"), Single("K",Empty("L"))),Empty("M"))),Empty("N")))
    assert(ids(Empty("A")).sorted == List("A"))
    assert(ids(Single("A",Empty("B"))).sorted == List("A","B"))
    assert(ids(Double("A",Empty("B"),Empty("C"))).sorted == List("A","B","C"))
    assert(ids(c).sorted == List("A","B","C","D","E","F","G","H","I","J","K","L","M","N"))
  }

  test("E5 (1p):") {
    assert(!twoSinOneD(Empty("")))
    assert(!twoSinOneD(Single("",Empty(""))))
    assert(!twoSinOneD(Double("",Single("",Empty("")), Empty(""))))
    assert(twoSinOneD(Single("",Double("",Single("",Double("",Single("",Empty("")),Single("",Empty("")))),Empty("")))))
  }

  test("E6 (1p):") {
    val makeset = (l: List[Int]) => Set(l.map((x:Int) => (y:Int) => y == x).foldRight((x: Int) => false)((f1:Int => Boolean, f2: Int => Boolean) => (x:Int) => f1(x) || f2(x)))

    assert(inall(2,List(List(1,2), List(2,3), List(2,4)).map(makeset)))
    assert(inall(2,Nil))
    assert(!inall(2,List(Nil, Nil).map(makeset)))
    assert(!inall(2,List(1,2,3).map(List(_)).map(makeset)))

  }

  test("E7 (1p):"){
    implicit class ISet(s: Set[Int]){
      def has(x: Int): Boolean = s match {case Set(f) => f(x)}
    }
    assert(! (convert(Nil:List[Int]) has 1))
    assert(convert(List(1,2,3)) has 1)
    assert(convert(List(1,2,3)) has 2)
    assert(convert(List(1,2,3)) has 3)
    assert(!(convert(List(1,2,3)) has 4))
  }

  test("E8 (1p):"){
    assert(count(Nil) == 0)
    assert(count(List("A","B","C")) == 0)
    assert(count(List("aaaa","bbbb", "cccc")) == 0)
    assert(count(List("aaa1","bbb2", "cccc")) == 2)
  }

  test("E9 (1p):"){
    assert(cart(Nil,Nil) == Nil)
    assert(cart(Nil, List(1,2,3)) == Nil)
    assert(cart(List(1,2,3), Nil) == Nil)
    assert(cart(List(1,2,3), List(5,6,7)).sorted == List((1,5), (1,6), (1,7), (2,5), (2,6), (2,7), (3,5), (3,6), (3,7)).sorted)
  }

  test("E10 (1p):"){
    assert(pair(Nil) == Nil)
    assert(pair(List(1,2,3,4,5,6)) == List((1,2), (3,4), (5,6)))
    assert(pair(List(1,2,3,4,5,6,7)) == List((1,2), (3,4), (5,6), (7,-1)))
  }
}
