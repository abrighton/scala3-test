import Common._
import sbtcrossproject.CrossPlugin.autoImport.{CrossType, crossProject}

inThisBuild(
  CommonSettings
)

lazy val root = (project in file("."))
  .settings(
    name := "scala3-test",
    libraryDependencies ++= Dependencies.ScalaTestDeps.value
  )
