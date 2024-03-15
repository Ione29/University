file://<WORKSPACE>/src/main/scala/Main.worksheet.sc
### file%3A%2F%2F%2Fhome%2Fione%2FDocuments%2FUniversity%2FYear_3%2FFunctional_Programming%2FCourses%2Fcourse_01%2Fsrc%2Fmain%2Fscala%2FMain.worksheet.sc:44: error: unclosed quoted identifier
`
^

occurred in the presentation compiler.

presentation compiler configuration:
Scala version: 2.13.12
Classpath:
/modules [exists ], <WORKSPACE>/.bloop/course_01/bloop-bsp-clients-classes/classes-Metals-RyU9M3MfQbiUn3rHoctzeg== [exists ], <HOME>/.cache/bloop/semanticdb/com.sourcegraph.semanticdb-javac.0.9.9/semanticdb-javac-0.9.9.jar [exists ], <HOME>/.cache/coursier/v1/https/repo1.maven.org/maven2/org/scala-lang/scala-library/2.13.12/scala-library-2.13.12.jar [exists ], <HOME>/.cache/coursier/v1/https/repo1.maven.org/maven2/org/scala-lang/modules/scala-parser-combinators_2.13/2.3.0/scala-parser-combinators_2.13-2.3.0.jar [exists ], <HOME>/.cache/coursier/v1/https/repo1.maven.org/maven2/org/scalameta/mdoc-runtime_2.13/2.5.2/mdoc-runtime_2.13-2.5.2.jar [exists ], <HOME>/.cache/coursier/v1/https/repo1.maven.org/maven2/com/lihaoyi/fansi_2.13/0.4.0/fansi_2.13-0.4.0.jar [exists ], <HOME>/.cache/coursier/v1/https/repo1.maven.org/maven2/com/lihaoyi/pprint_2.13/0.8.1/pprint_2.13-0.8.1.jar [exists ], <HOME>/.cache/coursier/v1/https/repo1.maven.org/maven2/org/scala-lang/scala-reflect/2.13.12/scala-reflect-2.13.12.jar [exists ], <HOME>/.cache/coursier/v1/https/repo1.maven.org/maven2/org/scalameta/mdoc-interfaces/2.5.2/mdoc-interfaces-2.5.2.jar [exists ], <HOME>/.cache/coursier/v1/https/repo1.maven.org/maven2/com/geirsson/metaconfig-pprint_2.13/0.12.0/metaconfig-pprint_2.13-0.12.0.jar [exists ]
Options:
-Yrangepos -Xplugin-require:semanticdb


action parameters:
uri: file://<WORKSPACE>/src/main/scala/Main.worksheet.sc
text:
```scala
val n = 5
var i = 1
var factorial = 1

while(i <= n){
    factorial *= i
    i += 1
}

factorial

"matei"
1 + 2

if(1 == 2) true //this is not a nice expression
if(1 == 2) true else false //this is good becuase we define both cases

val m = 5

def fact(n : Int): Int = {
    if (n == 0) 1
    else n* fact(n - 1)
}

fact(5)

// we are given with an interval [a, b] and we want to tcheck if there is a prime number between a and b

def checkPrime(a: Int, b: Int): Boolean = {
    
    def isPrime(i: Int, n: Int): Boolean = {
        if(i >= n) true
        else if(n % i == 0) false
        else isPrime(i + 1, n)
    }

    if(isPrime(2, a)) true
    else if (a == b) false
    else checkPrime(a + 1, b)   
}

checkPrime(8, 10)
checkPrime(10, 20)
`
//implement a function that computes the fibonacci number

def findFibo(i: Int, n: Int, res: Int): Int = {
    if(i > n) res
    else findFibo(i + 1, n, res + i)
}

findFibo(1, 9, 0)
```



#### Error stacktrace:

```
scala.meta.internal.tokenizers.Reporter.syntaxError(Reporter.scala:23)
	scala.meta.internal.tokenizers.Reporter.syntaxError$(Reporter.scala:23)
	scala.meta.internal.tokenizers.Reporter$$anon$1.syntaxError(Reporter.scala:33)
	scala.meta.internal.tokenizers.Reporter.syntaxError(Reporter.scala:25)
	scala.meta.internal.tokenizers.Reporter.syntaxError$(Reporter.scala:25)
	scala.meta.internal.tokenizers.Reporter$$anon$1.syntaxError(Reporter.scala:33)
	scala.meta.internal.tokenizers.LegacyScanner.getBackquotedIdent(LegacyScanner.scala:489)
	scala.meta.internal.tokenizers.LegacyScanner.fetchToken(LegacyScanner.scala:337)
	scala.meta.internal.tokenizers.LegacyScanner.nextToken(LegacyScanner.scala:211)
	scala.meta.internal.tokenizers.LegacyScanner.foreach(LegacyScanner.scala:1011)
	scala.meta.internal.tokenizers.ScalametaTokenizer.uncachedTokenize(ScalametaTokenizer.scala:24)
	scala.meta.internal.tokenizers.ScalametaTokenizer.$anonfun$tokenize$1(ScalametaTokenizer.scala:17)
	scala.collection.concurrent.TrieMap.getOrElseUpdate(TrieMap.scala:962)
	scala.meta.internal.tokenizers.ScalametaTokenizer.tokenize(ScalametaTokenizer.scala:17)
	scala.meta.internal.tokenizers.ScalametaTokenizer$$anon$2.apply(ScalametaTokenizer.scala:332)
	scala.meta.tokenizers.Api$XtensionTokenizeDialectInput.tokenize(Api.scala:25)
	scala.meta.tokenizers.Api$XtensionTokenizeInputLike.tokenize(Api.scala:14)
	scala.meta.internal.parsers.ScannerTokens$.apply(ScannerTokens.scala:953)
	scala.meta.internal.parsers.ScalametaParser.<init>(ScalametaParser.scala:33)
	scala.meta.parsers.Parse$$anon$1.apply(Parse.scala:35)
	scala.meta.parsers.Api$XtensionParseDialectInput.parse(Api.scala:25)
	scala.meta.internal.semanticdb.scalac.ParseOps$XtensionCompilationUnitSource.toSource(ParseOps.scala:17)
	scala.meta.internal.semanticdb.scalac.TextDocumentOps$XtensionCompilationUnitDocument.toTextDocument(TextDocumentOps.scala:206)
	scala.meta.internal.pc.SemanticdbTextDocumentProvider.textDocument(SemanticdbTextDocumentProvider.scala:54)
	scala.meta.internal.pc.ScalaPresentationCompiler.$anonfun$semanticdbTextDocument$1(ScalaPresentationCompiler.scala:384)
```
#### Short summary: 

file%3A%2F%2F%2Fhome%2Fione%2FDocuments%2FUniversity%2FYear_3%2FFunctional_Programming%2FCourses%2Fcourse_01%2Fsrc%2Fmain%2Fscala%2FMain.worksheet.sc:44: error: unclosed quoted identifier
`
^