# Use an official OpenJDK runtime as a parent image
FROM openjdk:17-jdk-slim

# Set the working directory
WORKDIR /app

# Copy the project's jar file into the container
COPY target/bitcoin-service-1.0-SNAPSHOT.jar /app/bitcoin-service.jar

# Command to run the application
ENTRYPOINT ["java", "-jar", "/app/bitcoin-service.jar"]
