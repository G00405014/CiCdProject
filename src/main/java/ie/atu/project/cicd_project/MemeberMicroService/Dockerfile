# MemberMicroService/Dockerfile
FROM maven:3.8.1-jdk-11 as build
WORKDIR /app
COPY MemberMicroService/pom.xml .
COPY MemberMicroService/src ./src
RUN mvn package -DskipTests

FROM openjdk:11-jre-slim
COPY --from=build /app/target/member-service.jar app.jar
EXPOSE 8082
ENTRYPOINT ["java", "-jar", "app.jar"]
