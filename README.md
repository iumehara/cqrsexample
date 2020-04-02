# CQRS Example

![diagram.png](/diagram.png?raw=true)

## Dependencies
- Java
- Postgres
- RabbitMQ
- MongoDB

## Set Up
Write database (Postgres)
```shell script
# start postgres on default port, then:
createdb cqrsexample
psql cqrsexample -f server/productscommand/src/main/resources/sql/schema.sql
```

Read database (MongoDB)
```shell script
# start mongodb on default port, then in the mongo console:
use cqrsexample
db.createCollection("products")
```

Message Queue (RabbitMQ)
```shell script
# start rabbitmq on default port
```

Command Microservice (Spring Boot)
```shell script
cd server/productscommand
./gradlew build
```

Query Microservice (Spring Boot)
```shell script
cd server/productsquery
./gradlew build
```

## Tests
Command Microservice
```shell script
cd server/productscommand
./gradlew test
```

Query Microservice
```shell script
cd server/productsquery
./gradlew test
```

## Run

Command Microservice (localhost:8080)
```shell script
cd server/productscommand
./gradlew bootrun
```

#### Start the request service
Query Microservice (localhost:8081)
```shell script
cd server/productsquery
./gradlew bootrun
```

## Note
This is proof of concept, and not production ready. 
Remaining issues to address include:
- No exception handling, so dropped messages result in out-of-syn view database
- No event store, so reproducing view database from zero is difficult 
