# kafka-producer


## Projekt futtatása:
A futtatáshoz szükségünk lesz egy már létező Kafka topicra is és egy consumer-re is, amely a producer által küldött üzeneteket kiolvassa

A `resources/application.properties` fájlban megadtuk a következő beállításokat:
```java
spring.kafka.producer.bootstrap-servers=localhost:9092
spring.kafka.producer.key-serializer=org.apache.kafka.common.serialization.LongSerializer
spring.kafka.producer.value-serializer=org.apache.kafka.common.serialization.StringSerializer
spring.kafka.admin.properties.bootstrap.servers=localhost:9092
server.port=8081
```

Ezután a következő módon futtathatjuk a projektet:

`DemoApplicaton.java` -> Run as - Spring Boot App

vagy

```
java -jar ./target/*.jar
```

A következő végpontra POST hívással lehet üzenetet küldeni, ami továbbításra kerül a topicba
[http://localhost:8081//send-message](http://localhost:8081//send-message)

Az üzenetet egy JSON objektum formájában kell megadni, aminek a következő mezőkkel kell rendelkeznie:
* `message`
* `from`
* `room`

Példa egy POST hívásra a `curl` segítségével:
```
curl --header "Content-Type: application/json" \
--request POST \
--data '{"message":"hello", "from":"prod1", "room":"room1"}' \
http://localhost:8081/send-message
```

Siker esetén a következő szöveg fogad az alkalmazás logjai között:
```
Success message SendResult [producerRecord=ProducerRecord(topic=chat-rooms, partition=null, headers=RecordHeaders(headers = [], isReadOnly = true), key=0, value={"message":"hello","from":"prod1","room":"room1"}, timestamp=null), recordMetadata=chat-rooms-0@0]
```

