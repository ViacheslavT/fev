# Fev lab csv

Technical task to parse csv and generate reports

## NOTE
Please keep in mind, if you're going to check a big file, either use fields headers filter and count of records, or use another tool to get JSON data. As paggination is not implemented here there could be broser performance issues due to big amount of Charts.

## Build project

#### Maven project build requirements:

1. The maven version higher then 3.3.9
2. openJDK 8

#### Maven project build command:

Execute the following under root project dirrectory right on the level of **pom.xml**:
> $mvn clean install

or
> $mvn -U clean package verify

#### Run Spring boot applications:
   
Go to the roo of the project and execute:
> $mvn -U clean package verify

Go to the /target directory and execute one by one:
> $java -jar fev-lab-rest-{version}.jar
>
> $java -jar fev-lab-ui-{version}.war

The REST API will be started on http://localhost:8080

And the UI will be started on http://localhost:8081

#### To verify applications
Follow the link http://localhost:8080/swagger-ui.html to check the API documentation

Follow the link http://localhost:8081/home to open welcome page

#### Application profiles:

Application can be run in scope of three profiles:
- prod
- dev

Default profile used is **dev**.
To run application in scope of another profile use:
> $java -jar -Dspring.profiles.active=prod fev-lab-rest-{version}.jar
> $java -jar -Dspring.profiles.active=prod fev-lab-ui-{version}.war

To make specific profile active by default just build jar with defined profile id:
> $mvn clean install -P{profile_id}

or
> $mvn -U clean package verify -P{profile_id}

The **test** profile is used only in scope of test run.

#### Run applications:
Go to the roo of the project and execute:
> $mvn -U clean package verify

Go to the /target directory and execute one by one:
> $java -jar fev-lab-rest-{version}.jar
>
> $java -jar fev-lab-ui-{version}.war

The REST API will be started on http://localhost:8080
And the UI will be started on http://localhost:8081

### To verify applications
Follow the link http://localhost:8080/swagger-ui.html to check the API documentation
Follow the link http://localhost:8081/home to open welcome page

### Example:
Example of records filtered by three numeric fields from small csv file
![Example of records filtered by three numeric fields from small csv file](https://github.com/ViacheslavT/fev/blob/master/fev-lab-csv/example.png)
