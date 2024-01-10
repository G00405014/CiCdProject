# Build stage
FROM maven:3.8.1-jdk-11 as build
WORKDIR /app
COPY TrainingSessionMicroService/pom.xml .
COPY TrainingSessionMicroService/src ./src
RUN mvn package -DskipTests

# Package stage
FROM openjdk:17-oracle
COPY --from=build /app/target/*.jar app.jar
EXPOSE 8084
ENTRYPOINT ["java", "-jar", "app.jar"]
