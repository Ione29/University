file://<WORKSPACE>/.metals/.tmp/Main1048631546757585694.scala
### scala.reflect.internal.FatalError: 
  bad constant pool index: 0 at pos: 49180
     while compiling: <no file>
        during phase: globalPhase=<no phase>, enteringPhase=<some phase>
     library version: version 2.13.8
    compiler version: version 2.13.8
  reconstructed args: -classpath <HOME>/.cache/coursier/v1/https/repo1.maven.org/maven2/org/scala-lang/scala-library/2.13.8/scala-library-2.13.8.jar -Ymacro-expand:discard -Ycache-plugin-class-loader:last-modified -Ypresentation-any-thread

  last tree to typer: EmptyTree
       tree position: <unknown>
            tree tpe: <notype>
              symbol: null
           call site: <none> in <none>

== Source file context for tree position ==



occurred in the presentation compiler.

presentation compiler configuration:
Scala version: 2.13.8
Classpath:
<HOME>/.cache/coursier/v1/https/repo1.maven.org/maven2/org/scala-lang/scala-library/2.13.8/scala-library-2.13.8.jar [exists ]
Options:



action parameters:
uri: file://<WORKSPACE>/.metals/.tmp/Main1048631546757585694.scala
text:
```scala
object Main{}

```



#### Error stacktrace:

```
scala.reflect.internal.Reporting.abort(Reporting.scala:69)
	scala.reflect.internal.Reporting.abort$(Reporting.scala:65)
	scala.reflect.internal.SymbolTable.abort(SymbolTable.scala:28)
	scala.tools.nsc.symtab.classfile.ClassfileParser$ConstantPool.errorBadIndex(ClassfileParser.scala:407)
	scala.tools.nsc.symtab.classfile.ClassfileParser$ConstantPool.getExternalName(ClassfileParser.scala:262)
	scala.tools.nsc.symtab.classfile.ClassfileParser.readParamNames$1(ClassfileParser.scala:853)
	scala.tools.nsc.symtab.classfile.ClassfileParser.parseAttribute$1(ClassfileParser.scala:859)
	scala.tools.nsc.symtab.classfile.ClassfileParser.$anonfun$parseAttributes$6(ClassfileParser.scala:936)
	scala.tools.nsc.symtab.classfile.ClassfileParser.parseAttributes(ClassfileParser.scala:936)
	scala.tools.nsc.symtab.classfile.ClassfileParser.parseMethod(ClassfileParser.scala:635)
	scala.tools.nsc.symtab.classfile.ClassfileParser.parseClass(ClassfileParser.scala:548)
	scala.tools.nsc.symtab.classfile.ClassfileParser.$anonfun$parse$2(ClassfileParser.scala:174)
	scala.tools.nsc.symtab.classfile.ClassfileParser.$anonfun$parse$1(ClassfileParser.scala:159)
	scala.tools.nsc.symtab.classfile.ClassfileParser.parse(ClassfileParser.scala:142)
	scala.tools.nsc.symtab.SymbolLoaders$ClassfileLoader.doComplete(SymbolLoaders.scala:342)
	scala.tools.nsc.symtab.SymbolLoaders$SymbolLoader.$anonfun$complete$2(SymbolLoaders.scala:249)
	scala.tools.nsc.symtab.SymbolLoaders$SymbolLoader.complete(SymbolLoaders.scala:247)
	scala.reflect.internal.Symbols$Symbol.completeInfo(Symbols.scala:1561)
	scala.reflect.internal.Symbols$Symbol.info(Symbols.scala:1533)
	scala.reflect.internal.Definitions.scala$reflect$internal$Definitions$$enterNewMethod(Definitions.scala:47)
	scala.reflect.internal.Definitions$DefinitionsClass.String_$plus$lzycompute(Definitions.scala:1256)
	scala.reflect.internal.Definitions$DefinitionsClass.String_$plus(Definitions.scala:1256)
	scala.reflect.internal.Definitions$DefinitionsClass.syntheticCoreMethods$lzycompute(Definitions.scala:1577)
	scala.reflect.internal.Definitions$DefinitionsClass.syntheticCoreMethods(Definitions.scala:1559)
	scala.reflect.internal.Definitions$DefinitionsClass.symbolsNotPresentInBytecode$lzycompute(Definitions.scala:1590)
	scala.reflect.internal.Definitions$DefinitionsClass.symbolsNotPresentInBytecode(Definitions.scala:1590)
	scala.reflect.internal.Definitions$DefinitionsClass.init(Definitions.scala:1646)
	scala.tools.nsc.Global$Run.<init>(Global.scala:1226)
	scala.tools.nsc.interactive.Global$TyperRun.<init>(Global.scala:1331)
	scala.tools.nsc.interactive.Global.newTyperRun(Global.scala:1354)
	scala.tools.nsc.interactive.Global.<init>(Global.scala:294)
	scala.meta.internal.pc.MetalsGlobal.<init>(MetalsGlobal.scala:40)
	scala.meta.internal.pc.ScalaPresentationCompiler.newCompiler(ScalaPresentationCompiler.scala:450)
```
#### Short summary: 

scala.reflect.internal.FatalError: 
  bad constant pool index: 0 at pos: 49180
     while compiling: <no file>
        during phase: globalPhase=<no phase>, enteringPhase=<some phase>
     library version: version 2.13.8
    compiler version: version 2.13.8
  reconstructed args: -classpath <HOME>/.cache/coursier/v1/https/repo1.maven.org/maven2/org/scala-lang/scala-library/2.13.8/scala-library-2.13.8.jar -Ymacro-expand:discard -Ycache-plugin-class-loader:last-modified -Ypresentation-any-thread

  last tree to typer: EmptyTree
       tree position: <unknown>
            tree tpe: <notype>
              symbol: null
           call site: <none> in <none>

== Source file context for tree position ==

