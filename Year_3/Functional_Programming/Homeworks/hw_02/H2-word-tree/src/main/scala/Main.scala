import scala.annotation.tailrec

abstract class WTree extends WTreeInterface {
  override def filter(pred: Token => Boolean): WTree = {
    filterAux(pred, Empty)
  }

  def filterAux(pred: Token => Boolean, acc: WTree): WTree
}

case object Empty extends WTree {
  override def balance: Int = 0
  override def height: Int = 0
  override def rotateLeft: WTree = this
  override def rotateRight: WTree = this
  override def rotateRightLeft: WTree = this
  override def rotateLeftRight: WTree = this
  override def rebalance: WTree = this
  override def isEmpty = true
  override def ins(w: Token): WTree = Node(w, Empty, Empty)
  override def filterAux(pred: Token => Boolean, acc: WTree): WTree = acc
  override def size: Int = 0
  override def contains(s: String): Boolean = false
}

case class Node(word: Token, left: WTree, right: WTree) extends WTree {
  override def balance: Int = right.height - left.height
  override def height: Int = 1 + (left.height max right.height)
  override def rotateLeft: WTree =
    right match {
      // the tree is unbalanced, hence the right sub-tree is nonempty
      case Node(w, l, r) => Node(w, Node(word, left, l), r)
    }
  override def rotateRight: WTree =
    left match {
      case Node(w, l, r) => Node(w, l, Node(word, r, right))
    }
  override def rotateRightLeft: WTree =
    Node(word, left, right.rotateRight).rotateLeft
  override def rotateLeftRight: WTree =
    Node(word, left.rotateLeft, right).rotateRight
  override def rebalance: WTree = {
    if (balance < -1 && left.balance == -1) this.rotateRight
    else if (balance > 1 && right.balance == 1) this.rotateLeft
    else if (balance < -1 && left.balance == 1) this.rotateLeftRight
    else if (balance > 1 && right.balance == -1) this.rotateRightLeft
    else this
  }

  override def isEmpty = false

  override def ins(w: Token): WTree =
    if (w.freq > word.freq) Node(word, left, right.ins(w))
    else Node(word, left.ins(w), right)

  override def contains(s: String): Boolean = {
    if (word.word == s) true
    else (left.contains(s) || right.contains(s))
  }

  override def size: Int = 1 + this.left.size + this.right.size

  //helper function added by me
  def merge(left: WTree, right: WTree): WTree = {
    left match {
      case Empty => right
      case Node(word, le, ri) => Node(word, merge(le, right), ri)
    }
  }

  def filterAux(pred: Token => Boolean, acc: WTree): WTree = {
    val leftFiltered = left.filterAux(pred, acc)
    val rightFiltered = right.filterAux(pred, acc)
    if(pred(word)) Node(word, leftFiltered, rightFiltered)
    else{
      leftFiltered match{
        case Empty => rightFiltered
        case Node(word, left, right) => Node(word, merge(left, rightFiltered), right)
      }
    }
  }
}

object Main {

  def profileID:Int = 294083

  val scalaDescription: String = "Scala is a strong statically typed general-purpose programming language which supports both object-oriented programming and functional programming designed to be concise many of Scala s design decisions are aimed to address criticisms of Java Scala source code can be compiled to Java bytecode and run on a Java virtual machine. Scala provides language interoperability with Java so that libraries written in either language may be referenced directly in Scala or Java code like Java, Scala is object-oriented, and uses a syntax termed curly-brace which is similar to the language C since Scala 3 there is also an option to use the off-side rule to structure blocks and its use is advised martin odersky has said that this turned out to be the most productive change introduced in Scala 3 unlike Java, Scala has many features of functional programming languages like Scheme, Standard ML, and Haskell, including currying, immutability, lazy evaluation, and pattern matching it also has an advanced type system supporting algebraic data types, covariance and contravariance, higher-order types (but not higher-rank types), and anonymous types other features of Scala not present in Java include operator overloading optional parameters named parameters and raw strings conversely a feature of Java not in Scala is checked exceptions which has proved controversial"

  /* Split the text into chunks */
  def split(text: List[Char]): List[List[Char]] = {
    def aux(index: Int, acc: List[Char]): List[List[Char]] = {
      if(index >= text.length) //if we get out of the text
        if(text(index - 1) == ' ')
          Nil
        else
          acc :: Nil
      else {  //if we are still in the text
        if(text(index) == ' '){
          val nextNonSpace = text.indexWhere(_ != ' ', index + 1) //search for the start of the next word

          if(nextNonSpace == -1)  //if we don't have any more words to check
            acc :: Nil  //we just end the search
          else
            acc :: aux(index + 1, Nil) //otherwise we continue the search
        }
        else aux(index + 1, acc.appended(text(index))) //recursively call the function until we index the full word
      }
    }

    // if we have only void chunks, we return the empty list
    val l = aux(0, Nil)
    if (l == List(Nil)) Nil
    else l
  }

  /* compute the frequency of each chunk */
  def computeTokens(words: List[String]): List[Token] = {
    /* insert a new string in a list of tokens */
    def insWord(s: String, acc: List[Token]): List[Token] = {
      val matchingText = acc.exists(_.word == s) //returns a boolean; check if the word has been indexed

      if (!matchingText) //if the word was not indexed
        acc.appended(Token(s, 1)) //we index it
      else //if the word has already been indexed
        acc.map {
          case Token(word, freq) => 
            if(word == s) //if the word we search for is found
              Token(word, freq + 1) //increment the frequency 
            else Token(word, freq) //otherwise we leave the frequency as is
        }
    }

    /* tail-recursive implementation of the list of tokens */
    @tailrec
    def aux(rest: List[String], acc: List[Token]): List[Token] = {
      rest match {
        case Nil => acc // we do not modify the acc
        case head :: next => aux(next, insWord(head, acc)) //we continue to check the words
      }
    }

    aux(words, Nil)
  }

  def tokensToTree(tokens: List[Token]): WTree = {
    tokens.foldLeft(Empty : WTree)((t, n) => t.ins(n))
  }

  /* Using the previous function, which builds a tree from a list of tokens,
  *  write a function which takes a string,
  *  splits it into chunks, computes frequencies and constructs a tree.
  *  Use the function _.toList to construct a list of characters from a String.
  *
  *  A much cleaner implementation can be achieved by "sequencing" functions using
  *  andThen.
  * */

  def makeTree(s:String): WTree = {
    val splitWords = split(s.toList)
    val computedTokens = splitWords.map((chars: List[Char]) => chars.mkString)
    val result = computeTokens(computedTokens)
    tokensToTree(result)
    
    /* Is this the solution for the andThen implementation ?
    * val splitWords = split(s.toList) andThen map((chars: List[Char]) => chars.mkString) andThen computeTokens()
    * tokensToTree(splitWords) 
    * */
  }

  /* build a tree with the words and frequencies from the text in the scalaDescription text */
  def wordSet: WTree = makeTree(scalaDescription) //we just call the function written previously, and giving as parameter the scalaDescription text

  /* find the number of occurrences of the keyword "Scala" in the scalaDescription text */
  def scalaFreq: Int = {
    val tree = makeTree(scalaDescription)
    val filteredNode = tree.filter((token) => token.word == "Scala") // we retrieve, form the BST, the node that contains the word Scala and it's appropiate information

    filteredNode match{
      case Node(token, left, right) => token.freq //if the node exists, it is of type Node and we retrieve the frequency
      case Empty => 0 //if the word is not indexed, we get a result of type Empty, which means the word is not indexed
    }
  }

  /* find how many programming languages are referenced in the text.
     A PL is a keyword which starts with an uppercase
     You can reference a character from a string using (0) and you can
     also use the function isUpper
  */
  def progLang: Int = {
    val tree = makeTree(scalaDescription)
    val filtered = tree.filter((token) => token.word.charAt(0).isUpper) //we create a tree that only contains nodes of words that begin with an upper case letter
    filtered.size
  }

  /* find how many words which are not prepositions or conjunctions appear in the text (any word whose size is larger than 3). */
  def wordCount : Int = {
    val splitWords = split(scalaDescription.toList)
    val filtered = splitWords.filter(_.length > 3) //we check how many words are larger than 3 characters
    filtered.size
  }
}

