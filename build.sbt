enablePlugins(ScalaJSPlugin)

organization := "com.github.fdietze"
name := "scalajs-react-custom-component"
version := "0.1.0-SNAPSHOT"

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
