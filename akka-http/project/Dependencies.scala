import sbt._

object Dependencies {
  lazy val scalaTest = "org.scalatest" %% "scalatest" % "3.0.3"

  // Akka-HTTP
  lazy val akkaHttpVersion = "10.0.5"
  lazy val akkaHttp = "com.typesafe.akka" %% "akka-http" % akkaHttpVersion
  lazy val helloDeps = Seq(
    akkaHttp,
    scalaTest % Test
  )
}
