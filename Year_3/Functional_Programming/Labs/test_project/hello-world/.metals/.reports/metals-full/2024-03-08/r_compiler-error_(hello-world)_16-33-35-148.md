file://<WORKSPACE>/src/main/scala/Main.worksheet.sc
### file%3A%2F%2F%2Fhome%2Fione%2FDocuments%2FUniversity%2FYear_3%2FFunctional_Programming%2FLabs%2Ftest_project%2Fhello-world%2Fsrc%2Fmain%2Fscala%2FMain.worksheet.sc:3: error: illegal start of simple pattern

^

occurred in the presentation compiler.

presentation compiler configuration:
Scala version: 2.13.12
Classpath:
/modules [exists ], <WORKSPACE>/.bloop/hello-world/bloop-bsp-clients-classes/classes-Metals-oICkoWIHRR2Clu-IArjGqg== [exists ], <HOME>/.cache/coursier/v1/https/repo1.maven.org/maven2/com/sourcegraph/semanticdb-javac/0.9.9/semanticdb-javac-0.9.9.jar [exists ], <HOME>/.cache/coursier/v1/https/repo1.maven.org/maven2/org/scala-lang/scala-library/2.13.12/scala-library-2.13.12.jar [exists ], <HOME>/.cache/coursier/v1/https/repo1.maven.org/maven2/org/scala-lang/modules/scala-parser-combinators_2.13/2.3.0/scala-parser-combinators_2.13-2.3.0.jar [exists ], <HOME>/.cache/coursier/v1/https/repo1.maven.org/maven2/org/scalameta/mdoc-runtime_2.13/2.5.2/mdoc-runtime_2.13-2.5.2.jar [exists ], <HOME>/.cache/coursier/v1/https/repo1.maven.org/maven2/com/lihaoyi/fansi_2.13/0.4.0/fansi_2.13-0.4.0.jar [exists ], <HOME>/.cache/coursier/v1/https/repo1.maven.org/maven2/com/lihaoyi/pprint_2.13/0.8.1/pprint_2.13-0.8.1.jar [exists ], <HOME>/.cache/coursier/v1/https/repo1.maven.org/maven2/org/scala-lang/scala-reflect/2.13.12/scala-reflect-2.13.12.jar [exists ], <HOME>/.cache/coursier/v1/https/repo1.maven.org/maven2/org/scalameta/mdoc-interfaces/2.5.2/mdoc-interfaces-2.5.2.jar [exists ], <HOME>/.cache/coursier/v1/https/repo1.maven.org/maven2/com/geirsson/metaconfig-pprint_2.13/0.12.0/metaconfig-pprint_2.13-0.12.0.jar [exists ]
Options:
-Yrangepos -Xplugin-require:semanticdb


action parameters:
uri: file://<WORKSPACE>/src/main/scala/Main.worksheet.sc
text:
```scala
val x = 4
val 


```



#### Error stacktrace:

```
scala.meta.internal.parsers.Reporter.syntaxError(Reporter.scala:16)
	scala.meta.internal.parsers.Reporter.syntaxError$(Reporter.scala:16)
	scala.meta.internal.parsers.Reporter$$anon$1.syntaxError(Reporter.scala:22)
	scala.meta.internal.parsers.Reporter.syntaxError(Reporter.scala:17)
	scala.meta.internal.parsers.Reporter.syntaxError$(Reporter.scala:17)
	scala.meta.internal.parsers.Reporter$$anon$1.syntaxError(Reporter.scala:22)
	scala.meta.internal.parsers.ScalametaParser$SeqContextSensitive.badPattern3(ScalametaParser.scala:2785)
	scala.meta.internal.parsers.ScalametaParser$SeqContextSensitive.badPattern3$(ScalametaParser.scala:2765)
	scala.meta.internal.parsers.ScalametaParser$noSeq$.badPattern3(ScalametaParser.scala:2884)
	scala.meta.internal.parsers.ScalametaParser$SeqContextSensitive.$anonfun$pattern3$1(ScalametaParser.scala:2743)
	scala.meta.internal.parsers.ScalametaParser$SeqContextSensitive.$anonfun$simplePattern$2(ScalametaParser.scala:2871)
	scala.meta.internal.parsers.ScalametaParser.atPos(ScalametaParser.scala:319)
	scala.meta.internal.parsers.ScalametaParser.autoPos(ScalametaParser.scala:365)
	scala.meta.internal.parsers.ScalametaParser$SeqContextSensitive.simplePattern(ScalametaParser.scala:2796)
	scala.meta.internal.parsers.ScalametaParser$SeqContextSensitive.simplePattern$(ScalametaParser.scala:2791)
	scala.meta.internal.parsers.ScalametaParser$noSeq$.simplePattern(ScalametaParser.scala:2884)
	scala.meta.internal.parsers.ScalametaParser$SeqContextSensitive.pattern3(ScalametaParser.scala:2743)
	scala.meta.internal.parsers.ScalametaParser$SeqContextSensitive.pattern3$(ScalametaParser.scala:2741)
	scala.meta.internal.parsers.ScalametaParser$noSeq$.pattern3(ScalametaParser.scala:2884)
	scala.meta.internal.parsers.ScalametaParser$SeqContextSensitive.pattern2(ScalametaParser.scala:2718)
	scala.meta.internal.parsers.ScalametaParser$SeqContextSensitive.pattern2$(ScalametaParser.scala:2717)
	scala.meta.internal.parsers.ScalametaParser$noSeq$.pattern2(ScalametaParser.scala:2884)
	scala.meta.internal.parsers.ScalametaParser.$anonfun$patDefOrDcl$2(ScalametaParser.scala:3582)
	scala.meta.internal.parsers.ScalametaParser.$anonfun$commaSeparated$1(ScalametaParser.scala:655)
	scala.meta.internal.parsers.ScalametaParser.$anonfun$commaSeparated$1$adapted(ScalametaParser.scala:655)
	scala.meta.internal.parsers.ScalametaParser.iter$1(ScalametaParser.scala:645)
	scala.meta.internal.parsers.ScalametaParser.$anonfun$tokenSeparated$1(ScalametaParser.scala:651)
	scala.meta.internal.parsers.ScalametaParser.$anonfun$tokenSeparated$1$adapted(ScalametaParser.scala:638)
	scala.meta.internal.parsers.ScalametaParser.scala$meta$internal$parsers$ScalametaParser$$listBy(ScalametaParser.scala:567)
	scala.meta.internal.parsers.ScalametaParser.tokenSeparated(ScalametaParser.scala:638)
	scala.meta.internal.parsers.ScalametaParser.commaSeparatedWithIndex(ScalametaParser.scala:658)
	scala.meta.internal.parsers.ScalametaParser.commaSeparated(ScalametaParser.scala:655)
	scala.meta.internal.parsers.ScalametaParser.$anonfun$patDefOrDcl$1(ScalametaParser.scala:3582)
	scala.meta.internal.parsers.ScalametaParser.autoEndPos(ScalametaParser.scala:368)
	scala.meta.internal.parsers.ScalametaParser.autoEndPos(ScalametaParser.scala:373)
	scala.meta.internal.parsers.ScalametaParser.patDefOrDcl(ScalametaParser.scala:3576)
	scala.meta.internal.parsers.ScalametaParser.defOrDclOrSecondaryCtor(ScalametaParser.scala:3538)
	scala.meta.internal.parsers.ScalametaParser.nonLocalDefOrDcl(ScalametaParser.scala:3523)
	scala.meta.internal.parsers.ScalametaParser$$anonfun$1.applyOrElse(ScalametaParser.scala:4382)
	scala.meta.internal.parsers.ScalametaParser$$anonfun$1.applyOrElse(ScalametaParser.scala:4377)
	scala.PartialFunction.$anonfun$runWith$1(PartialFunction.scala:231)
	scala.PartialFunction.$anonfun$runWith$1$adapted(PartialFunction.scala:230)
	scala.meta.internal.parsers.ScalametaParser.statSeqBuf(ScalametaParser.scala:4440)
	scala.meta.internal.parsers.ScalametaParser.$anonfun$batchSource$13(ScalametaParser.scala:4674)
	scala.Option.getOrElse(Option.scala:201)
	scala.meta.internal.parsers.ScalametaParser.$anonfun$batchSource$1(ScalametaParser.scala:4674)
	scala.meta.internal.parsers.ScalametaParser.atPos(ScalametaParser.scala:319)
	scala.meta.internal.parsers.ScalametaParser.autoPos(ScalametaParser.scala:365)
	scala.meta.internal.parsers.ScalametaParser.batchSource(ScalametaParser.scala:4630)
	scala.meta.internal.parsers.ScalametaParser.$anonfun$source$1(ScalametaParser.scala:4623)
	scala.meta.internal.parsers.ScalametaParser.atPos(ScalametaParser.scala:319)
	scala.meta.internal.parsers.ScalametaParser.autoPos(ScalametaParser.scala:365)
	scala.meta.internal.parsers.ScalametaParser.source(ScalametaParser.scala:4623)
	scala.meta.internal.parsers.ScalametaParser.entrypointSource(ScalametaParser.scala:4628)
	scala.meta.internal.parsers.ScalametaParser.parseSourceImpl(ScalametaParser.scala:135)
	scala.meta.internal.parsers.ScalametaParser.$anonfun$parseSource$1(ScalametaParser.scala:132)
	scala.meta.internal.parsers.ScalametaParser.parseRuleAfterBOF(ScalametaParser.scala:59)
	scala.meta.internal.parsers.ScalametaParser.parseRule(ScalametaParser.scala:54)
	scala.meta.internal.parsers.ScalametaParser.parseSource(ScalametaParser.scala:132)
	scala.meta.parsers.Parse$.$anonfun$parseSource$1(Parse.scala:29)
	scala.meta.parsers.Parse$$anon$1.apply(Parse.scala:36)
	scala.meta.parsers.Api$XtensionParseDialectInput.parse(Api.scala:25)
	scala.meta.internal.semanticdb.scalac.ParseOps$XtensionCompilationUnitSource.toSource(ParseOps.scala:17)
	scala.meta.internal.semanticdb.scalac.TextDocumentOps$XtensionCompilationUnitDocument.toTextDocument(TextDocumentOps.scala:206)
	scala.meta.internal.pc.SemanticdbTextDocumentProvider.textDocument(SemanticdbTextDocumentProvider.scala:54)
	scala.meta.internal.pc.ScalaPresentationCompiler.$anonfun$semanticdbTextDocument$1(ScalaPresentationCompiler.scala:384)
```
#### Short summary: 

file%3A%2F%2F%2Fhome%2Fione%2FDocuments%2FUniversity%2FYear_3%2FFunctional_Programming%2FLabs%2Ftest_project%2Fhello-world%2Fsrc%2Fmain%2Fscala%2FMain.worksheet.sc:3: error: illegal start of simple pattern

^