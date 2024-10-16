file://<WORKSPACE>/src/main/scala/ExamFP.scala
### java.lang.IndexOutOfBoundsException: -1 is out of bounds (min 0, max 2)

occurred in the presentation compiler.

presentation compiler configuration:
Scala version: 2.13.14
Classpath:
<WORKSPACE>/.bloop/root/bloop-bsp-clients-classes/classes-Metals-s9-m8AokR0-KNsUjw9FQFg== [exists ], <HOME>/.cache/bloop/semanticdb/com.sourcegraph.semanticdb-javac.0.9.10/semanticdb-javac-0.9.10.jar [exists ], <HOME>/.cache/coursier/v1/https/repo1.maven.org/maven2/org/scala-lang/scala-library/2.13.14/scala-library-2.13.14.jar [exists ]
Options:
-Yrangepos -Xplugin-require:semanticdb


action parameters:
uri: file://<WORKSPACE>/src/main/scala/ExamFP.scala
text:
```scala
object ExamFP {

  def profileID = 294083

  /*
    1. Write a function which takes a list of int values "boxed" as options: a "box" is
    either empty of contains an integer.
    The function should return a "boxed" list of integers, if _all_ non-empty "boxes" are strictly
    positive, and None, otherwise.
   */
  def positiveValues(l: List[Option[Int]]): Option[List[Int]] = ???

  /*
    2. Write a function that takes a list of pairs (xi,yj) from i = 0,n-1 and
    computes x0 + x1 + ... xn-1 + y0 + y1 + ... + yn-1.
   */

  def sumpairs(l: List[(Int,Int)]): Int = ???

  trait Container
  case class Empty(id: String) extends Container
  case class Single(id: String, e: Container) extends Container
  case class Double(id: String, e1: Container, e2: Container) extends Container

/*
    3. Write a function which takes an arbitrary container c, and counts
       the number of possibly nested "double" containers it contains.
   */

  def howMany(c: Container): Int = ???

  /*
     4. Write a function that takes a container and returns the ids of all possible
     nested containers it contains, including itself.
   */
  def ids(c: Container): List[String] = ???

  /* 5. Write a function which checks if there is at least one "Double" container
        containing two Single containers, in a container c.
   */
  def twoSinOneD(c: Container): Boolean = ???

  case class Set[A](f: A => Boolean)
  /*  
    6. Given a list of sets represented using characteristic functions and
         a value x, check if x belongs in all sets.
  */

  def inall[A](x:A, l: List[Set[A]]): Boolean = ???
  /*
      7. Convert a list of values of type A to a Set of type A.
   */
  def convert[A](l: List[A]): Set[A] = {
    for(member : A)
  }

  /*
      8. Count the number of strings of length larger than 3, whose fourth character
         is a digit.
   */
  def count(l: List[String]): Int = ???
  /*  {
   def aux(index: Int, acc: Int){
      if(){
        else if
      }
      else aux(index + 1, acc)
    }
  
    aux(0, 0) 
    }
  */
  /*
      9. Build the cartesian product of two lists.
   */
  def cart[A,B](l: List[A], lp: List[B]): List[(A,B)] = ???

  /*
    10. From a list of x1, x2, ... xn, build a list of pairs
    (x1,x2), (x3,x4), ... (xn-1, xn) if n is even and
    (x1,x2), (x3,x4), .... (xn, -1) otherwise
   */
  def pair(l: List[Int]): List[(Int,Int)] = ???
}

```



#### Error stacktrace:

```
scala.collection.mutable.ArrayBuffer.apply(ArrayBuffer.scala:102)
	scala.reflect.internal.Types$Type.findMemberInternal$1(Types.scala:1030)
	scala.reflect.internal.Types$Type.findMember(Types.scala:1035)
	scala.reflect.internal.Types$Type.memberBasedOnName(Types.scala:661)
	scala.reflect.internal.Types$Type.member(Types.scala:625)
	scala.reflect.internal.Types$Type.packageObject(Types.scala:637)
	scala.reflect.internal.Symbols$Symbol.packageObject(Symbols.scala:860)
	scala.tools.nsc.typechecker.Contexts$Context.implicits(Contexts.scala:1188)
	scala.tools.nsc.typechecker.Contexts$Context.implicitssImpl(Contexts.scala:1153)
	scala.tools.nsc.typechecker.Contexts$Context.withOuter$1(Contexts.scala:1142)
	scala.tools.nsc.typechecker.Contexts$Context.implicitssImpl(Contexts.scala:1160)
	scala.tools.nsc.typechecker.Contexts$Context.withOuter$1(Contexts.scala:1142)
	scala.tools.nsc.typechecker.Contexts$Context.implicitssImpl(Contexts.scala:1160)
	scala.tools.nsc.typechecker.Contexts$Context.withOuter$1(Contexts.scala:1142)
	scala.tools.nsc.typechecker.Contexts$Context.implicitssImpl(Contexts.scala:1160)
	scala.tools.nsc.typechecker.Contexts$Context.withOuter$1(Contexts.scala:1142)
	scala.tools.nsc.typechecker.Contexts$Context.implicitssImpl(Contexts.scala:1160)
	scala.tools.nsc.typechecker.Contexts$Context.withOuter$1(Contexts.scala:1142)
	scala.tools.nsc.typechecker.Contexts$Context.implicitssImpl(Contexts.scala:1160)
	scala.tools.nsc.typechecker.Contexts$Context.withOuter$1(Contexts.scala:1142)
	scala.tools.nsc.typechecker.Contexts$Context.implicitssImpl(Contexts.scala:1160)
	scala.tools.nsc.typechecker.Contexts$Context.withOuter$1(Contexts.scala:1142)
	scala.tools.nsc.typechecker.Contexts$Context.implicitssImpl(Contexts.scala:1160)
	scala.tools.nsc.typechecker.Contexts$Context.implicitss(Contexts.scala:1131)
	scala.tools.nsc.typechecker.Implicits$ImplicitSearch.bestImplicit(Implicits.scala:1716)
	scala.tools.nsc.typechecker.Implicits.inferImplicit1(Implicits.scala:112)
	scala.tools.nsc.typechecker.Implicits.inferImplicit(Implicits.scala:91)
	scala.tools.nsc.typechecker.Implicits.inferImplicit$(Implicits.scala:88)
	scala.meta.internal.pc.MetalsGlobal$MetalsInteractiveAnalyzer.inferImplicit(MetalsGlobal.scala:68)
	scala.tools.nsc.typechecker.Implicits.inferImplicitByType(Implicits.scala:54)
	scala.tools.nsc.typechecker.Implicits.inferImplicitByType$(Implicits.scala:53)
	scala.meta.internal.pc.MetalsGlobal$MetalsInteractiveAnalyzer.inferImplicitByType(MetalsGlobal.scala:68)
	scala.tools.nsc.typechecker.Tags$Tag.$anonfun$resolveTag$2(Tags.scala:26)
	scala.tools.nsc.typechecker.Tags$Tag.$anonfun$resolveTag$1(Tags.scala:26)
	scala.tools.nsc.typechecker.Tags$Tag.resolveTag(Tags.scala:26)
	scala.tools.nsc.typechecker.Tags$Tag.resolveClassTag(Tags.scala:46)
	scala.tools.nsc.typechecker.Tags$Tag.resolveClassTag$(Tags.scala:44)
	scala.tools.nsc.typechecker.Typers$Typer.resolveClassTag(Typers.scala:203)
	scala.tools.nsc.typechecker.PatternTypers$PatternTyper.extractorForUncheckedType(PatternTypers.scala:402)
	scala.tools.nsc.typechecker.PatternTypers$PatternTyper.extractorForUncheckedType$(PatternTypers.scala:392)
	scala.tools.nsc.typechecker.Typers$Typer.extractorForUncheckedType(Typers.scala:203)
	scala.tools.nsc.typechecker.PatternTypers$PatternTyper.typedInPattern(PatternTypers.scala:186)
	scala.tools.nsc.typechecker.PatternTypers$PatternTyper.typedInPattern$(PatternTypers.scala:181)
	scala.tools.nsc.typechecker.Typers$Typer.typedInPattern(Typers.scala:203)
	scala.tools.nsc.typechecker.Typers$Typer.typedTyped$1(Typers.scala:5937)
	scala.tools.nsc.typechecker.Typers$Typer.typed1(Typers.scala:6208)
	scala.tools.nsc.typechecker.Typers$Typer.typed(Typers.scala:6261)
	scala.tools.nsc.typechecker.Typers$Typer.typedBind$1(Typers.scala:4785)
	scala.tools.nsc.typechecker.Typers$Typer.typed1(Typers.scala:6204)
	scala.tools.nsc.typechecker.Typers$Typer.typed(Typers.scala:6261)
	scala.tools.nsc.typechecker.Typers$Typer.$anonfun$typedPattern$2(Typers.scala:6440)
	scala.tools.nsc.typechecker.Typers$Typer.$anonfun$typedPattern$1(Typers.scala:6440)
	scala.tools.nsc.typechecker.TypeDiagnostics.typingInPattern(TypeDiagnostics.scala:71)
	scala.tools.nsc.typechecker.TypeDiagnostics.typingInPattern$(TypeDiagnostics.scala:68)
	scala.meta.internal.pc.MetalsGlobal$MetalsInteractiveAnalyzer.typingInPattern(MetalsGlobal.scala:68)
	scala.tools.nsc.typechecker.Typers$Typer.typedPattern(Typers.scala:6440)
	scala.tools.nsc.typechecker.Typers$Typer.typedCase(Typers.scala:2682)
	scala.tools.nsc.typechecker.Typers$Typer.$anonfun$typedCases$1(Typers.scala:2716)
	scala.tools.nsc.typechecker.Typers$Typer.typedCases(Typers.scala:2715)
	scala.tools.nsc.typechecker.Typers$Typer.typedMatch(Typers.scala:2727)
	scala.tools.nsc.typechecker.Typers$Typer.typedVirtualizedMatch$1(Typers.scala:4924)
	scala.tools.nsc.typechecker.Typers$Typer.typedOutsidePatternMode$1(Typers.scala:6184)
	scala.tools.nsc.typechecker.Typers$Typer.typed1(Typers.scala:6215)
	scala.tools.nsc.typechecker.Typers$Typer.typed(Typers.scala:6261)
	scala.tools.nsc.typechecker.Typers$Typer.doTypedFunction(Typers.scala:6350)
	scala.tools.nsc.typechecker.Typers$Typer.typedFunction(Typers.scala:3205)
	scala.tools.nsc.typechecker.Typers$Typer.$anonfun$typed1$110(Typers.scala:6143)
	scala.tools.nsc.typechecker.Typers$Typer.typedFunction$1(Typers.scala:512)
	scala.tools.nsc.typechecker.Typers$Typer.typedOutsidePatternMode$1(Typers.scala:6183)
	scala.tools.nsc.typechecker.Typers$Typer.typed1(Typers.scala:6215)
	scala.tools.nsc.typechecker.Typers$Typer.typed(Typers.scala:6261)
	scala.tools.nsc.typechecker.Typers$Typer.$anonfun$typed1$32(Typers.scala:5185)
	scala.tools.nsc.typechecker.Typers$Typer.reportError$1(Typers.scala:5185)
	scala.tools.nsc.typechecker.Typers$Typer.onError$3(Typers.scala:5230)
	scala.tools.nsc.typechecker.Typers$Typer.normalTypedApply$1(Typers.scala:5257)
	scala.tools.nsc.typechecker.Typers$Typer.typedApply$1(Typers.scala:5267)
	scala.tools.nsc.typechecker.Typers$Typer.typed1(Typers.scala:6205)
	scala.tools.nsc.typechecker.Typers$Typer.typed(Typers.scala:6261)
	scala.tools.nsc.typechecker.Typers$Typer.typedSelectOrSuperCall$1(Typers.scala:6359)
	scala.tools.nsc.typechecker.Typers$Typer.typed1(Typers.scala:6206)
	scala.tools.nsc.typechecker.Typers$Typer.typed(Typers.scala:6261)
	scala.tools.nsc.typechecker.Typers$Typer.$anonfun$typed1$41(Typers.scala:5233)
	scala.tools.nsc.typechecker.Typers$Typer.silent(Typers.scala:713)
	scala.tools.nsc.typechecker.Typers$Typer.normalTypedApply$1(Typers.scala:5235)
	scala.tools.nsc.typechecker.Typers$Typer.typedApply$1(Typers.scala:5267)
	scala.tools.nsc.typechecker.Typers$Typer.typed1(Typers.scala:6205)
	scala.tools.nsc.typechecker.Typers$Typer.typed(Typers.scala:6261)
	scala.tools.nsc.typechecker.Typers$Typer.typedDefDef(Typers.scala:6525)
	scala.tools.nsc.typechecker.Typers$Typer.typed1(Typers.scala:6167)
	scala.tools.nsc.typechecker.Typers$Typer.typed(Typers.scala:6261)
	scala.tools.nsc.typechecker.Typers$Typer.typedStat$1(Typers.scala:6339)
	scala.tools.nsc.typechecker.Typers$Typer.$anonfun$typedStats$9(Typers.scala:3539)
	scala.tools.nsc.typechecker.Typers$Typer.typedStats(Typers.scala:3539)
	scala.tools.nsc.typechecker.Typers$Typer.typedTemplate(Typers.scala:2144)
	scala.tools.nsc.typechecker.Typers$Typer.typedModuleDef(Typers.scala:2020)
	scala.tools.nsc.typechecker.Typers$Typer.typed1(Typers.scala:6169)
	scala.tools.nsc.typechecker.Typers$Typer.typed(Typers.scala:6261)
	scala.tools.nsc.typechecker.Typers$Typer.typedStat$1(Typers.scala:6339)
	scala.tools.nsc.typechecker.Typers$Typer.$anonfun$typedStats$9(Typers.scala:3539)
	scala.tools.nsc.typechecker.Typers$Typer.typedStats(Typers.scala:3539)
	scala.tools.nsc.typechecker.Typers$Typer.typedPackageDef$1(Typers.scala:5844)
	scala.tools.nsc.typechecker.Typers$Typer.typed1(Typers.scala:6171)
	scala.tools.nsc.typechecker.Typers$Typer.typed(Typers.scala:6261)
	scala.tools.nsc.typechecker.Analyzer$typerFactory$TyperPhase.apply(Analyzer.scala:125)
	scala.tools.nsc.Global$GlobalPhase.applyPhase(Global.scala:481)
	scala.tools.nsc.interactive.Global$TyperRun.applyPhase(Global.scala:1369)
	scala.tools.nsc.interactive.Global$TyperRun.typeCheck(Global.scala:1362)
	scala.tools.nsc.interactive.Global.typeCheck(Global.scala:680)
	scala.meta.internal.pc.PcCollector.<init>(PcCollector.scala:29)
	scala.meta.internal.pc.PcSemanticTokensProvider$Collector$.<init>(PcSemanticTokensProvider.scala:19)
	scala.meta.internal.pc.PcSemanticTokensProvider.Collector$lzycompute$1(PcSemanticTokensProvider.scala:19)
	scala.meta.internal.pc.PcSemanticTokensProvider.Collector(PcSemanticTokensProvider.scala:19)
	scala.meta.internal.pc.PcSemanticTokensProvider.provide(PcSemanticTokensProvider.scala:73)
	scala.meta.internal.pc.ScalaPresentationCompiler.$anonfun$semanticTokens$1(ScalaPresentationCompiler.scala:170)
```
#### Short summary: 

java.lang.IndexOutOfBoundsException: -1 is out of bounds (min 0, max 2)