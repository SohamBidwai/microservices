# Use OpenJDK 17 as base image
FROM openjdk:21-jdk-slim

# Set the working directory
WORKDIR /questionService

# Copy the JAR file from target directory to the container
COPY target/micro-questionservice-jar.jar micro-questionservice-jar.jar

# Expose the application port (change as needed)
EXPOSE 9094

# Run the application
ENTRYPOINT ["java", "-jar", "micro-questionservice-jar.jar"]
