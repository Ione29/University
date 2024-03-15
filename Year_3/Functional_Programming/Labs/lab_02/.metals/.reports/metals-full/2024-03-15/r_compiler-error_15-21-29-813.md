file://<WORKSPACE>/src/lab_02.worksheet.sc
### java.lang.IllegalArgumentException: Comparison method violates its general contract!

occurred in the presentation compiler.

presentation compiler configuration:
Scala version: 3.3.1
Classpath:
<HOME>/.cache/coursier/v1/https/repo1.maven.org/maven2/org/scala-lang/scala3-library_3/3.3.1/scala3-library_3-3.3.1.jar [exists ], <HOME>/.cache/coursier/v1/https/repo1.maven.org/maven2/org/scala-lang/scala-library/2.13.10/scala-library-2.13.10.jar [exists ], <HOME>/.cache/coursier/v1/https/repo1.maven.org/maven2/org/scalameta/mdoc-runtime_3/2.5.2/mdoc-runtime_3-2.5.2.jar [exists ], <HOME>/.cache/coursier/v1/https/repo1.maven.org/maven2/org/scala-lang/scala3-library_3/3.3.1/scala3-library_3-3.3.1.jar [exists ], <HOME>/.cache/coursier/v1/https/repo1.maven.org/maven2/com/lihaoyi/fansi_3/0.4.0/fansi_3-0.4.0.jar [exists ], <HOME>/.cache/coursier/v1/https/repo1.maven.org/maven2/com/lihaoyi/pprint_3/0.8.1/pprint_3-0.8.1.jar [exists ], <HOME>/.cache/coursier/v1/https/repo1.maven.org/maven2/org/scalameta/mdoc-interfaces/2.5.2/mdoc-interfaces-2.5.2.jar [exists ], <HOME>/.cache/coursier/v1/https/repo1.maven.org/maven2/org/scala-lang/scala-library/2.13.12/scala-library-2.13.12.jar [exists ], <HOME>/.cache/coursier/v1/https/repo1.maven.org/maven2/com/geirsson/metaconfig-pprint_3/0.12.0/metaconfig-pprint_3-0.12.0.jar [exists ], <HOME>/.cache/coursier/v1/https/repo1.maven.org/maven2/org/scala-lang/scala-reflect/2.13.12/scala-reflect-2.13.12.jar [exists ], <HOME>/.cache/coursier/v1/https/repo1.maven.org/maven2/org/scala-lang/scala3-library_3/3.3.1/scala3-library_3-3.3.1.jar [exists ], <HOME>/.cache/coursier/v1/https/repo1.maven.org/maven2/org/scala-lang/scala-library/2.13.10/scala-library-2.13.10.jar [exists ]
Options:



action parameters:
offset: 1494
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
      def aux_sum(start: Int, stop: Int, acc): Int = {
          if(start > stop) acc
          else aux_sum(start + 1, stop, acc@@)
      }
  
      aux_sum(start, stop, 0)
  }
}
```



#### Error stacktrace:

```
java.base/java.util.TimSort.mergeLo(TimSort.java:781)
	java.base/java.util.TimSort.mergeAt(TimSort.java:518)
	java.base/java.util.TimSort.mergeCollapse(TimSort.java:448)
	java.base/java.util.TimSort.sort(TimSort.java:245)
	java.base/java.util.Arrays.sort(Arrays.java:1234)
	scala.collection.SeqOps.sorted(Seq.scala:727)
	scala.collection.SeqOps.sorted$(Seq.scala:719)
	scala.collection.immutable.List.scala$collection$immutable$StrictOptimizedSeqOps$$super$sorted(List.scala:79)
	scala.collection.immutable.StrictOptimizedSeqOps.sorted(StrictOptimizedSeqOps.scala:78)
	scala.collection.immutable.StrictOptimizedSeqOps.sorted$(StrictOptimizedSeqOps.scala:78)
	scala.collection.immutable.List.sorted(List.scala:79)
	scala.meta.internal.pc.completions.Completions.completions(Completions.scala:210)
	scala.meta.internal.pc.completions.CompletionProvider.completions(CompletionProvider.scala:86)
	scala.meta.internal.pc.ScalaPresentationCompiler.complete$$anonfun$1(ScalaPresentationCompiler.scala:146)
```
#### Short summary: 

java.lang.IllegalArgumentException: Comparison method violates its general contract!