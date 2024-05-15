file://<WORKSPACE>/src/main/scala/lab_06.worksheet.sc
### java.lang.AssertionError: assertion failed

occurred in the presentation compiler.

presentation compiler configuration:
Scala version: 3.3.1
Classpath:
<HOME>/.cache/coursier/v1/https/repo1.maven.org/maven2/org/scala-lang/scala3-library_3/3.3.1/scala3-library_3-3.3.1.jar [exists ], <HOME>/.cache/coursier/v1/https/repo1.maven.org/maven2/org/scala-lang/scala-library/2.13.10/scala-library-2.13.10.jar [exists ], <HOME>/.cache/coursier/v1/https/repo1.maven.org/maven2/org/scalameta/mdoc-runtime_3/2.5.2/mdoc-runtime_3-2.5.2.jar [exists ], <HOME>/.cache/coursier/v1/https/repo1.maven.org/maven2/org/scala-lang/scala3-library_3/3.3.1/scala3-library_3-3.3.1.jar [exists ], <HOME>/.cache/coursier/v1/https/repo1.maven.org/maven2/com/lihaoyi/fansi_3/0.4.0/fansi_3-0.4.0.jar [exists ], <HOME>/.cache/coursier/v1/https/repo1.maven.org/maven2/com/lihaoyi/pprint_3/0.8.1/pprint_3-0.8.1.jar [exists ], <HOME>/.cache/coursier/v1/https/repo1.maven.org/maven2/org/scalameta/mdoc-interfaces/2.5.2/mdoc-interfaces-2.5.2.jar [exists ], <HOME>/.cache/coursier/v1/https/repo1.maven.org/maven2/org/scala-lang/scala-library/2.13.12/scala-library-2.13.12.jar [exists ], <HOME>/.cache/coursier/v1/https/repo1.maven.org/maven2/com/geirsson/metaconfig-pprint_3/0.12.0/metaconfig-pprint_3-0.12.0.jar [exists ], <HOME>/.cache/coursier/v1/https/repo1.maven.org/maven2/org/scala-lang/scala-reflect/2.13.12/scala-reflect-2.13.12.jar [exists ], <HOME>/.cache/coursier/v1/https/repo1.maven.org/maven2/org/scala-lang/scala3-library_3/3.3.1/scala3-library_3-3.3.1.jar [exists ], <HOME>/.cache/coursier/v1/https/repo1.maven.org/maven2/org/scala-lang/scala-library/2.13.10/scala-library-2.13.10.jar [exists ]
Options:



action parameters:
uri: file://<WORKSPACE>/src/main/scala/lab_06.worksheet.sc
text:
```scala
object worksheet{
  type Gradebook = List[(String, Int)]
  val gradebook = List(("G", 3), ("F", 10), ("M", 6), ("P", 4))
  def increment(g" Gradebook): Gradebook = {" +
    "
  
}
```



#### Error stacktrace:

```
scala.runtime.Scala3RunTime$.assertFailed(Scala3RunTime.scala:11)
	dotty.tools.dotc.parsing.Scanners$Scanner.lookahead(Scanners.scala:1083)
	dotty.tools.dotc.parsing.Parsers$Parser.termParamClause$$anonfun$1(Parsers.scala:3328)
	dotty.tools.dotc.parsing.Parsers$Parser.enclosed(Parsers.scala:556)
	dotty.tools.dotc.parsing.Parsers$Parser.inParens(Parsers.scala:558)
	dotty.tools.dotc.parsing.Parsers$Parser.termParamClause(Parsers.scala:3344)
	dotty.tools.dotc.parsing.Parsers$Parser.recur$6(Parsers.scala:3368)
	dotty.tools.dotc.parsing.Parsers$Parser.termParamClauses(Parsers.scala:3376)
	dotty.tools.dotc.parsing.Parsers$Parser.defDefOrDcl(Parsers.scala:3667)
	dotty.tools.dotc.parsing.Parsers$Parser.defOrDcl(Parsers.scala:3555)
	dotty.tools.dotc.parsing.Parsers$Parser.templateStatSeq$$anonfun$1(Parsers.scala:4224)
	dotty.tools.dotc.parsing.Parsers$Parser.checkNoEscapingPlaceholders(Parsers.scala:500)
	dotty.tools.dotc.parsing.Parsers$Parser.templateStatSeq(Parsers.scala:4232)
	dotty.tools.dotc.parsing.Parsers$Parser.$anonfun$39(Parsers.scala:4106)
	dotty.tools.dotc.parsing.Parsers$Parser.enclosed(Parsers.scala:556)
	dotty.tools.dotc.parsing.Parsers$Parser.inBraces(Parsers.scala:559)
	dotty.tools.dotc.parsing.Parsers$Parser.inBracesOrIndented(Parsers.scala:570)
	dotty.tools.dotc.parsing.Parsers$Parser.inDefScopeBraces(Parsers.scala:573)
	dotty.tools.dotc.parsing.Parsers$Parser.templateBody(Parsers.scala:4106)
	dotty.tools.dotc.parsing.Parsers$Parser.templateBodyOpt(Parsers.scala:4099)
	dotty.tools.dotc.parsing.Parsers$Parser.template(Parsers.scala:4076)
	dotty.tools.dotc.parsing.Parsers$Parser.templateOpt(Parsers.scala:4088)
	dotty.tools.dotc.parsing.Parsers$Parser.objectDef(Parsers.scala:3828)
	dotty.tools.dotc.parsing.Parsers$Parser.tmplDef(Parsers.scala:3782)
	dotty.tools.dotc.parsing.Parsers$Parser.defOrDcl(Parsers.scala:3561)
	dotty.tools.dotc.parsing.Parsers$Parser.topStatSeq(Parsers.scala:4163)
	dotty.tools.dotc.parsing.Parsers$Parser.topstats$1(Parsers.scala:4348)
	dotty.tools.dotc.parsing.Parsers$Parser.compilationUnit$$anonfun$1(Parsers.scala:4353)
	dotty.tools.dotc.parsing.Parsers$Parser.checkNoEscapingPlaceholders(Parsers.scala:500)
	dotty.tools.dotc.parsing.Parsers$Parser.compilationUnit(Parsers.scala:4358)
	dotty.tools.dotc.parsing.Parsers$Parser.parse(Parsers.scala:181)
	dotty.tools.dotc.parsing.Parser.parse$$anonfun$1(ParserPhase.scala:32)
	dotty.tools.dotc.parsing.Parser.parse$$anonfun$adapted$1(ParserPhase.scala:39)
	scala.Function0.apply$mcV$sp(Function0.scala:42)
	dotty.tools.dotc.core.Phases$Phase.monitor(Phases.scala:440)
	dotty.tools.dotc.parsing.Parser.parse(ParserPhase.scala:39)
	dotty.tools.dotc.parsing.Parser.runOn$$anonfun$1(ParserPhase.scala:48)
	scala.runtime.function.JProcedure1.apply(JProcedure1.java:15)
	scala.runtime.function.JProcedure1.apply(JProcedure1.java:10)
	scala.collection.immutable.List.foreach(List.scala:333)
	dotty.tools.dotc.parsing.Parser.runOn(ParserPhase.scala:48)
	dotty.tools.dotc.Run.runPhases$1$$anonfun$1(Run.scala:246)
	scala.runtime.function.JProcedure1.apply(JProcedure1.java:15)
	scala.runtime.function.JProcedure1.apply(JProcedure1.java:10)
	scala.collection.ArrayOps$.foreach$extension(ArrayOps.scala:1321)
	dotty.tools.dotc.Run.runPhases$1(Run.scala:262)
	dotty.tools.dotc.Run.compileUnits$$anonfun$1(Run.scala:270)
	dotty.tools.dotc.Run.compileUnits$$anonfun$adapted$1(Run.scala:279)
	dotty.tools.dotc.util.Stats$.maybeMonitored(Stats.scala:67)
	dotty.tools.dotc.Run.compileUnits(Run.scala:279)
	dotty.tools.dotc.Run.compileSources(Run.scala:194)
	dotty.tools.dotc.interactive.InteractiveDriver.run(InteractiveDriver.scala:165)
	scala.meta.internal.pc.MetalsDriver.run(MetalsDriver.scala:45)
	scala.meta.internal.pc.PcCollector.<init>(PcCollector.scala:44)
	scala.meta.internal.pc.PcSemanticTokensProvider$Collector$.<init>(PcSemanticTokensProvider.scala:61)
	scala.meta.internal.pc.PcSemanticTokensProvider.Collector$lzyINIT1(PcSemanticTokensProvider.scala:61)
	scala.meta.internal.pc.PcSemanticTokensProvider.Collector(PcSemanticTokensProvider.scala:61)
	scala.meta.internal.pc.PcSemanticTokensProvider.provide(PcSemanticTokensProvider.scala:90)
	scala.meta.internal.pc.ScalaPresentationCompiler.semanticTokens$$anonfun$1(ScalaPresentationCompiler.scala:109)
```
#### Short summary: 

java.lang.AssertionError: assertion failed