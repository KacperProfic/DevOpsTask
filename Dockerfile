# ETAP 1: Budowanie z Maven + OpenJDK 17 (DZIAŁA!)
FROM maven:3.9.6-eclipse-temurin-17 AS build
WORKDIR /app
COPY pom.xml .
COPY src ./src
RUN --mount=type=cache,target=/root/.m2 mvn clean package -DskipTests

# ETAP 2: Uruchamianie z lekkim OpenJDK 17
FROM eclipse-temurin:17-jre-alpine
WORKDIR /app
COPY --from=build /app/target/restservice-0.0.1-SNAPSHOT.jar app.jar
EXPOSE 8080
CMD ["java", "-jar", "app.jar"]
