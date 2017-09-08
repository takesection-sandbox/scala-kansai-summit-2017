package example

import akka.actor.ActorSystem
import akka.stream.ActorMaterializer
import akka.stream.scaladsl._

import scala.concurrent.Await
import scala.concurrent.duration._

object Hello extends App {

  implicit val system = ActorSystem("Hello")
  implicit val materializer = ActorMaterializer()
  implicit val executionContext = system.dispatcher

  val flow = Source(1 to 5).via(Flow[Int].map(_ * 2)).runWith(Sink.seq[Int])

  val results = Await.result(flow, 5 seconds)
  results.foreach(println(_))
  sys.exit
}
