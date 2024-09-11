# Use a base image with Java runtime
FROM openjdk:17-jdk-alpine

# Set the working directory inside the container
WORKDIR /deploycrm

# Copy the Maven/Gradle build file and your source code to the container
COPY . .

# Build the application using Maven or Gradle
RUN ./mvnw clean install -DskipTests

# Expose the application port (if your API runs on port 8080, for example)

EXPOSE 8080


# Set the entry point to run the application
CMD ["java", "-jar", "target/deploycrm.jar"]
