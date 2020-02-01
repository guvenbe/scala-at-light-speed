import com.sun.tools.javac.resources.version

name := "scala-at-light-speed"

version := "0.1"

scalaVersion := "2.13.1"

libraryDependencies ++= Seq(
  "com.typesafe.akka" %% "akka-actor" % "2.4.0"
)