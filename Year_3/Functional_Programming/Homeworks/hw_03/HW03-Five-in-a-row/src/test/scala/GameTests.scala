
class GameTests extends munit.FunSuite {

  test("Valid profile id:" + Board.profileID) {
    assert(Board.profileID > 0)
  }

    val small =
      """0.X
        |0X.
        |X..""".stripMargin.replace("\r\n","\n")

    val medium1 =
      """00000
        |0000X
        |000..
        |00.0.
        |0X..0""".stripMargin.replace("\r\n","\n")

    val aboveFstDiag1 =
      """00..
        |00.
        |0X
        |0""".stripMargin.replace("\r\n","\n")

    val aboveSndDiag1 =
      """0000
        |000
        |00
        |0""".stripMargin.replace("\r\n","\n")

    val belowSndDiag1 =
      """X..X
        |.0.
        |..
        |0""".stripMargin.replace("\r\n","\n")

    val medium2 =
      """0X0X0.
        |000.X0
        |0.0X..
        |0..0..
        |0X..0X
        |...X..""".stripMargin.replace("\r\n","\n")

  val aboveFstDiag2 =
    """X0X.X
      |0...
      |XX.
      |00
      |.""".stripMargin.replace("\r\n","\n")

  val belowFstDiag2 =
    """0....
      |0..X
      |0X.
      |0.
      |.""".stripMargin.replace("\r\n","\n")

  val aboveSndDiag2 =
    """0.0.0
      |X0.0
      |000
      |X0
      |0""".stripMargin.replace("\r\n","\n")

  val belowSndDiag2 =
    """0.0..
      |....
      |.0X
      |X.
      |.""".stripMargin.replace("\r\n","\n")


     test("isFree implementation (0p) "){
       assert(Board(small).isFree(2,2))
       assert(!Board(small).isFree(0,0))
     }

    test("Complement implementation (0p)"){
      assert(One.complement == Two)
      assert(Two.complement == One)
      assert(Empty.complement == Empty)
    }

    test("Showing a small board (5p)"){
        assert(small == Board(small).toString)
      }

    test("Showing a medium board (10p)"){
      assert(medium1 == Board(medium1).toString)
    }

    test("Retrieving the list of columns (0p)"){
      assert(Board(medium1).getColumns == Board(medium1))
      //assert(getColumns(makeBoard(medium1)) == makeBoard(medium1))
    }


    test("Retrieving the first diagonal (2p)"){
      assert(Board(medium1).getFstDiag == List(Two,Two,Two,Two,Two))
    }

    test("Retrieving the second diagonal (3p)"){
      assert(Board(medium1).getSndDiag == List(Two,Two,Two,Two,Two))
    }



    test("(A)Elements above fst diagonal 1 (2p)"){
      assert(Board(medium1).getAboveFstDiag == Board(aboveFstDiag1).board)
    }

    test("(A)Elements above fst diagonal 2 (2p)"){
      assert(Board(medium2).getAboveFstDiag == Board(aboveFstDiag2).board)
    }

  test("(B)Elements below fst diagonal 1 (2p)"){
    assert(Board(medium1).getBelowFstDiag == Board(aboveFstDiag1).board)
  }

  test("(B)Elements below fst diagonal 2 (2p)"){
    assert(Board(medium2).getBelowFstDiag == Board(belowFstDiag2).board)
  }

  test("(C)Elements above snd diagonal 1 (1p)"){
    assert(Board(medium1).getAboveSndDiag == Board(aboveSndDiag1).board)
  }

  test("(C)Elements above snd diagonal 2 (2p)"){
    assert(Board(medium2).getAboveSndDiag == Board(aboveSndDiag2).board)
  }

  test("(D)Elements below snd diagonal 1 (2p)"){
    assert(Board(medium1).getBelowSndDiag == Board(belowSndDiag1).board)
  }

  test("(D)Elements below snd diagonal 2 (2p)"){
    assert(Board(medium2).getBelowSndDiag == Board(belowSndDiag2).board)
  }


  test("Winner 1 (0p)"){
    assert(Board(medium1,Two).winner )
    assert(!(Board(medium1, One).winner))
  }

  test("Winner 2 (5p)"){
    assert(Board(medium2, Two).winner)
    assert(!(Board(medium2, One).winner))

  }

  test("Winner 3 (10p)"){
    val t2 =
      """X0X0X0
        |0X0X0X
        |X0X0X0
        |.XX0..
        |X00...
        |X0X0X0""".stripMargin
        assert(Board(t2,One).winner)
  }

  val smallUpd1 =
    """0XX
      |0X.
      |X..""".stripMargin.replace("\r\n","\n")

  test("Update 1 (5p)"){
    assert(Board(small,One).update(0,1).board == Board(smallUpd1).board)
    //assert(show(update(One)(0,1,makeBoard(small))) == smallUpd1)
  }

  val smallUpd2 =
    """0.X
      |0X.
      |X.0""".stripMargin.replace("\r\n","\n")

  test("Update 2 (5p)"){
    assert(Board(small,Two).update(2,2).board == Board(smallUpd2).board)
    //assert(show(update(Two)(2,2,makeBoard(small))) == smallUpd2)
  }



  val full =
    """0XX
      |0XX
      |XX0""".stripMargin

  test("Next 1 (0p)"){
    assert(Board(full,Two).next == Nil)
    assert(Board(full,One).next == Nil)

    //assert(next(Two)(makeBoard(full)) == Nil)
    //assert(next(One)(makeBoard(full)) == Nil)
  }

  val nextTest =
    """0..
      |0.X
      |.X.""".stripMargin

  val nextTestR1 = Set("00.\n0.X\n.X.","0.0\n0.X\n.X.", "0..\n00X\n.X.", "0..\n0.X\n0X.", "0..\n0.X\n.X0")
  val nextTestR2 = Set("0X.\n0.X\n.X.","0.X\n0.X\n.X.", "0..\n0XX\n.X.", "0..\n0.X\nXX.", "0..\n0.X\n.XX")


  test("Next 2 (10p)"){

    assert(Board(nextTest,Two).next.map(_.toString).toSet == nextTestR1)
    assert(Board(nextTest,One).next.map(_.toString).toSet == nextTestR2)
  }

  val t1 =
    """......
      |......
      |......
      |..X...
      |......
      |......""".stripMargin
  val t2 =
    """......
      |......
      |......
      |.XXX..
      |......
      |......""".stripMargin
  val t3 =
    """......
      |......
      |......
      |0XXX..
      |......
      |......""".stripMargin

  val t4 =
    """......
      |......
      |.000..
      |.XXX..
      |......
      |......""".stripMargin

  val t5 =
    """......
      |......
      |.000..
      |.XXXX.
      |......
      |......""".stripMargin

  test("Sequences (30p)"){
    assert(Board(t1, One).sequences == Map(2 -> 0, 3 -> 0, 4 -> 0, 5 -> 0))
    assert(Board(t2, One).sequences(3) == 2)
    assert(Board(t3, One).sequences(3) == 1)

  }
}