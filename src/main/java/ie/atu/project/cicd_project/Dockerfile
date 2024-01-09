# Use a Maven base image to build your project
FROM maven:3.6.3-jdk-11 as builder
WORKDIR /app
COPY pom.xml .
COPY src ./src
RUN mvn clean package

# Use a Java base image for the final image
FROM openjdk:11-jre-slim
WORKDIR /app
COPY --from=builder /app/target/*.jar ./app.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app.jar"]
