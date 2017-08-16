```https://blog.redelastic.com/diving-into-akka-streams-2770b3aeabb0
https://stackoverflow.com/questions/35120082/how-to-get-started-with-akka-streams
https://gist.github.com/staltz/868e7e9bc2a7b8c1f754/
https://egghead.io/lessons/rxjs-understand-reactive-programming-using-rxjs
https://gist.github.com/sschaef
http://developer.lightbend.com/docs/alpakka/current/sse.html

cd /opt/confluent/confluent-3.3.0/
bin/confluent start schema-registry

bin/kafka-topics --create --zookeeper localhost:2181 --replication-factor 1 --partitions 1 --topic topic1
bin/kafka-topics --list --zookeeper localhost:2181
bin/kafka-console-producer --broker-list localhost:9092 --topic topic1
bin/kafka-console-consumer --bootstrap-server localhost:9092 --topic topic1 --from-beginning
```

