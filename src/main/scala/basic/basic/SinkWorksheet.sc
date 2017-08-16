import scala.concurrent._
import akka._
import akka.actor._
import akka.stream._
import akka.stream.scaladsl._
import akka.util._
implicit val system = ActorSystem("SinkSystemSheet")
implicit val materializer = ActorMaterializer()
import system.dispatcher

val s1 = Source.empty
val s2 = Source.single("single element")
val s3 = Source(1 to 3)
val s4 = Source.repeat(5)
s4 take 3 runForeach println
//s4 runForeach println


//def run(actor: ActorRef) = {
//  Future { Thread.sleep(300); actor ! 1 }
//  Future { Thread.sleep(200); actor ! 2 }
//  Future { Thread.sleep(100); actor ! 3 }
//}
//val s5 = Source
//  .actorRef[Int](bufferSize = 0, OverflowStrategy.fail)
//  .mapMaterializedValue(run)
//
//s5 runForeach println