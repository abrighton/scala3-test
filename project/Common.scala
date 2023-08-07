import sbt.*
import sbt.Keys.*

object Common {
  private val enableFatalWarnings: Boolean = sys.props.get("enableFatalWarnings").contains("true")
  private val enableCoverage: Boolean      = sys.props.get("enableCoverage").contains("true")

  lazy val CommonSettings: Seq[Setting[_]] = Seq(
    
    organization                                    := "com.github.abrighton.scala3-test",
    organizationName                                := "test",
    scalaVersion                                    := Libs.ScalaVersion,
    scalacOptions ++= Seq(
      "-encoding",
      "UTF-8",
      "-feature",
      "-unchecked",
      "-deprecation",
    ),
    fork    := true,
    autoCompilerPlugins     := true,
    Global / cancelable     := true, // allow ongoing test(or any task) to cancel with ctrl + c and still remain inside sbt
  )
}
