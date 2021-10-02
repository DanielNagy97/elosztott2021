# 2 spring alkalmazás, ami egymással Kafka topic-on keresztül beszélget

Kafka szerepe:
> Aszinkron kommunikáció biztosítása a rendszerrészek között Message queue-val

## Előfeltétel a kafka-consumer és kafka-producer futtatásához:
1. Hivatalos [kafka-docker](https://github.com/wurstmeister/kafka-docker) repository clone-ozása.

2. `docker-compose-single-broker.yml` módosítása a példához!

(egy broker esetén lesz megfelelő csak a localhost használata)

```
KAFKA_ADVERTISED_HOST_NAME: localhost
```

3. Kafka konténerek elindítása
```
docker-compose -f docker-compose-single-broker.yml up
```

## Kafka topic példa

Egy másik terminált indítva a `docker ps` paranccsal kikereshetjük a kafka konténer id-jét

Lépjünk be a konténer shelljébe
```
docker exec -it id bash
```
```
cd opt/kafka/bin
```

Nyitott topic-ok kilistázása
```
kafka-topics.sh --bootstrap-server :9092 --list
```

Egy consumer-t és egy producer-t állítsunk rá a `test` topicra (két külön terminálból a konténer shelljében az `opt/kafka/bin` mappából):

```
kafka-console-consumer.sh --bootstrap-server :9092 --topic test

kafka-console-producer.sh --bootstrap-server :9092 --topic test
```

A producer oldalon a `>` után lehet írni a queue-ba, a consumer pedig kiolvassa az üzeneteket.

