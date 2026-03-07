The pom.xml and Dockerfile were updated to support Lab 3 Part 1.
These changes allow the Binary Calculator application to be packaged as a Docker image and deployed on Kubernetes.
SOFE 3290 – Lab 2
Binary Calculator Web Application and API Service

This project implements a binary calculator using Spring Boot and Maven.

The project includes:
- A web application (MVC controller)
- REST API services
- Unit tests using JUnit and MockMvc
- Binary operations: +, *, &, and |

To run the application:
mvn clean install
mvn spring-boot:run

Open in the browser:
http://localhost:8080

To run the tests:
mvn test
