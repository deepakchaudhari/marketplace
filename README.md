# Marketplace REST API

This backend version of the Spring Marketplace application provides a REST API.

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

## Configuration

In its default configuration, MarketPlace uses an in-memory database (H2) which
gets populated at startup with data.

spring.h2.console.enabled=true

spring.datasource.platform=h2

spring.datasource.url=jdbc:h2:mem:marketplace

spring.datasource.driverClassName=org.h2.Driver

spring.datasource.username=sa

spring.datasource.password=

logging.level.org.springframework=INFO

server.port=9966

server.servlet.contextPath=/marketplace

