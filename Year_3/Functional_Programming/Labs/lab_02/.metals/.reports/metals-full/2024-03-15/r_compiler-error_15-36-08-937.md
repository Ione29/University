file://<WORKSPACE>/src/lab_02.worksheet.sc
### java.lang.AssertionError: NoDenotation.owner

occurred in the presentation compiler.

presentation compiler configuration:
Scala version: 3.3.1
Classpath:
<HOME>/.cache/coursier/v1/https/repo1.maven.org/maven2/org/scala-lang/scala3-library_3/3.3.1/scala3-library_3-3.3.1.jar [exists ], <HOME>/.cache/coursier/v1/https/repo1.maven.org/maven2/org/scala-lang/scala-library/2.13.10/scala-library-2.13.10.jar [exists ], <HOME>/.cache/coursier/v1/https/repo1.maven.org/maven2/org/scalameta/mdoc-runtime_3/2.5.2/mdoc-runtime_3-2.5.2.jar [exists ], <HOME>/.cache/coursier/v1/https/repo1.maven.org/maven2/org/scala-lang/scala3-library_3/3.3.1/scala3-library_3-3.3.1.jar [exists ], <HOME>/.cache/coursier/v1/https/repo1.maven.org/maven2/com/lihaoyi/fansi_3/0.4.0/fansi_3-0.4.0.jar [exists ], <HOME>/.cache/coursier/v1/https/repo1.maven.org/maven2/com/lihaoyi/pprint_3/0.8.1/pprint_3-0.8.1.jar [exists ], <HOME>/.cache/coursier/v1/https/repo1.maven.org/maven2/org/scalameta/mdoc-interfaces/2.5.2/mdoc-interfaces-2.5.2.jar [exists ], <HOME>/.cache/coursier/v1/https/repo1.maven.org/maven2/org/scala-lang/scala-library/2.13.12/scala-library-2.13.12.jar [exists ], <HOME>/.cache/coursier/v1/https/repo1.maven.org/maven2/com/geirsson/metaconfig-pprint_3/0.12.0/metaconfig-pprint_3-0.12.0.jar [exists ], <HOME>/.cache/coursier/v1/https/repo1.maven.org/maven2/org/scala-lang/scala-reflect/2.13.12/scala-reflect-2.13.12.jar [exists ], <HOME>/.cache/coursier/v1/https/repo1.maven.org/maven2/org/scala-lang/scala3-library_3/3.3.1/scala3-library_3-3.3.1.jar [exists ], <HOME>/.cache/coursier/v1/https/repo1.maven.org/maven2/org/scala-lang/scala-library/2.13.10/scala-library-2.13.10.jar [exists ]
Options:



action parameters:
offset: 1979
uri: file://<WORKSPACE>/src/lab_02.worksheet.sc
text:
```scala
object worksheet{
  // ex 1: Write a tail-recursive function that computes the factorial of a natural number.
  def fact (n : Int) : Int = {
      def aux_fact(i: Int, acc : Int): Int =
          if(i == 1) acc
          else aux_fact(i - 1, acc * i)
      aux_fact(n, 1) 
  }
  
  fact(11)
  
  // ex 2: Implement a tail-recursive function that computes the greatest common divisor of a natural number: 
  /* 
  def gcd(a: Int, b: Int): Int = {
      if(a < b) gcd(b % a, a)
      else if(a > b) gcd(a % b, a)
      else a
  }
  
  gcd(6, 4) */
  
  // ex 3: Write a tail-recursive function takes an integer n and computes the value 1+2^2+3^2+…+(n−1)^2+n^2 . (Hint: use inner functions).
  def sumSquares(n : Int): Int = {
      def aux_sum(i: Int, acc: Int): Int =
          if(i == 0) acc
          else aux_sum(i - 1, acc + math.pow(i, 2).asInstanceOf[Int])
      aux_sum(n, 0)
  }
  
  sumSquares(5)
  
  // ex 4: Write a function which computes the sum of all natural numbers within a range. Use two styles to write this function: direct recursion, and tail recursion.
  
  def sumNats(start: Int, stop : Int): Int = {
      def aux_sum(start: Int, stop: Int): Int = {
          if(start > stop) 0
          else start + aux_sum(start + 1, stop)
      }
  
      aux_sum(start, stop)
  }
  
  sumNats(1, 3)
  
  def tailSumNats(start: Int, stop: Int): Int ={
      def aux_sum(start: Int, stop: Int, acc: Int): Int = {
          if(start > stop) acc
          else aux_sum(start + 1, stop, acc + start)
      }
  
      aux_sum(start, stop, 0)
  }
  
  tailSumNats(1, 3)
  
  // ex 5: Write a function which takes an initial value x and a range of values x0,x1,…,xn and computes ((x−x0)−x1)−…xn . Use the most appropriate type of recursion for this task. 
  // the most appropiate is tail recusrion
  
  def subtractRange(x: Int, start: Int, stop: Int): Int = {
      def aux_sub(x: Int, start: Int, stop: Int, acc: Int): Int = {
  
      }
  
      aux_sub(x, start, stpp[@@])
  }
  
}
```



#### Error stacktrace:

```
dotty.tools.dotc.core.SymDenotations$NoDenotation$.owner(SymDenotations.scala:2582)
	scala.meta.internal.pc.SignatureHelpProvider$.isValid(SignatureHelpProvider.scala:83)
	scala.meta.internal.pc.SignatureHelpProvider$.notCurrentApply(SignatureHelpProvider.scala:96)
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