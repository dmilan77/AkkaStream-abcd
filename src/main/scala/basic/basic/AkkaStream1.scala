package basic.basic
import scala.concurrent._
import akka._
import akka.actor._
import akka.stream._
import akka.stream.scaladsl._
import akka.util._


/**
  * Created by dmilan on 8/15/17.
  */
object AkkaStream1 extends App{
  implicit val system = ActorSystem("SourcetoSink")
  implicit val materializer = ActorMaterializer()
  import system.dispatcher

  val source = Source(1 to 300)
  val sink = Sink.foreach[Int](elem => println(s"sink received: $elem"))
  val flow = source to sink
  flow.run()

}
