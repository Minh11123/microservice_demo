# Use an official OpenJDK runtime as a parent image
FROM openjdk:latest

# Set the working directory inside the container
WORKDIR /app

# Copy the application's jar file to the container
COPY dist/customer_service.jar /app/customer_service.jar

# Make port 8080 available to the world outside this container
EXPOSE 8082

# Run the jar file
ENTRYPOINT ["java", "-jar", "customer_service.jar"]
