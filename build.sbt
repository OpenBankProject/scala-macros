name := "scala-macros"
organization := "com.tesobe"
version := "1.0.0"

val scala212Version = "2.12.21"
val scala213Version = "2.13.18"

ThisBuild / scalaVersion       := scala212Version
ThisBuild / crossScalaVersions := Seq(scala212Version, scala213Version)

lazy val macros = (project in file("macros")).settings(
 libraryDependencies += "org.scala-lang" % "scala-reflect" % scalaVersion.value
)

lazy val core = (project in file("core")).dependsOn(macros)
