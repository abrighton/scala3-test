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
  val `borer-compat-pekko` = Org %% "borer-compat-pekko" % Version
}

object Pekko {
  val Version = "1.0.1" // all pekko is Apache License 2.0
  val Org = "org.apache.pekko"

  val `pekko-actor` = Org %% "pekko-actor" % Version
  val `pekko-actor-typed` = Org %% "pekko-actor-typed" % Version
}

object PekkoHttp {
  val Version = "1.0.0"
  val Org = "org.apache.pekko"

  val `pekko-http` = Org %% "pekko-http" % Version
}
