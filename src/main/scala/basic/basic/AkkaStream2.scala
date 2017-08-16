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
object AkkaStream2  extends App{

  implicit val system = ActorSystem("SourcetoSink")
  implicit val materializer = ActorMaterializer()
  import system.dispatcher

  val source = Source(1 to 3)
  val sink = Sink.foreach[Int](println)
  val invertFlow = Flow[Int].map(elem => elem * -1)
  val doublerFlow = Flow[Int].map(elem => elem * 2)
  val runnableGraph = source via invertFlow via doublerFlow to sink

  runnableGraph.run()

}
