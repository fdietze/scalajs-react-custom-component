enablePlugins(ScalaJSPlugin)

organization := "com.github.fdietze"
name := "scalajs-react-custom-component"
version := "0.1.0"

scalaVersion := "2.12.1"
crossScalaVersions := Seq("2.11.8", "2.12.1")

libraryDependencies ++= (
  "org.scala-js" %%% "scalajs-dom" % "0.9.1" ::
  "com.github.japgolly.scalajs-react" %%% "core" % "0.11.3" ::
  Nil
)

scalacOptions ++=
  "-unchecked" ::
  "-deprecation" ::
  "-feature" ::
  Nil

// publishing
pgpSecretRing in Global := file("secring.gpg")
pgpPublicRing in Global := file("pubring.gpg")
pgpPassphrase in Global := Some("".toCharArray)

organization in Global := "com.github.fdietze"

pomExtra in Global := {
  <url>https://github.com/fdietze/scalajs-react-custom-component</url>
  <licenses>
    <license>
      <name>Apache 2</name>
      <url>http://www.apache.org/licenses/LICENSE-2.0.txt</url>
    </license>
  </licenses>
  <scm>
    <url>https://github.com/fdietze/scalajs-react-custom-component</url>
    <connection>scm:git:git@github.com:fdietze/scalajs-react-custom-component.git</connection>
  </scm>
  <developers>
    <developer>
      <id>fdietze</id>
      <name>Felix Dietze</name>
      <url>https://github.com/fdietze</url>
    </developer>
  </developers>
}
