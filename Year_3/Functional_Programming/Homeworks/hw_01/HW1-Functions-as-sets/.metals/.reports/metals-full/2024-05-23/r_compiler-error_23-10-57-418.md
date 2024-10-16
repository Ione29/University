file://<WORKSPACE>/project/metals.sbt
### scala.reflect.internal.FatalError: 
  bad constant pool index: 0 at pos: 49180
     while compiling: <no file>
        during phase: globalPhase=<no phase>, enteringPhase=<some phase>
     library version: version 2.13.10
    compiler version: version 2.13.10
  reconstructed args: -classpath <HOME>/.cache/coursier/v1/https/repo1.maven.org/maven2/org/scala-lang/scala-library/2.13.10/scala-library-2.13.10.jar -Ymacro-expand:discard -Ycache-plugin-class-loader:last-modified -Ypresentation-any-thread

  last tree to typer: EmptyTree
       tree position: <unknown>
            tree tpe: <notype>
              symbol: null
           call site: <none> in <none>

== Source file context for tree position ==



occurred in the presentation compiler.

presentation compiler configuration:
Scala version: 2.13.10
Classpath:
<HOME>/.cache/coursier/v1/https/repo1.maven.org/maven2/org/scala-lang/scala-library/2.13.10/scala-library-2.13.10.jar [exists ]
Options:



action parameters:
uri: file://<WORKSPACE>/project/metals.sbt
text:
```scala
// format: off
// DO NOT EDIT! This file is auto-generated.

// This file enables sbt-bloop to create bloop config files.

addSbtPlugin("ch.epfl.scala" % "sbt-bloop" % "1.5.17")

// format: on

```



#### Error stacktrace:

```
scala.reflect.internal.Reporting.abort(Reporting.scala:69)
	scala.reflect.internal.Reporting.abort$(Reporting.scala:65)
	scala.reflect.internal.SymbolTable.abort(SymbolTable.scala:28)
	scala.tools.nsc.symtab.classfile.ClassfileParser$ConstantPool.errorBadIndex(ClassfileParser.scala:408)
	scala.tools.nsc.symtab.classfile.ClassfileParser$ConstantPool.getExternalName(ClassfileParser.scala:263)
	scala.tools.nsc.symtab.classfile.ClassfileParser.readParamNames$1(ClassfileParser.scala:842)
	scala.tools.nsc.symtab.classfile.ClassfileParser.parseAttribute$1(ClassfileParser.scala:848)
	scala.tools.nsc.symtab.classfile.ClassfileParser.$anonfun$parseAttributes$6(ClassfileParser.scala:925)
	scala.tools.nsc.symtab.classfile.ClassfileParser.parseAttributes(ClassfileParser.scala:1497)
	scala.tools.nsc.symtab.classfile.ClassfileParser.parseMethod(ClassfileParser.scala:625)
	scala.tools.nsc.symtab.classfile.ClassfileParser.parseClass(ClassfileParser.scala:548)
	scala.tools.nsc.symtab.classfile.ClassfileParser.$anonfun$parse$2(ClassfileParser.scala:175)
	scala.tools.nsc.symtab.classfile.ClassfileParser.$anonfun$parse$1(ClassfileParser.scala:160)
	scala.tools.nsc.symtab.classfile.ClassfileParser.parse(ClassfileParser.scala:143)
	scala.tools.nsc.symtab.SymbolLoaders$ClassfileLoader.doComplete(SymbolLoaders.scala:342)
	scala.tools.nsc.symtab.SymbolLoaders$SymbolLoader.$anonfun$complete$2(SymbolLoaders.scala:249)
	scala.tools.nsc.symtab.SymbolLoaders$SymbolLoader.complete(SymbolLoaders.scala:247)
	scala.reflect.internal.Symbols$Symbol.completeInfo(Symbols.scala:1563)
	scala.reflect.internal.Symbols$Symbol.info(Symbols.scala:1535)
	scala.reflect.internal.Definitions.scala$reflect$internal$Definitions$$enterNewMethod(Definitions.scala:48)
	scala.reflect.internal.Definitions$DefinitionsClass.String_$plus$lzycompute(Definitions.scala:1261)
	scala.reflect.internal.Definitions$DefinitionsClass.String_$plus(Definitions.scala:1261)
	scala.reflect.internal.Definitions$DefinitionsClass.syntheticCoreMethods$lzycompute(Definitions.scala:1583)
	scala.reflect.internal.Definitions$DefinitionsClass.syntheticCoreMethods(Definitions.scala:1565)
	scala.reflect.internal.Definitions$DefinitionsClass.symbolsNotPresentInBytecode$lzycompute(Definitions.scala:1596)
	scala.reflect.internal.Definitions$DefinitionsClass.symbolsNotPresentInBytecode(Definitions.scala:1596)
	scala.reflect.internal.Definitions$DefinitionsClass.init(Definitions.scala:1652)
	scala.tools.nsc.Global$Run.<init>(Global.scala:1236)
	scala.tools.nsc.interactive.Global$TyperRun.<init>(Global.scala:1351)
	scala.tools.nsc.interactive.Global.newTyperRun(Global.scala:1374)
	scala.tools.nsc.interactive.Global.<init>(Global.scala:294)
	scala.meta.internal.pc.MetalsGlobal.<init>(MetalsGlobal.scala:40)
	scala.meta.internal.pc.ScalaPresentationCompiler.newCompiler(ScalaPresentationCompiler.scala:453)
```
#### Short summary: 

scala.reflect.internal.FatalError: 
  bad constant pool index: 0 at pos: 49180
     while compiling: <no file>
        during phase: globalPhase=<no phase>, enteringPhase=<some phase>
     library version: version 2.13.10
    compiler version: version 2.13.10
  reconstructed args: -classpath <HOME>/.cache/coursier/v1/https/repo1.maven.org/maven2/org/scala-lang/scala-library/2.13.10/scala-library-2.13.10.jar -Ymacro-expand:discard -Ycache-plugin-class-loader:last-modified -Ypresentation-any-thread

  last tree to typer: EmptyTree
       tree position: <unknown>
            tree tpe: <notype>
              symbol: null
           call site: <none> in <none>

== Source file context for tree position ==

