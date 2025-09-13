# Utilise OpenJDK 17
FROM eclipse-temurin:17-jdk-alpine

# Crée le dossier app
WORKDIR /app

# Copie tout le projet dans l'image Docker
COPY . .

# Build le projet
RUN ./mvnw clean package -DskipTests

# Expose le port utilisé par Spring Boot
EXPOSE 8080

# Commande pour lancer l'app
CMD ["java", "-jar", "target/projetintegration-0.0.1-SNAPSHOT.jar"]
