import sbt.*

object Dependencies {

  val ScalaTestDeps = Def.setting(
    Seq(
      Akka.`akka-actor` % Provided,
      Akka.`akka-actor-typed` % Provided,
      AkkaHttp.`akka-http` % Provided,
      Borer.`borer-compat-akka` % Provided,
      Borer.`borer-derivation`.value % Provided,
    )
  )
}
