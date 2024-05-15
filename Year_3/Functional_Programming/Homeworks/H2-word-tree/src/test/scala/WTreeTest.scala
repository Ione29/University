import Main._



class WTreeTest extends munit.FunSuite {

  test("Valid profile id:"+profileID){
    assert(profileID > 0)
  }

  test("split: Simple split test (10p)"){
    val s = 'T' :: 'h' :: 'i' :: 's' :: ' ' :: 'i' :: 's' :: ' ' :: 'a' :: ' ' :: 't' :: 'e' :: 's' :: 't' :: Nil
    assert(split(s) == List(List('T','h','i','s'), List('i', 's'), List('a'), List('t','e','s','t')))
  }

  test("split: Making sure trailing whitespace is handled correctly (5p)"){
    val s = List('T','e','s','t',' ')
    assert(split(s) == List(List('T','e','s','t')))
  }

  test("split: multiple consecutive whitespaces (5p)"){
    val s = List(' ', ' ', ' ')
    assert(split(s) == Nil)
  }

  test("computeTokens: Simple test (5p)"){
    val l = List("a","b","c")
    val r = Set(new Token("a",1), new Token("b",1), new Token("c",1))
    assert(computeTokens(l).toSet == r)
  }

  test("computeTokens: Multiple occurrences (10p)"){
    val l = List("ba", "ma", "ta", "ma", "ba", "ma")
    val r = Set(new Token("ma",3), new Token("ta",1), new Token("ba",2))
    assert(computeTokens(l).toSet == r)

  }

  test("makeTree: nonempty (10p)"){
    val l = List("ma", "ba", "ta", "ma", "ba", "ma")
    val t = Node(Token("ba",2), Node(Token("ta",1), Empty, Empty), Node(Token("ma",3),Empty,Empty))
    assert(makeTree("ba ma ta ma ba ma") == t)
  }
  test("makeTree: empty tree (5p)"){
    assert(makeTree("  ") == Empty)
  }

  test("size: empty tree (2p)"){
    assert(makeTree(" ").size == 0)
  }

  test("size: nonempty (3p)"){
    val l = List("ma", "ba", "ta", "ma", "ba", "ma")
    assert(makeTree("ba ma ta ma ba ma").size == 3)
  }

  test("contains: empty tree (2p)"){
    assert(!makeTree(" ").contains("text"))
  }

  test("contains: non-empty tree (3p)"){
    assert(makeTree("ba ma ta ma ba ma").contains("ta"))
    assert(makeTree("ba ma ta ma ba ma").contains("ma"))
    assert(makeTree("ba ma ta ma ba ma").contains("ba"))
  }

  test("filter: Simple test 1 (5p)"){
    assert(makeTree("ba ma ta ma ba ma").filter(_.word == "ma").contains("ma"))
  }

  test("filter: Simple test 2 (5p)"){
    assert(!makeTree("ba ma ta ma ba ma").filter(_.word != "ma").contains("ma"))
  }

  test("filter: Simple test with empty tree after filtering (10p)"){
    assert(!makeTree("ba ma ta ma ba ma").filter(_ => false).contains("ma"))
  }

  test("Scala keyword frequency (5p)"){
    assert(scalaFreq == 11)
  }

  test("How many programming languages (10p)"){
    assert(progLang == 8)
  }

  test("How many words (5p)"){
    assert(wordCount == 139)
  }

}

