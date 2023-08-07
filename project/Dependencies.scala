import sbt.*

object Dependencies {

  val ScalaTestDeps = Def.setting(
    Seq(
      Libs.`play-json`,
      Borer.`borer-compat-pekko` % Provided,
      Borer.`borer-derivation`.value % Provided,
    )
  )
}
