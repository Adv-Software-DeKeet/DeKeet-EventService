FROM openjdk:19-jdk-alpine
MAINTAINER JoviSimons
COPY target/EventService-0.0.1-SNAPSHOT.jar EventService-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java","-jar","/EventService-0.0.1-SNAPSHOT.jar"]