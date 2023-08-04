import org.portablescala.sbtplatformdeps.PlatformDepsPlugin.autoImport._
import sbt.Def.{setting => dep}
import sbt._

object Libs {
  val ScalaVersion = "3.3.0"
}

object Borer {
  //  val Version = "1.11.0"
  val Version = "687c9de"
  //  val Org     = "io.bullet"
  val Org = "com.github.tmtsoftware.borer"

  val `borer-core` = dep(Org %%% "borer-core" % Version)
  val `borer-derivation` = dep(Org %%% "borer-derivation" % Version)
  val `borer-compat-akka` = Org %% "borer-compat-akka" % Version
}

object Akka {
  val Version = "2.8.3" // all akka is Apache License 2.0
  val Org = "com.typesafe.akka"

  val `akka-actor` = Org %% "akka-actor" % Version
  val `akka-actor-typed` = Org %% "akka-actor-typed" % Version
}

object AkkaHttp {
  val Version = "10.5.2"
  val Org = "com.typesafe.akka"

  val `akka-http` = Org %% "akka-http" % Version
}
