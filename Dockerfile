
FROM openjdk:17-jdk-alpine

# Build the application using Maven 
RUN ./mvnw clean install -DskipTests

EXPOSE 8080

ENV APP_NAME  /usr/src/deploycrm


COPY target/*.jar $APP_NAME/deploycrm.jar

WORKDIR $APP_NAME

# Set the entry point to run the application
CMD ["java", "-jar", "target/deploycrm.jar"]
