package basic.basic

import java.util.concurrent.atomic.AtomicLong

import akka.Done
import akka.actor.ActorSystem
import akka.kafka.scaladsl.Consumer
import akka.kafka.{ConsumerSettings, Subscriptions}
import akka.stream.ActorMaterializer
import akka.stream.scaladsl.Sink
import org.apache.kafka.clients.consumer.{ConsumerConfig, ConsumerRecord}
import org.apache.kafka.common.TopicPartition
import org.apache.kafka.common.serialization.{ByteArrayDeserializer, StringDeserializer}

import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.Future

object AkkaStream4  extends App{

  implicit val system = ActorSystem("AkkaStream4")
  implicit val materializer = ActorMaterializer()

  //TODO: move to configuration application.conf
  val consumerSettings = ConsumerSettings(system, new ByteArrayDeserializer, new StringDeserializer)
    .withBootstrapServers("172.28.128.9:9092")
    .withGroupId("group1")
    .withProperty(ConsumerConfig.AUTO_OFFSET_RESET_CONFIG, "earliest")

  val db = new DB
  db.loadOffset().foreach { fromOffset =>
    val partition = 0
    val subscription = Subscriptions.assignmentWithOffset(
      new TopicPartition("topic1", partition) -> fromOffset
    )
    val done =
      Consumer.plainSource(consumerSettings, subscription)
        .mapAsync(1)(db.save)
        .runWith(Sink.ignore)
  }




}


//class DB {
//
//  private val offset = new AtomicLong
//
//  def save(record: ConsumerRecord[Array[Byte], String]): Future[Done] = {
//    println(s"DB.save: ${record.value}")
//    offset.set(record.offset)
//    Future.successful(Done)
//  }
//
//  def loadOffset(): Future[Long] =
//    Future.successful(offset.get)
//
//  def update(data: String): Future[Done] = {
//    println(s"DB.update: $data")
//    Future.successful(Done)
//  }
//}

class Rocket {
  def launch(destination: String): Future[Done] = {
    println(s"Rocket launched to $destination")
    Future.successful(Done)
  }
}