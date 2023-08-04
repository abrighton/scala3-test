# scala3-test

Test issue with scala-3.3.0: "dotty.tools.FatalError: cannot resolve reference ..."

This small test project demonstrates an error with the scala3 compiler.

This is the result I get when compiling with java17, scala-3.3.0:

```shell
> sbt compile
[info] welcome to sbt 1.9.3 (Private Build Java 17.0.8)
[info] loading global plugins from /home/abrighto/.sbt/1.0/plugins
[info] loading settings for project scala3-test-build from plugins.sbt ...
[info] loading project definition from /testDir/scala3-test/project
[info] compiling 3 Scala sources to /testDir/scala3-test/project/target/scala-2.12/sbt-1.0/classes ...
[info] loading settings for project root from build.sbt ...
[info] set current project to scala3-test (in build file:/testDir/scala3-test/)
[info] Executing in batch mode. For better performance use sbt's shell
[info] compiling 6 Scala sources to /testDir/scala3-test/target/scala-3.3.0/classes ...
dotty.tools.FatalError: cannot resolve reference to type org.apache.pekko.stream.scaladsl.type.Source
the classfile defining the type might be missing from the classpath while typechecking /testDir/scala3-test/src/main/scala/csw/commons/http/JsonSupport.scala
[info] exception occurred while typechecking /testDir/scala3-test/src/main/scala/csw/commons/http/JsonSupport.scala
[info] exception occurred while compiling /testDir/scala3-test/src/main/scala/csw/commons/CborPekkoSerializer.scala, /testDir/scala3-test/src/main/scala/csw/commons/ResourceReader.scala, /testDir/scala3-test/src/main/scala/csw/commons/http/ErrorResponse.scala, /testDir/scala3-test/src/main/scala/csw/commons/http/JsonRejectionHandler.scala, /testDir/scala3-test/src/main/scala/csw/commons/http/JsonSupport.scala, /testDir/scala3-test/src/main/scala/csw/commons/http/codecs/ErrorCodecs.scala
[error] cannot resolve reference to type org.apache.pekko.stream.scaladsl.type.Source
[error] the classfile defining the type might be missing from the classpath
[error] (Compile / compileIncremental) Compilation failed
[error] Total time: 3 s, completed Aug 4, 2023, 11:05:34 PM
```

I have not found any references to `org.apache.pekko.stream.scaladsl.type.Source` in any of the dependencies or in this code.

Note that the akka version (branch: "akka-version") shows the same error:

```shell
> sbt compile
[info] welcome to sbt 1.9.3 (Private Build Java 17.0.8)
[info] loading global plugins from /home/abrighto/.sbt/1.0/plugins
[info] loading settings for project scala3-test-build from plugins.sbt ...
[info] loading project definition from /testDir/scala3-test/project
[info] loading settings for project root from build.sbt ...
[info] set current project to scala3-test (in build file:/testDir/scala3-test/)
[info] Executing in batch mode. For better performance use sbt's shell
[info] compiling 6 Scala sources to /testDir/scala3-test/target/scala-3.3.0/classes ...
dotty.tools.FatalError: cannot resolve reference to type akka.stream.scaladsl.type.Source
the classfile defining the type might be missing from the classpath while typechecking /testDir/scala3-test/src/main/scala/csw/commons/http/JsonSupport.scala
[info] exception occurred while typechecking /testDir/scala3-test/src/main/scala/csw/commons/http/JsonSupport.scala
[info] exception occurred while compiling /testDir/scala3-test/src/main/scala/csw/commons/CborPekkoSerializer.scala, /testDir/scala3-test/src/main/scala/csw/commons/ResourceReader.scala, /testDir/scala3-test/src/main/scala/csw/commons/http/ErrorResponse.scala, /testDir/scala3-test/src/main/scala/csw/commons/http/JsonRejectionHandler.scala, /testDir/scala3-test/src/main/scala/csw/commons/http/JsonSupport.scala, /testDir/scala3-test/src/main/scala/csw/commons/http/codecs/ErrorCodecs.scala
[error] cannot resolve reference to type akka.stream.scaladsl.type.Source
[error] the classfile defining the type might be missing from the classpath
[error] (Compile / compileIncremental) Compilation failed
[error] Total time: 3 s, completed Aug 4, 2023, 11:14:27 PM
```