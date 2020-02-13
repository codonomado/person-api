# EMBL-EBI Rest API Project

## Objective

- To develop a REST API
- To develop an authentication service



## Dependencies

- Apache Maven v4.0.0 or higher is required
- Java 1.8



The following dependencies have been listed in the pom.xml file and can be installed with men

- Spring Boot v2.2.4
- Spring Boot Starter Web
- Spring Boot Starter Data JPA
- Spring Boot Starter Security

- H2 In-memory database
- Swagger  (API)
- JJWT (JSON Web Token)
- Jackson JSON Serializer



## Running the application

You could either run it using an IDE such as Intellij, or from the command line using the following commands:

```
mvn clean install -DskipTests
mvn spring-boot:run
```



* Access to the in-memory database is available on the following url: http://localhost:8080/console. The credentials for the database are available in the application.properties file in `src/main/resources`.
* Access to the endpoints is available on the following url: http://localhost:8080/swagger-ui.html#/

* Note, in order to execute requests for the endpoints, it might make more sense to use a REST API client such as Postman, where requests will return a Bearer Token.

  
