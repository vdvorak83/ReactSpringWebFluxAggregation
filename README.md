# ReactSpringWebFluxAggregation
# Read Me First

The following was discovered as part of building this project:

* The JVM level was changed from '11' to '17', review
  the [JDK Version Range](https://github.com/spring-projects/spring-framework/wiki/Spring-Framework-Versions#jdk-version-range)
  on the wiki for more details.

# Getting Started

### Reference Documentation

For further reference, please consider the following sections:

* [Official Apache Maven documentation](https://maven.apache.org/guides/index.html)
* [Spring Boot Maven Plugin Reference Guide](https://docs.spring.io/spring-boot/docs/3.0.4/maven-plugin/reference/html/)
* [Create an OCI image](https://docs.spring.io/spring-boot/docs/3.0.4/maven-plugin/reference/html/#build-image)
* [Spring Data Reactive MongoDB](https://docs.spring.io/spring-boot/docs/3.0.4/reference/htmlsingle/#data.nosql.mongodb)
* [Spring Reactive Web](https://docs.spring.io/spring-boot/docs/3.0.4/reference/htmlsingle/#web.reactive)
* [Spring Boot DevTools](https://docs.spring.io/spring-boot/docs/3.0.4/reference/htmlsingle/#using.devtools)

### Guides

The following guides illustrate how to use some features concretely:

* [Accessing Data with MongoDB](https://spring.io/guides/gs/accessing-data-mongodb/)
* [Building a Reactive RESTful Web Service](https://spring.io/guides/gs/reactive-rest-service/)

Projects

Spring WebFlux Aggregation:
In a Microservice architecture, we will have N number of services and each service has its own responsibilities & databases. Data would have been distributed among them. For ex:

user-service: It is responsible for all the user management.
order-service: It is responsible for managing customer’s orders.

Advantages:
Reduced network calls & latency
Aggregator acts like a facade & hides the backend complexity.

DB
We can use the below docker-compose yaml to expose REST APIs to access above information.
/*
------------------------
version: '3'
services:
server:
image: clue/json-server
ports:
- "3000:80"
  volumes:
- ${PWD}/db.json:/data/db.json
---------------------------------- 
*/
For example, sending below requests to show the corresponding data.
# shows the product 1 information
http://localhost:3000/products/1

# shows the promotion details for product id = 1
http://localhost:3000/promotions/1

# to get all the reviews for product id = 1
http://localhost:3000/reviews?productId=1

