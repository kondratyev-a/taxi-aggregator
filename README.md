# Taxi aggregator aggregation service
The service should provide REST API to aggregate different taxi aggregators.
There are no real taxi aggregator connectors used.

## Application features
- Users registration and further authentication using tokens
- Getting prices in asynchronous mode
- Creating and deleting a trip

## Running the application locally
Requirements
- Java 11
- Maven

To build and run the application use:
```console
git clone https://github.com/kondratyev-a/taxi-aggregator.git  
cd spring5-recipe-app
./mvnw spring-boot:build-image
run -p 8080:8080 taxi-aggregator:0.0.1-SNAPSHOT
```

Or you can run it from Maven directly using the Spring Boot Maven plugin. If you do this it will pick up changes that you make in the project immediately:
```console
./mvnw spring-boot:run
```

And one more option is to create a Docker image. You'll need a Docker installed on your computer.
```console
./mvnw spring-boot:build-image
run -p 8080:8080 taxi-aggregator:0.0.1-SNAPSHOT
```

You can then access the application here: http://localhost:8080/

## Used technologies
- **Java 11** as the main programming language
- **Spring Boot** to simplify initial setup
- **Spring Security** to authenticate using JWT tokens
- **Spring Web** to implement REST API using @RestController annotations
- **Spring Data JPA** to easily implement JPA based repositories
- **Hibernate** to map Java POJO's to database tables
- **H2 Database** to store data in-memory
- **DTO and converters** to convert data for the presentation layer
- **Maven** to manage dependencies for builds
- **JUnit 5** and **Mockito** for unit and integration tests

## Documentation
- Postman collection to test api [here](https://www.postman.com/collections/ec433eab5e15081877db)  
- Postman documentation for api [here](https://documenter.getpostman.com/view/9816918/Tzz8rcnY)