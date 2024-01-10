# Build stage
FROM openjdk:17-oracle AS build
WORKDIR /app
COPY EventMicroService/pom.xml .
COPY EventMicroService/src ./src
RUN mvn package -DskipTests

# Package stage
FROM openjdk:17-oracle
COPY --from=build /app/target/*.jar app.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app.jar"]
