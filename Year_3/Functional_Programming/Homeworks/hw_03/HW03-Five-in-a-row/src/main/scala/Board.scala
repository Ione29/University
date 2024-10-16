case class Board(val board: List[List[Player]], val player: Player) {
  
  type Line = List[Player]

  def isFree(x: Int, y: Int): Boolean = board(x)(y) == Empty

  def getColumns: Board = 
    this

  def getFstDiag: Line = {
    val firstDiag = for (x <- board.indices) yield board(x)(x)
    firstDiag.toList
  }

  def getSndDiag: Line = {
    val boardSize = board.size
    val secondDiag = for(x <- board.indices) yield board(boardSize - x - 1)(x)
    secondDiag.toList
  }

  def getAboveFstDiag: List[Line] = {
    val boardSize = board.size

    val aux = for {
      (row, rowIndex) <- board.zipWithIndex
    } yield {
      for {
        (col, colIndex) <- row.zipWithIndex
        if (colIndex > rowIndex)
      } yield board(rowIndex)(colIndex)
    }

    val max = aux.map(_.size).max

    val trans = (0 until max).map { i =>
      aux.flatMap(_.lift(i))
    }

    trans.toList
  }

  def getBelowFstDiag: List[Line] = {
    val aux = for {
      (row, rind) <- board.zipWithIndex
    } yield {
      for {
        (col, cind) <- row.zipWithIndex
        if (cind < rind)
      } yield col
    }

    val max = aux.map(_.size).max

    val trans = (0 until max).map { i =>
      aux.flatMap(_.lift(i))
    }

    trans.toList
  }

  def getAboveSndDiag: List[Line] = {
    val boardSize = board.size

    val aux = for {
      (row, rind) <- board.zipWithIndex
    } yield {
      for {
        (col, cind) <- row.zipWithIndex
        if (cind + rind) < boardSize - 1
      } yield col
    }
    val finalAux = aux.init
    
    def loop(acc: List[List[Player]], value: List[List[Player]]): List[Line] = {
      if (value == Nil) acc
      else {
        val toAdd = value.map(_.last)
        loop(acc ::: List(toAdd), value.map(_.init).filter(_.nonEmpty))

      }
    }

    loop(Nil, finalAux)
  }
  
  def getBelowSndDiag: List[Line] = {
    val boardSize = board.size

    val aux = for {
      (row, rind) <- board.zipWithIndex
    } yield {
      for {
        (col, cind) <- row.zipWithIndex
        if (cind + rind) > boardSize - 1
      } yield col
    }

    val finalAux = aux.tail

    def loop(acc: List[List[Player]], value: List[List[Player]]): List[Line] = {
      if (value == Nil) acc
      else {
        val toAdd = value.map(_.last)
        loop(acc ::: List(toAdd), value.map(_.init).filter(_.nonEmpty))

      }
    }
    loop(Nil, finalAux)
  }

  def winner: Boolean = {
    if (this.sequences(5) != 0) true 
    else false
  }

  def update(ln: Int, col: Int): Board = {
    val aux = for {
      (row, rind) <- board.zipWithIndex
    } yield {
      for {
        (col2, cind) <- row.zipWithIndex
      } yield if (rind == ln && cind == col) this.player else col2
    }
    new Board(aux, player)
  }

  def sequences: Map[Int, Int] = {
    def longSeq(list: List[Player]): Int = {
      list
        .foldLeft((0, 0)) { case ((currentCount, longestCount), content) =>
          if (content == this.player) {
            val newCount = currentCount + 1
            (newCount, Math.max(newCount, longestCount))
          } else {
            (0, longestCount)
          }
        }
        ._2
      }

    def longSeqNon(list: List[Player]): Int = {
      list
        .foldLeft((0, 0)) { case ((currentCount, longestCount), content) =>
          if (content == this.player || content == Empty) {
            val newCount = currentCount + 1
            (newCount, Math.max(newCount, longestCount))
          } else {
            (0, longestCount)
          }
        }
        ._2
    }

    def canBecomeWinner(list: List[Player]): (Boolean, Int, Int) = {
      val (allFilled, elseCount) = list.foldLeft((List.empty[Player], 0)) { case ((accList, count), player) =>
        if (player == Empty) {
          (accList :+ this.player, count + 1)
        } else {
          (accList :+ player, count)
        }
      }

      val size = list.size
      val longestEmptySpace = longSeqNon(list)
      val mapIndex = longSeq(list)
      println("Size = " + size + " Else = " + elseCount + " LongestEmpty = " + longestEmptySpace + " Returned = " + mapIndex)   

      if ((longSeq(allFilled) >= 5) && (size - elseCount > 1)) (true, mapIndex, longestEmptySpace - 4 ) else (false, 0, 0)
    }

    def concatMaps(first: Map[Int, Int], seccond: Map[Int, Int]): Map[Int, Int] = {
      first.foldLeft(seccond) { case (acc, (key, value)) =>
        acc + (key -> (acc.getOrElse(key, 0) + value))
      }
    }

    val defaultMap = Map(5 -> 0, 4 -> 0, 3 -> 0, 2 -> 0)

    val sequencesPerRow = for (row <- board) yield {
      canBecomeWinner(row)
    }

    val sumPerRow = sequencesPerRow.foldLeft(defaultMap) {
      case (acc, (true, num, value)) =>
        acc + (num -> (acc.getOrElse(num, 0) + value))
      case (acc, _) => acc
    }

    val sequencesPerCol = for (col <- board.transpose) yield {
      canBecomeWinner(col)
    }

    val sumCol = sequencesPerCol.foldLeft(sumPerRow) {
      case (acc, (true, num, value)) =>
        acc + (num -> (acc.getOrElse(num, 0) + value))
      case (acc, _) => acc
    }

    val seqPerDiagPrincBelow = for (below <- getBelowFstDiag) yield {
      canBecomeWinner(below)
    }

    val sumPerDiagPrincBelow = seqPerDiagPrincBelow.foldLeft(sumCol) {
      case (acc, (true, num, value)) =>
        acc + (num -> (acc.getOrElse(num, 0) + value))
      case (acc, _) => acc
    }

    val seqPerDiagPrincAbove = for (above <- getAboveFstDiag) yield {
      canBecomeWinner(above)
    }

    val sumPerDiagPrincAbove = seqPerDiagPrincAbove.foldLeft(sumPerDiagPrincBelow) {
      case (acc, (true, num, value)) =>
        acc + (num -> (acc.getOrElse(num, 0) + value))
      case (acc, _) => acc
    }
    
    val seqPerDiagSecBelow = for (below <- getBelowSndDiag) yield {
      canBecomeWinner(below)
    }

    val sumPerDiagSecBelow = seqPerDiagSecBelow.foldLeft(sumPerDiagPrincAbove) {
      case (acc, (true, num, value)) =>
        acc + (num -> (acc.getOrElse(num, 0) + value))
      case (acc, _) => acc
    }

    val seqPerDiagSecAbove = for (above <- getAboveSndDiag) yield {
      canBecomeWinner(above)
    }

    val sumPerDiagSecAbove = seqPerDiagSecAbove.foldLeft(sumPerDiagSecBelow) {
      case (acc, (true, num, value)) =>
        acc + (num -> (acc.getOrElse(num, 0) + value))
      case (acc, _) => acc
    }

    val seqDiagPrinc = canBecomeWinner(getFstDiag)
    val sumPerDiagPrinc = {
      val acc = sumPerDiagSecAbove

      seqDiagPrinc match {
        case (true, num, value) =>
          acc + (num -> (acc.getOrElse(num, 0) + value))
        case _ => acc
      }
    }

    val seqDiagSec = canBecomeWinner(getSndDiag)

    val sumPerDiagSec = {
      val acc = sumPerDiagPrinc

      seqDiagSec match {
        case (true, num, value) =>
          acc + (num -> (acc.getOrElse(num, 0) + value))
        case _ => acc
      }
    }
    sumPerDiagSec.view.filterKeys((elem) => elem > 1 && elem < 6).toMap
  }
  
  override def toString: String = {
    def fromPos(c: Player): Char =
      c match {
        case One   => 'X'
        case Two   => '0'
        case Empty => '.'
      }
    board
      .foldRight("")((sublist, acc) =>
        sublist.foldRight("")((elem: Player, acc: String) => fromPos(elem).toString() + acc) + "\n" + acc
      )
      .init
  }
}

object Board {

  def profileID : Int = 294083

  def apply(s: String, p: Player): Board = new Board(apply(s).board, p)

  def apply(s: String): Board = {
    def toPos(c: Char): Player =
      c match {
        case 'X' => One
        case '0' => Two
        case  _  => Empty
      }

    val splited = s.split('\n');
    new Board(splited.map(subsr => subsr.map(char => toPos(char)).toList).toList, Empty)
  }
}
