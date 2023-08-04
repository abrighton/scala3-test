# scala3-test

Test issue with pekko, borer and scala3.

This small test project demonstrates an error with the scala3 compiler, pekko or borer (not sure which).

This is the result I get when compiling:

```shell
> sbt compile
[info] welcome to sbt 1.9.3 (Private Build Java 17.0.8)
[info] loading global plugins from /home/abrighto/.sbt/1.0/plugins
[info] loading settings for project scala3-test-build from plugins.sbt ...
[info] loading project definition from /shared/work/tmt/pekko/scala-3/scala3-test/project
[info] compiling 3 Scala sources to /shared/work/tmt/pekko/scala-3/scala3-test/project/target/scala-2.12/sbt-1.0/classes ...
[info] loading settings for project root from build.sbt ...
[info] set current project to scala3-test (in build file:/shared/work/tmt/pekko/scala-3/scala3-test/)
[info] Executing in batch mode. For better performance use sbt's shell
[info] compiling 6 Scala sources to /shared/work/tmt/pekko/scala-3/scala3-test/target/scala-3.3.0/classes ...
dotty.tools.FatalError: cannot resolve reference to type org.apache.pekko.stream.scaladsl.type.Source
the classfile defining the type might be missing from the classpath while typechecking /shared/work/tmt/pekko/scala-3/scala3-test/src/main/scala/csw/commons/http/JsonSupport.scala
[info] exception occurred while typechecking /shared/work/tmt/pekko/scala-3/scala3-test/src/main/scala/csw/commons/http/JsonSupport.scala
[info] exception occurred while compiling /shared/work/tmt/pekko/scala-3/scala3-test/src/main/scala/csw/commons/CborPekkoSerializer.scala, /shared/work/tmt/pekko/scala-3/scala3-test/src/main/scala/csw/commons/ResourceReader.scala, /shared/work/tmt/pekko/scala-3/scala3-test/src/main/scala/csw/commons/http/ErrorResponse.scala, /shared/work/tmt/pekko/scala-3/scala3-test/src/main/scala/csw/commons/http/JsonRejectionHandler.scala, /shared/work/tmt/pekko/scala-3/scala3-test/src/main/scala/csw/commons/http/JsonSupport.scala, /shared/work/tmt/pekko/scala-3/scala3-test/src/main/scala/csw/commons/http/codecs/ErrorCodecs.scala
[error] cannot resolve reference to type org.apache.pekko.stream.scaladsl.type.Source
[error] the classfile defining the type might be missing from the classpath
[error] (Compile / compileIncremental) Compilation failed
[error] Total time: 3 s, completed Aug 4, 2023, 11:05:34 PM

```

I have not found any references to `org.apache.pekko.stream.scaladsl.type.Source` in any of the dependencies or in this code.
