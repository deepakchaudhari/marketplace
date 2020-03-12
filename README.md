# Marketplace REST API

This is the Spring Boot Marketplace application provides a REST API.
Its deployed in the cloud can access with below location

<a href="https://guarded-savannah-82457.herokuapp.com/marketplace/swagger-ui.html#/">https://guarded-savannah-82457.herokuapp.com/marketplace/swagger-ui.html#/</a>

## Running marketplace on local
```
	git clone https://github.com/deepakchaudhari/marketplace.git
	cd marketplace
	./mvnw spring-boot:run
	
```
## Swagger REST API documentation presented here (after application start):
<a href="http://localhost:9966/marketplace/swagger-ui.html">http://localhost:9966/marketplace/swagger-ui.html</a>

## Check application status
<a href="http://localhost:9966/marketplace/actuator/health">http://localhost:9966/marketplace/actuator/health</a>

## Working with MarketPlace in Eclipse

### prerequisites
The following items should be installed in your system:
* Java 8
* Maven 3 (http://www.sonatype.com/books/mvnref-book/reference/installation.html)
* git command line tool (https://help.github.com/articles/set-up-git)
* Eclipse with the m2e plugin (m2e is installed by default when using the STS (http://www.springsource.org/sts) distribution of Eclipse)

Note: when m2e is available, there is an m2 icon in Help -> About dialog.
If m2e is not there, just follow the install process here: http://eclipse.org/m2e/download/


### Steps:

1) In the command line
```
git clone https://github.com/deepakchaudhari/marketplace.git
```
2) Inside Eclipse
```
File -> Import -> Maven -> Existing Maven project
```
## Looking for something in particular?

| Layer | Source |
|--|--|
| Dependency | [pom.xml](pom.xml)|
| REST API controllers | [REST folder](src/main/java/com/intuit/teg/marketplace/web/rest) |
| Service | [ProjectServiceImpl.java](src/main/java/com/intuit/teg/marketplace/service/ProjectServiceImpl.java) |
| Tests | [UserRestControllerTests.java](src/test/java/com/intuit/teg/marketplace/marketplace/web/rest/UserRestControllerTests.java) |

## DB Configuration

Marketplace uses three separate profile configuration for DEV, TEST and PROD respectively.

application-dev.properties

application-test.properties

application-prod.properties


Please use spring.profiles.active property to set profile

## Testing

To launch your application's tests, run:

    ./mvnw clean test
