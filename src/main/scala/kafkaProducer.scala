import java.util.Properties
import org.apache.kafka.clients.producer._

object kafkaProducer {
  def main(args: Array[String]) {
    // Define Host Name and Topic Name
    val Array(brokers, topic) = Array("localhost:9092", "test")

    println("setting necessary properties...")
    // Setting necessary properties
    val props = new Properties()
    props.put("bootstrap.servers", brokers)
    props.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer")
    props.put("value.serializer", "org.apache.kafka.common.serialization.StringSerializer")

    println("creating a kafka Producer")
    val producer = new KafkaProducer[String, String](props)

    println("sending data...")
    for (i <- 1 to 50) {
      val record = new ProducerRecord(topic, "key", s"hello $i " + new java.util.Date)
      producer.send(record)
    }

    println("shutting down kafka Producer...\nend of program...")
    producer.close()
  }
}