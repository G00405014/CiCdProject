# Use an Eclipse Temurin base image for the final image
# Use an OpenJDK base image
FROM openjdk:17-oracle
WORKDIR /app
COPY target/CiCdProject-0.0.1-SNAPSHOT.jar /app
EXPOSE 8080

CMD {"java", "-jar", "CiCdProject-0.0.1-SNAPSHOT.jar"}
