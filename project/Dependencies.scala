import sbt.*

object Dependencies {

  val ScalaTestDeps = Def.setting(
    Seq(
      Pekko.`pekko-actor` % Provided,
      Pekko.`pekko-stream` % Provided,
      Pekko.`pekko-actor-typed` % Provided,
      PekkoHttp.`pekko-http` % Provided,
      Borer.`borer-compat-pekko` % Provided,
      Borer.`borer-derivation`.value % Provided,
    )
  )
}
