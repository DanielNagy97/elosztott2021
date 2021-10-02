# Spring alkalmazás, ami másik REST apit szólit meg

A demo projekt kiegészítése

## Projekt futtatása:

Hasonlóan kell futtatni mint a demo projektet

DemoApplicaton.java -> Run as - Spring Boot App

vagy

```
java -jar ./target/*.jar
```

A MainControllerben egy új elérési útvonalat is felvettünk: `/repoSearch`

[http://localhost:8080/repoSearch?queryString=%22cat%22](http://localhost:8080/repoSearch?queryString=%22cat%22)

A Github API-t hívja meg, ami a választ JSON állományban küldi vissza. A választ feldolgozza és egy tömböt köld vissza a talált repo-k neveivel (JSON állományban).

```
["cat","Catch2","bat","nyaa","http.cat","ccat","wscat","Cataclysm-DDA","catuserbot","Deep-learning-with-cats","cats","catboost","cat","bongocat-osu","catarse","bongo.cat","catalyst","ud989-cat-clicker-premium-vanilla","catapult","CatchUp","Koolshare-Clash","CAT","catalyst","Android-IMSI-Catcher-Detector","cat","IMSI-catcher","CatLoadingView","mdcat","CatKit","Catroid"]
```

## Tesztek futtatása:
Maven test vagy Run as -> JUnit Test

## Docker image létrehozása a projekthez:

> image: recept

> konténer: processz, de az állapotait le lehet menteni

**Dockerfile elkészítése**

A Dockerfile tartalma a következő:

```Dockerfile
FROM openjdk:11
VOLUME /tmp
ARG JAR_FILE
COPY ${JAR_FILE} app.jar
ENTRYPOINT ["java","-jar","/app.jar"]
```
A Dockerfileban meg kell adnunk a JDK verzióját is.
A *fat* jar-t argumentumként várja (hogy rugalmasabb legyen a névváltásra)

A *fat* jar a `target/*.jar` alatt található

### buildelés
```
docker build --build-arg JAR_FILE=target/*.jar -t myorg/myapp .
```

### konténer futtatása
```
docker run -d -p 8080:8080 myorg/myapp
```

egy id-t ad vissza

### Alkalmazás logjainak megtekintése
```
docker logs id
```

### processzek megtekintése
```
docker top id
```

### futó konténerek kilistázása
```
docker ps
```

### parancsok kiadása a futó konténerben
```
docker exec -it id bash
```

az -it kapcsolóval interaktív módban léphetünk be

### konténer vizsgálata
```
docker inspect id
```

## SOLID ELVEK

### Single Responsibility Principle
1 metódus csak 1 dolgot csináljon!

### Open/Closed Principle
Úgy írjuk meg az osztályt, hogy azt bárki ki tudja terjeszteni (nyílt a kiterjesztésre)
és sose kelljen az eredetit módosítani (zárt a módosításra)

### Liskov substitution principle
Ésszel legyen nyitott a specializációra, jól legyenek felüldefiniálva, legyen cserekompatibilis

feltételezés (paraméterek) és utóhatás (kimenet)

> Nem lehet tágabb a kimenet!

> A bemenet viszont csak tágabb lehet!

### Interface segregation principle
Ahol lehet használjunk Interfészt!
(Az a legkissebb függés)

### Dependency inversion principle
Csak az alatta lévőtől függjön egy réteg (vagy önmagától)

