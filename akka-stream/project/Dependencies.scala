import sbt._

object Dependencies {
  val akkaStreamVersion = "2.5.1"

  lazy val scalaTest = "org.scalatest" %% "scalatest" % "3.0.3"
  lazy val helloDeps = Seq(
    scalaTest % Test,
    "com.typesafe.akka" %% "akka-stream" % akkaStreamVersion
  )
}
