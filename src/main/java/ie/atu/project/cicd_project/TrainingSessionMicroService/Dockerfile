# TrainingSessionMicroService/Dockerfile
FROM maven:3.8.1-jdk-11 as build
WORKDIR /app
COPY TrainingSessionMicroService/pom.xml .
COPY TrainingSessionMicroService/src ./src
RUN mvn package -DskipTests

FROM openjdk:11-jre-slim
COPY --from=build /app/target/training-session-service.jar app.jar
EXPOSE 8084
ENTRYPOINT ["java", "-jar", "app.jar"]
