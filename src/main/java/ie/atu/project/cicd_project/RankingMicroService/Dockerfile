# RankingMicroService/Dockerfile
FROM maven:3.8.1-jdk-11 as build
WORKDIR /app
COPY RankingMicroService/pom.xml .
COPY RankingMicroService/src ./src
RUN mvn package -DskipTests

FROM openjdk:11-jre-slim
COPY --from=build /app/target/ranking-service.jar app.jar
EXPOSE 8083
ENTRYPOINT ["java", "-jar", "app.jar"]
