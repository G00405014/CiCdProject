# EventMicroService/Dockerfile
FROM maven:3.8.1-jdk-11 as build
WORKDIR /app
COPY EventMicroService/pom.xml .
COPY EventMicroService/src ./src
RUN mvn package -DskipTests

FROM openjdk:11-jre-slim
COPY --from=build /app/target/event-service.jar app.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app.jar"]
