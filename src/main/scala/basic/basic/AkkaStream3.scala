package basic.basic
import scala.concurrent._
import scala.concurrent.duration.DurationInt
import akka._
import akka.actor._
import akka.stream._
import akka.stream.scaladsl._
import akka.util._
/**
  * Created by dmilan on 8/15/17.
  */
object AkkaStream3  extends App{

  implicit val system = ActorSystem("SourcetoSink")
  implicit val materializer = ActorMaterializer()
  import system.dispatcher

  val invertFlow = Flow[Int].map(elem => elem * -1)
  val doublerFlow = Flow[Int].map(elem => elem * 2)
  val sink = Sink.foreach[Int](println)

  val source1 = Source
    .repeat(100)
    .take(50)
      //.async
      .zip(Source.fromIterator(()=> Iterator.from(1)))
       .map{
         case(n1,i1)=> n1*i1
       }
    .via(doublerFlow)
      .throttle(10,1.second, 10, ThrottleMode.shaping)
    .toMat(sink)(Keep.right)

  source1
    .run()
      .onComplete(_=>system.terminate())

}
