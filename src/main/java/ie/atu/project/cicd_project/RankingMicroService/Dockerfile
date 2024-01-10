# Build stage
FROM openjdk:17-oracle AS build
WORKDIR /app
COPY RankingMicroService/pom.xml .
COPY RankingMicroService/src ./src
RUN mvn package -DskipTests

# Package stage
FROM openjdk:17-oracle
COPY --from=build /app/target/*.jar app.jar
EXPOSE 8083
ENTRYPOINT ["java", "-jar", "app.jar"]
