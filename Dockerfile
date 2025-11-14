# Stage 1: Build
FROM maven:3.9.2-eclipse-temurin-17 AS build
WORKDIR /app

# Copy pom and src
COPY pom.xml .
COPY src ./src

# Build the JAR
RUN mvn clean package -DskipTests

# Stage 2: Run
FROM eclipse-temurin:17-jdk-jammy
WORKDIR /app
COPY --from=build /app/target/blackfabricsecuritybackend-0.0.1-SNAPSHOT.jar app.jar

EXPOSE 8080
ENTRYPOINT ["java","-jar","app.jar"]
