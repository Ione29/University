import FSets._

class FSetsTests extends munit.FunSuite {

  val empty: Int => Boolean = x => false

  test("Valid profile id:"+profileID){
    assert(profileID > 0)
  }

  test("Member (0p):"){
    assert(!member(1)(empty))
    assert(!member(10)(empty))
  }

  test("Singleton (0p):"){
    assert(member(1)(singleton(1)))
    assert(member(10)(singleton(10)))
    assert(!member(1)(singleton(2)))
  }

  test("Ins (0p):"){
    assert(member(1)(ins(1)(singleton(0))))
    assert(member(0)(ins(1)(singleton(0))))
    assert(!member(2)(ins(1)(singleton(0))))
  }

  test("From bounds (4p):"){
    assert(member(1)(fromBounds(1,3)))
    assert(member(2)(fromBounds(1,3)))
    assert(member(3)(fromBounds(1,3)))
    assert(!member(4)(fromBounds(1,3)))
  }

  test("Union (4p):"){
    assert(member(1)(union(singleton(1),singleton(2))))
    assert(member(2)(union(singleton(1),singleton(2))))
    assert(!member(0)(union(singleton(1),singleton(2))))
  }

  test("Complement (2p):"){
    assert(!member(1)(complement(singleton(1))))
    assert(member(0)(complement(singleton(1))))
  }

  test("sumSet (15p):"){
    assert(sumSet(0)(1,1)(singleton(1)) == 1)
    assert(sumSet(99)(1,1)(singleton(1)) == 100)
    assert(sumSet(99)(1,1)(singleton(0)) == 99)
    assert(sumSet(99)(2,1)(singleton(2)) == 99)
    assert(sumSet(0)(1,3)(union(singleton(1),union(singleton(2),singleton(3)))) == 6)
  }

  test("FoldLeftSet (15p):"){
    assert(foldLeftSet(0)(_ + _)(1,1)(singleton(1)) == 1)
    assert(foldLeftSet(99)(_ + _)(1,1)(singleton(1)) == 100)
    assert(foldLeftSet(99)(_ + _)(1,1)(singleton(0)) == 99)
    assert(foldLeftSet(99)(_ + _)(2,1)(singleton(2)) == 99)
    assert(foldLeftSet(0)(_ + _)(1,3)(union(singleton(1),union(singleton(2),singleton(3)))) == 6)
    assert(foldLeftSet(100)(_ - _)(1,3)(union(singleton(1),union(singleton(2),singleton(3)))) == 94)
  }
  test("FoldRightSet (15p):"){
    assert(foldRightSet(0)(_ + _)(1,1)(singleton(1)) == 1)
    assert(foldRightSet(99)(_ + _)(1,1)(singleton(1)) == 100)
    assert(foldRightSet(99)(_ + _)(1,1)(singleton(0)) == 99)
    assert(foldRightSet(99)(_ + _)(2,1)(singleton(2)) == 99)
    assert(foldRightSet(0)(_ + _)(1,3)(union(singleton(1),union(singleton(2),singleton(3)))) == 6)
    assert(foldRightSet(0)(_ - _)(1,3)(union(singleton(1),union(singleton(2),singleton(3)))) == 2)
  }
  test("Filter (4p):"){
    assert(!member(1)(filter(_ %2 == 0)(union(singleton(1),union(singleton(2),singleton(3))))))
    assert(member(2)(filter(_ %2 == 0)(union(singleton(1),union(singleton(2),singleton(3))))))
    assert(!member(3)(filter(_ %2 == 0)(union(singleton(1),union(singleton(2),singleton(3))))))
  }
  test("Partition (4p):"){
    val pair = partition(_%2 == 0)(union(singleton(1),union(singleton(2),singleton(3))))
    assert(!member(1)(pair._1))
    assert(member(2)(pair._1))
    assert(!member(3)(pair._1))
    assert(member(1)(pair._2))
    assert(!member(2)(pair._2))
    assert(member(3)(pair._2))

  }

  test("Forall (15p):"){
    assert(forall(_ => false)(0,100)(empty))
    assert(forall(_ % 2 == 0)(0,100)(filter(_ % 2 == 0)(fromBounds(0,100))))
    assert(!forall(_ % 2 == 0)(0,100)(union(singleton(1),filter(_ % 2 == 0)(fromBounds(0,100)))))
  }

  test("Exists (4p):"){
    assert(!exists(_ => true)(0,100)(empty))
    assert(!exists(_ % 2 == 0)(0,100)(filter(_ % 2 == 1)(fromBounds(0,100))))
    assert(exists(_ % 2 == 0)(0,100)(union(singleton(1),filter(_ % 2 == 0)(fromBounds(0,100)))))
  }

  test("Set of div by k (3p):"){
    assert(member(2)(setOfDivByK(2)))
    assert(member(22)(setOfDivByK(11)))
    assert(member(49)(setOfDivByK(7)))
    assert(!member(2)(setOfDivByK(7)))
  }

  test("MoreDivs (15p):"){
    assert(moreDivs(2)(0,100)(union(singleton(2),singleton(4)), singleton(2)))
    assert(moreDivs(2)(0,100)(setOfDivByK(2),setOfDivByK(4)))
    assert(!moreDivs(7)(0,100)(setOfDivByK(49),setOfDivByK(7)))

  }


}
