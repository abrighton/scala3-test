import sbt.*
import sbt.Keys.*

object Common {
  private val enableFatalWarnings: Boolean = sys.props.get("enableFatalWarnings").contains("true")
  private val enableCoverage: Boolean      = sys.props.get("enableCoverage").contains("true")

  lazy val CommonSettings: Seq[Setting[_]] = Seq(
    
    organization                                    := "com.github.abrighton.scala3-test",
    organizationName                                := "test",
    scalaVersion                                    := Libs.ScalaVersion,
    homepage                                        := Some(url("https://github.com/tmtsoftware/csw")),
    resolvers += "Apache Pekko Staging".at("https://repository.apache.org/content/groups/staging"),
    resolvers += "Apache Pekko Snapshots".at("https://repository.apache.org/content/groups/snapshots"),
    resolvers += "jitpack" at "https://jitpack.io",
    scmInfo := Some(
      ScmInfo(url("https://github.com/tmtsoftware/csw"), "git@github.com:tmtsoftware/csw.git")
    ),
    licenses := Seq(("Apache-2.0", url("http://www.apache.org/licenses/LICENSE-2.0"))),
    scalacOptions ++= Seq(
      "-encoding",
      "UTF-8",
      "-feature",
      "-unchecked",
      "-deprecation",
    ),
    javacOptions ++= Seq(
      "-Xlint:unchecked"
    ),
    javaOptions += "-Xmx2G",
    Compile / doc / javacOptions ++= Seq("-Xdoclint:none"),
    doc / javacOptions ++= Seq("--ignore-source-errors"),
    Test / packageBin / publishArtifact := true,
    // jitpack provides the env variable VERSION=<version being built> # A tag or commit. We have aliased VERSION to JITPACK_VERSION
    // we make use of it so that the version in class metadata (e.g. classOf[LocationService].getPackage.getSpecificationVersion)
    // and the maven repo match
    version := sys.env.getOrElse("JITPACK_VERSION", "0.1.0-SNAPSHOT"),
    fork    := true,
    Test / javaOptions ++= Seq("-Dpekko.actor.serialize-messages=on", s"-DRTM_PATH=${file("./target/RTM").getAbsolutePath}"),
    autoCompilerPlugins     := true,
    Global / cancelable     := true, // allow ongoing test(or any task) to cancel with ctrl + c and still remain inside sbt
    Global / excludeLintKeys := Set(
      SettingKey[Boolean]("ide-skip-project"),
      aggregate // verify if this needs to be here or our configuration is wrong
    )
  )
}
