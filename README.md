# Taxi aggregator aggregation service
The service should provide REST API to aggregate different taxi aggregators.
There are no real taxi aggregator connectors used.
The service is designed to demonstrate architecture and REST API.

## Service features
- Users registration and further authentication using tokens
- Getting prices in asynchronous mode
- Creating and deleting a trip

## Used technologies
- **Java 11** as the main programming language
- **Spring Boot** to set up initial dependencies and to use different profiles
- **Spring Security** to authenticate using JWT tokens
- **Spring Web** to implement REST API using @RestController annotations
- **Spring Data JPA** to easily implement JPA based repositories
- **Hibernate** to map Java POJO's to database tables
- **H2 Database** to store data in-memory.  In the real task, the database should be another
- **DTO and converters** to convert data for the presentation layer
- **Maven** to manage dependencies for builds
- **JUnit 5** and **Mockito** for unit and integration tests

## Notes
- Hateoas wasn't used in the rest API
- Retrieving and updating trip information were declared but not implemented

## Documentation
- Postman collection to test api [here](https://www.postman.com/collections/ec433eab5e15081877db)  
- Postman documentation for api [here](https://documenter.getpostman.com/view/9816918/Tzz8rcnY)