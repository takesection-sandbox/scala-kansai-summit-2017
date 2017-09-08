package example

import akka.actor.ActorSystem
import akka.http.scaladsl.Http
import akka.stream.ActorMaterializer
import akka.http.scaladsl.server.Directives._

import scala.concurrent.duration._

class Hello {

  def createActorSystem = ActorSystem("hello")

  def route =
    pathEndOrSingleSlash {
      complete("Hello World")
    } ~ path(IntNumber) { id ⇒
      complete(s"$id")
    }
}

object Hello extends Hello with App {

  implicit val system = createActorSystem
  implicit val materializer = ActorMaterializer()
  implicit val executionContext = system.dispatcher
  implicit val timeout = 5 seconds

  val serverBinding = Http().bindAndHandle(handler = route,
    interface = "0.0.0.0",
    port = 8080
  )

  Runtime.getRuntime.addShutdownHook(new Thread {
    override def run() {
      serverBinding.flatMap(_.unbind()).onComplete(_ => system.terminate())
    }
  })

}