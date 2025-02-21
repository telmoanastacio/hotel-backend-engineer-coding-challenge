# Use the official OpenJDK image as the base image
FROM eclipse-temurin:21-jdk-jammy

# Set the working directory in the Docker container
WORKDIR /app

# Copy the JAR file from your host system into the Docker image
COPY target/backend-engineer-coding-challenge-0.0.1-SNAPSHOT.jar /app

# Set the startup command to execute your application
CMD ["java", "-jar", "/app/backend-engineer-coding-challenge-0.0.1-SNAPSHOT.jar"]
