# Fev lab csv

Technical task to parse csv and generate reports

## Build project

#### Maven project build requrement:

1. The maven version upper then 3.3.9
2. openJDK 8

#### Maven project build command:

Execute the following under root project dirrectory right on the level of **pom.xml**:
> $mvn clean install

or
> $mvn -U clean package verify

#### Run Spring boot application:

Can be run in two ways:
1. > $mvn clean install spring-boot:run
2. > $java -jar fev-lab-rest-{version}.jar
3. > $java -jar fev-lab-ui-{version}.jar

For the local environment the application will be available via 8080 - rest and 8081 - ui ports:
> http://localhost:8080/
> http://localhost:8081/

The swagger documentation can be found at

http://localhost:8080/swagger-ui.html

#### Application profiles:

Application can be run in scope of three profiles:
- prod
- dev

Default profile used is **dev**.
To run application in scope of another profile use:
> $java -jar -Dspring.profiles.active=prod ev-lab-rest-{version}.jar
> $java -jar -Dspring.profiles.active=prod ev-lab-ui-{version}.jar

To make specific profile active by default just build jar with defined profile id:
> $mvn clean install -P{profile_id}

or
> $mvn -U clean package verify -P{profile_id}

The **test** profile is used only in scope of test run.
