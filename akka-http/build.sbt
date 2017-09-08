import Dependencies._

lazy val root = (project in file(".")).
  enablePlugins(JavaAppPackaging, AshScriptPlugin, DockerPlugin).
  settings(
    inThisBuild(List(
      organization := "com.github.takesection",
      scalaVersion := "2.12.3",
      version      := "0.1.0-SNAPSHOT"
    )),
    name := "Akka HTTP",
    dockerBaseImage := "java:8-jdk-alpine",
    dockerExposedPorts := Seq(8080),
    libraryDependencies ++= helloDeps
  )
