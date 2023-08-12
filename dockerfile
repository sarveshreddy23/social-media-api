FROM openjdk:17-jdk-alpine
MAINTAINER sarvesh
COPY target/*.jar api.jar
ENTRYPOINT ["java", "-Dspring.datasource.url=jdbc:mysql://host.docker.internal:3306/social-media-app", "-jar", "/api.jar"]