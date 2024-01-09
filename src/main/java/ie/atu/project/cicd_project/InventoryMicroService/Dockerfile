# InventoryMicroService/Dockerfile
FROM maven:3.8.1-jdk-11 as build
WORKDIR /app
COPY InventoryMicroService/pom.xml .
COPY InventoryMicroService/src ./src
RUN mvn package -DskipTests

FROM openjdk:11-jre-slim
COPY --from=build /app/target/inventory-service.jar app.jar
EXPOSE 8081
ENTRYPOINT ["java", "-jar", "app.jar"]
