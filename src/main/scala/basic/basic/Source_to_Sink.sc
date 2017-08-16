import scala.concurrent._
import akka._
import akka.actor._
import akka.stream._
import akka.stream.scaladsl._
import akka.util._
implicit val system = ActorSystem("SourcetoSink")
implicit val materializer = ActorMaterializer()
import system.dispatcher

val source = Source(1 to 3)
val sink = Sink.foreach[Int](elem => println(s"sink received: $elem"))
val flow = source to sink
flow.run()
