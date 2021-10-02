# kafka-consumer

## Projekt futtatása:
A futtatáshoz szükségünk lesz egy már létező Kafka topicra is

A `resources/application.properties` fájlban megadtuk a következő beállításokat:
```
spring.kafka.consumer.bootstrap-servers=localhost:9092
spring.kafka.consumer.key-serializer=org.apache.kafka.common.serialization.LongSerializer
spring.kafka.consumer.value-serializer=org.apache.kafka.common.serialization.StringSerializer
spring.kafka.admin.properties.bootstrap.servers=localhost:9092
spring.kafka.consumer.group-id="consumer-group"
```

Ezután a következő módon futtathatjuk a projektet:

`DemoApplicaton.java` -> Run as - Spring Boot App

vagy

```
java -jar ./target/*.jar
```

Ezután a kafka-producer által küldött üzeneteket olvashatjuk az alkalmazás logjai között

Például sikeres olvasás esetén a következőt láthatjuk:
```
{"message":"hello","from":"prod1","room":"room1"}
```

