# Eureka microservices demo project

## Projekt futtatása:
A microservices_demo `pom.xml` fájlja modulok formájában tartalmazza az alprojekteket. Ez egy külső maven összefoglaló több maven artifact-hoz. Így egy lépésben tudjuk beszerezni az ebben definiált modulok függőségeit, egy lépésben tudjuk buildelni és tesztelni őket.

A projekt az alábbi modulokból épül fel:
* `eureka-server`
* `order-service`
* `storage-service`
* `gateway-service`

1. microservices_demo `pom.xml` -> Maven build
(ha az STS nem ismerné el a modulokat Spring Boot projekteknek, akkor Maven -> Update Project -> Ok)

2. futtassuk az `eureka-server` projektet Spring Boot alkalmazásént
Böngészőből a [http://localhost:8761/](http://localhost:8761/) címre csatlakozva elérhetjük a szerver manager felületét.

Az `@EnableEurekaServer` annotációval jelöltük, hogy ez az alkalmazás egy Eureka Service registry lesz.

Az `application.properties` fájlban a következő beállításokat adtuk meg:

```java
server.port=8761
eureka.client.fetch-registry=false
eureka.client.register-with-eureka=false
```

Valós helyzetben több példánya is lehet a registry-nek, de a példában csak egyet használtunk.
Az utolsó sor megakadályozza, hogy saját magát beregisztrálja.

3. futtassuk az `order-service` és a `storage-service` modulokat külön terminálokban Spring Boot alkalmazásként

Mindkét alkalmazás Spring Cloud DiscoveryClient, amelyek beregisztrálják magukat a registry-be.


4. végül futtassuk a `gateway-service` modult egy külön terminálban Spring Boot alkalmazásként
A Gateway szolgáltatás közvetíti a kéréseket a microservice-ek felé, továbbítja a válaszokat és felel a load balance-olásért is.

Ha minden service felépült és beregisztrálta magát az Eureka registry-be, akkor a [http://localhost:8080/order](http://localhost:8080/order) címet meglátogatva a következő szöveget kapjuk válaszként:

```
Order confirmed! Remaining products: 99
```

A címet látogatva a számláló mindig eggyel csökkenni fog.

