FROM openjdk:17-jdk-slim

WORKDIR /app

COPY mvnw .
COPY .mvn/ .mvn
COPY pom.xml .

RUN ./mvnw dependency:go-offline

COPY src /app/src

RUN ./mvnw package

RUN JAR_FILE=$(ls target/*.jar) && \
    cp $JAR_FILE /app/OptimalRoadApp.jar

CMD ["java", "-jar", "/app/OptimalRoadApp.jar"]