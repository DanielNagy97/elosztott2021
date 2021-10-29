# Redis példa

## Projekt futtatása

1. Futtassuk a Redis szervert egy docker konténerben a következő paranccsal

```
docker run -p 16379:6379 -d redis:6.0 redis-server --requirepass "mypass"
```

2. Maven build -> clean package

3. RedisExampleApplication.java -> Run as - Spring Boot App

vagy

```
java -jar ./target/*.jar
```

4. Alkalmazás használata

`POST` kérésre új személyt tudunk felvenni.
```
curl -X 'POST' 'http://localhost:8080/person' -H 'Content-Type: application/json' -d '{"id": "01", "firstname": "John", "lastname": "Doe"}'
```

`GET` kérésre a felvitt személyeket tudjuk lekérdezni.
A 01-es indexű bejegyzést a következő módon kérhetjük le:
```
curl -X 'GET' 'http://localhost:8080/person/01'
```

Válaszként visszakapjuk a bejegyzést JSON dokumentumként:
```json
{
    "id": "01",
    "firstname": "John",
    "lastname": "Doe"
}
```
