import org.portablescala.sbtplatformdeps.PlatformDepsPlugin.autoImport._
import sbt.Def.{setting => dep}
import sbt._

object Libs {
  val ScalaVersion = "3.3.0"
  val `play-json` = "com.typesafe.play" %% "play-json" % "2.10.0-RC9"
}

object Borer {
    val Version = "1.11.0"
    val Org     = "io.bullet"

  val `borer-core` = dep(Org %%% "borer-core" % Version)
  val `borer-derivation` = dep(Org %%% "borer-derivation" % Version)
  val `borer-compat-pekko` = Org %% "borer-compat-pekko" % Version
}

