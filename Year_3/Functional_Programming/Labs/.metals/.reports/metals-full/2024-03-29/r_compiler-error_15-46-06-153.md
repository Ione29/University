file://<WORKSPACE>/lab_04/lab_04.worksheet.sc
### java.lang.AssertionError: NoDenotation.owner

occurred in the presentation compiler.

presentation compiler configuration:
Scala version: 3.3.1
Classpath:
<HOME>/.cache/coursier/v1/https/repo1.maven.org/maven2/org/scala-lang/scala3-library_3/3.3.1/scala3-library_3-3.3.1.jar [exists ], <HOME>/.cache/coursier/v1/https/repo1.maven.org/maven2/org/scala-lang/scala-library/2.13.10/scala-library-2.13.10.jar [exists ], <HOME>/.cache/coursier/v1/https/repo1.maven.org/maven2/org/scalameta/mdoc-runtime_3/2.5.2/mdoc-runtime_3-2.5.2.jar [exists ], <HOME>/.cache/coursier/v1/https/repo1.maven.org/maven2/org/scala-lang/scala3-library_3/3.3.1/scala3-library_3-3.3.1.jar [exists ], <HOME>/.cache/coursier/v1/https/repo1.maven.org/maven2/com/lihaoyi/fansi_3/0.4.0/fansi_3-0.4.0.jar [exists ], <HOME>/.cache/coursier/v1/https/repo1.maven.org/maven2/com/lihaoyi/pprint_3/0.8.1/pprint_3-0.8.1.jar [exists ], <HOME>/.cache/coursier/v1/https/repo1.maven.org/maven2/org/scalameta/mdoc-interfaces/2.5.2/mdoc-interfaces-2.5.2.jar [exists ], <HOME>/.cache/coursier/v1/https/repo1.maven.org/maven2/org/scala-lang/scala-library/2.13.12/scala-library-2.13.12.jar [exists ], <HOME>/.cache/coursier/v1/https/repo1.maven.org/maven2/com/geirsson/metaconfig-pprint_3/0.12.0/metaconfig-pprint_3-0.12.0.jar [exists ], <HOME>/.cache/coursier/v1/https/repo1.maven.org/maven2/org/scala-lang/scala-reflect/2.13.12/scala-reflect-2.13.12.jar [exists ], <HOME>/.cache/coursier/v1/https/repo1.maven.org/maven2/org/scala-lang/scala3-library_3/3.3.1/scala3-library_3-3.3.1.jar [exists ], <HOME>/.cache/coursier/v1/https/repo1.maven.org/maven2/org/scala-lang/scala-library/2.13.10/scala-library-2.13.10.jar [exists ]
Options:



action parameters:
offset: 3158
uri: file://<WORKSPACE>/lab_04/lab_04.worksheet.sc
text:
```scala
object worksheet{
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
  
  /* def last(list: IList): Int = {
      def findLast(element: IList): Int = {   
          element match{
              case Cons(x, tail) if tail == Void => x
              case Cons(x, tail) if tail != Void => findLast(tail)
          }
      }
      
      list match{
          case Cons(x, tail) => findLast(list)
          case Void => throw new IllegalArgumentException("The given list is empty.")
      }
  }
  */
  
  def last(list: IList): Int ={
      list match{
          case Void(@@)
      }
  }
  
}
```



#### Error stacktrace:

```
dotty.tools.dotc.core.SymDenotations$NoDenotation$.owner(SymDenotations.scala:2582)
	scala.meta.internal.pc.SignatureHelpProvider$.isValid(SignatureHelpProvider.scala:83)
	scala.meta.internal.pc.SignatureHelpProvider$.notCurrentApply(SignatureHelpProvider.scala:92)
	scala.meta.internal.pc.SignatureHelpProvider$.$anonfun$1(SignatureHelpProvider.scala:48)
	scala.collection.StrictOptimizedLinearSeqOps.loop$3(LinearSeq.scala:280)
	scala.collection.StrictOptimizedLinearSeqOps.dropWhile(LinearSeq.scala:282)
	scala.collection.StrictOptimizedLinearSeqOps.dropWhile$(LinearSeq.scala:278)
	scala.collection.immutable.List.dropWhile(List.scala:79)
	scala.meta.internal.pc.SignatureHelpProvider$.signatureHelp(SignatureHelpProvider.scala:48)
	scala.meta.internal.pc.ScalaPresentationCompiler.signatureHelp$$anonfun$1(ScalaPresentationCompiler.scala:398)
```
#### Short summary: 

java.lang.AssertionError: NoDenotation.owner