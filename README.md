# Configuration Microservice Project

Technologies:
- Java 8
- MariaDB
- Spring Boot
- Spring Boot JPA
- Spring Rest Controller
- Spring Test
- Spring Scheduling
- Maven

# Usage

Currently the unit tests are in progress so you need to build with:

`
mvn clean package -DskipTests=true
`

# DB

Create db table using the script in testConf folder

# Run

`java -jar ConfigurationService.jar --refresh=[cacheRefreshPeriodInMs] --spring.datasource.url="[datasourceUrl including user and password]" --applicationName=[applicationName]`


# GET Services

`
http://localhost:8080/confs

http://localhost:8080/conf/{confId}

http://localhost:8080/conf/{confKey}
`
