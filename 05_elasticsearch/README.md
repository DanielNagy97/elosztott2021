
1. Húzzuk le az elastic-search image-et

```
docker pull docker.elastic.co/elasticsearch/elasticsearch:7.15.1
```

2. Futtassuk a konténert a következő parancs segítségével

```
docker run -p 9200:9200 -p 9300:9300 -e "discovery.type=single-node" docker.elastic.co/elasticsearch/elasticsearch:7.15.1
```

A [http://localhost:9200/](http://localhost:9200/) címre egy `GET` kérést küldve leellenőrizhetjük, hogy a szerver működik-e.
Válaszként egy ehhez hasonló JSON-nt kapunk:
```json
{
  "name" : "2451b2b08aa6",
  "cluster_name" : "docker-cluster",
  "cluster_uuid" : "Mcxx8UeiSsaYjLUp-ZGipQ",
  "version" : {
    "number" : "7.15.1",
    "build_flavor" : "default",
    "build_type" : "docker",
    "build_hash" : "83c34f456ae29d60e94d886e455e6a3409bba9ed",
    "build_date" : "2021-10-07T21:56:19.031608185Z",
    "build_snapshot" : false,
    "lucene_version" : "8.9.0",
    "minimum_wire_compatibility_version" : "6.8.0",
    "minimum_index_compatibility_version" : "6.0.0-beta1"
  },
  "tagline" : "You Know, for Search"
}

```

3. Buildeljük a projektünket

Maven build: `clean package`

4. Futtassuk a 

`DemoApplicaton.java` -> Run as - Spring Boot App

vagy

```
java -jar ./target/*.jar
```

A [http://localhost:8080/swagger-ui.html](http://localhost:8080/swagger-ui.html) címen érhetjük el a swagger klienst

- `POST` kéréssel a `/chat` végpontra tudunk küldeni a chat alkalmazásunkba üzenetet

Példa egy üzenetre:
```json
{
  "id": "01",
  "message": "Hello World",
  "sender": "me",
  "roomId": "001",
  "roomName": "room1"
}
```

- `GET` kérést pedig egy hiba miatt csak külső eszközzel tudunk küldeni

Keresés `sender` alapján a `/chat` végponton:
```
curl -X 'GET' 'http://localhost:8080/chat' -H 'Content-Type: application/json' -d '{"query": "me"}'

```

Keresés `message` alapján a `/chat/bymessage` végponton:
```
curl -X 'GET' 'http://localhost:8080/chat/bymessage' -H 'Content-Type: application/json' -d '{"query": "Hello World"}'
```

