
FROM maven:3.8.4-openjdk-17 as maven-builder
COPY src /app/src
COPY pom.xml /app
RUN mvn -f /app/pom.xml clean package -DskipTests
FROM openjdk:17-alpine
COPY --from=maven-builder app/target/cloud-gateway-0.0.1-SNAPSHOT.jar  /app-service/cloud-gateway-0.0.1-SNAPSHOT.jar
WORKDIR /app-service
EXPOSE 8083
ENTRYPOINT ["java","-jar","cloud-gateway-0.0.1-SNAPSHOT.jar"]