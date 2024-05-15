file://<WORKSPACE>/src/main/scala/lab_06.worksheet.sc
### java.lang.AssertionError: assertion failed: NoType

occurred in the presentation compiler.

presentation compiler configuration:
Scala version: 3.3.1
Classpath:
<HOME>/.cache/coursier/v1/https/repo1.maven.org/maven2/org/scala-lang/scala3-library_3/3.3.1/scala3-library_3-3.3.1.jar [exists ], <HOME>/.cache/coursier/v1/https/repo1.maven.org/maven2/org/scala-lang/scala-library/2.13.10/scala-library-2.13.10.jar [exists ], <HOME>/.cache/coursier/v1/https/repo1.maven.org/maven2/org/scalameta/mdoc-runtime_3/2.5.2/mdoc-runtime_3-2.5.2.jar [exists ], <HOME>/.cache/coursier/v1/https/repo1.maven.org/maven2/org/scala-lang/scala3-library_3/3.3.1/scala3-library_3-3.3.1.jar [exists ], <HOME>/.cache/coursier/v1/https/repo1.maven.org/maven2/com/lihaoyi/fansi_3/0.4.0/fansi_3-0.4.0.jar [exists ], <HOME>/.cache/coursier/v1/https/repo1.maven.org/maven2/com/lihaoyi/pprint_3/0.8.1/pprint_3-0.8.1.jar [exists ], <HOME>/.cache/coursier/v1/https/repo1.maven.org/maven2/org/scalameta/mdoc-interfaces/2.5.2/mdoc-interfaces-2.5.2.jar [exists ], <HOME>/.cache/coursier/v1/https/repo1.maven.org/maven2/org/scala-lang/scala-library/2.13.12/scala-library-2.13.12.jar [exists ], <HOME>/.cache/coursier/v1/https/repo1.maven.org/maven2/com/geirsson/metaconfig-pprint_3/0.12.0/metaconfig-pprint_3-0.12.0.jar [exists ], <HOME>/.cache/coursier/v1/https/repo1.maven.org/maven2/org/scala-lang/scala-reflect/2.13.12/scala-reflect-2.13.12.jar [exists ], <HOME>/.cache/coursier/v1/https/repo1.maven.org/maven2/org/scala-lang/scala3-library_3/3.3.1/scala3-library_3-3.3.1.jar [exists ], <HOME>/.cache/coursier/v1/https/repo1.maven.org/maven2/org/scala-lang/scala-library/2.13.10/scala-library-2.13.10.jar [exists ]
Options:



action parameters:
offset: 1293
uri: file://<WORKSPACE>/src/main/scala/lab_06.worksheet.sc
text:
```scala
object worksheet{
  type Gradebook = List[(String, Int)]
  val gradebook = List(("G", 3), ("F", 10), ("M", 6), ("P", 4))
  def increment(g: Gradebook): Gradebook =
      g.map{
          case (student, grade) if grade >= 5 => (student, grade + 1)
          case other => other
      }
  
  print(increment(gradebook))
  
  def average(g : Gradebook): Double = {
      val (sum, count) = g.foldRight((0, 0)) {
          case ((_, grade), (acc, count)) => (acc + grade, count + 1)
      }
  
      if(count == 0) 0
      else sum.toDouble / count
  }
  
  average(gradebook)
  
  def percentage(g: Gradebook): (Double, Double) = {
      
      //Method 1
      /* val (passed, failed) = g.foldRight((0, 0)) {
          case ((_, grade), (acc1, acc2)) => if(grade >= 5) (acc1 + 1, acc2) else s(acc1, acc2 + 1)
      } 
  
      if(passed + failed == 0) (0, 0)
      else (passed * 100 / g.size, failed * 100 / g.size)*/
      
      //Method 2
      val passedCount = g.filter((name, grade) => if(grade >= 5) true else false)
      val passedPerc = passedCount.size * 100 / g.size 
      val failedPerc = 100 - passedPerc
  
      (passedPerc, failedPerc)
  }
  
  print(percentage(gradebook))
  
  def pass(g: Gradebook): List[String] = {
      val passedNames = g.foldRight(names) {
          c@@
      }
  }
}
```



#### Error stacktrace:

```
scala.runtime.Scala3RunTime$.assertFailed(Scala3RunTime.scala:8)
	dotty.tools.dotc.core.Types$TypeBounds.<init>(Types.scala:5141)
	dotty.tools.dotc.core.Types$AliasingBounds.<init>(Types.scala:5220)
	dotty.tools.dotc.core.Types$TypeAlias.<init>(Types.scala:5242)
	dotty.tools.dotc.core.Types$TypeAlias$.apply(Types.scala:5279)
	dotty.tools.dotc.core.Types$Type.bounds(Types.scala:1732)
	scala.meta.internal.pc.completions.CaseKeywordCompletion$.contribute(MatchCaseCompletions.scala:156)
	scala.meta.internal.pc.completions.Completions.advancedCompletions(Completions.scala:443)
	scala.meta.internal.pc.completions.Completions.completions(Completions.scala:183)
	scala.meta.internal.pc.completions.CompletionProvider.completions(CompletionProvider.scala:86)
	scala.meta.internal.pc.ScalaPresentationCompiler.complete$$anonfun$1(ScalaPresentationCompiler.scala:146)
```
#### Short summary: 

java.lang.AssertionError: assertion failed: NoType