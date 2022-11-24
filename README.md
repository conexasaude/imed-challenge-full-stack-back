# Imed Challenge - Multi Module Application

<p> 1 - Application - Module to run the applications, can be more than one (ex: Spring, Quarkus). 
<p> 2 - Domain - Module core that contains all business rules of our application (UseCases). 
<p> 3 - Persistence - Module to persist our data information (ex: DB, JOB). 
<p> 4 - Client - Module to expose our application, contains the application rules (ex: Rest, IOT). 
<p> 5 - Security - Module to security our application (ex: Oauth2, JWT).

## Getting Started

### Package project

- mvn package

### Run project

- java -jar application/target/application-0.0.1-SNAPSHOT.jar

### Health check

* [http://localhost:8090/api/v1/actuator/health](http://localhost:8090/api/v1/actuator/health)

### H2 Console

* [http://localhost:8090/api/v1/h2-console](http://localhost:8090/api/v1/h2-console)
* username: admin
* password: admin

### Generate token

* curl -X POST -u imed-challenge:
  imed-challenge 'http://localhost:8090/api/v1/oauth/token?grant_type=password&&username=professional1&password=admin'

### Reference Documentation

For further reference, please consider the following sections:

* [Official Apache Maven documentation](https://maven.apache.org/guides/index.html)
* [Spring Boot Maven Plugin Reference Guide](https://docs.spring.io/spring-boot/docs/2.7.5/maven-plugin/reference/html/)
* [Create an OCI image](https://docs.spring.io/spring-boot/docs/2.7.5/maven-plugin/reference/html/#build-image)