# Kezdő Spring alkalmazás


## Projekt létrehozása SpringToolSuite-ban:
1. File -> New Spring Starter Project
2. Type: Maven Project
    * Packaging:Jar
    * Java Version:11
    * Dependencies:
        * Spring Boot DevTools
        * Lombok
        * Spring Web

3. Maven build

./target jegyzéken belül létrejön egy *fat* jar (ezt nem lehet függőségként használni)
(Ha a pom.xml-ből kiszednénk a plugin definícióját, akkor már nem *fat* lesz.)


resources/application.properties
```
debug=true
```
esetén mindent kiír

## Projekt futtatása:
DemoApplicaton.java -> Run as - Spring Boot App

```
java -jar ./target/*.jar
```

Ezután a böngészőből a következő útvonalakat érhetjük el:

* [http://localhost:8080/](http://localhost:8080/)
Megjelenik a Hello World!


* [http://localhost:8080/calculator?operandus1=2&operandus2=4&operator=+](http://localhost:8080/calculator?operandus1=2&operandus2=4&operator=+)
Válaszként egy JSON objektumot kapunk, a kiszámított értékkel
```
6.0
```

## Használt annotációk:
### @SpringBootApplication
Ez alatti osztály alatt az összes csomagban a számára értékes komponenseket kikeresi

### @RequestMapping
A http metódust mappeli le

### @RestController
Minden metódusára rárakja a @ResponseBody-t

### @Valid
Hibernate validáció

