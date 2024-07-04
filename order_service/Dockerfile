# Use an official OpenJDK runtime as a parent image
FROM openjdk:latest

# Set the working directory inside the container
WORKDIR /app

# Copy the application's jar file to the container
COPY dist/order_service.jar /app/order_service.jar

# Make port 8080 available to the world outside this container
EXPOSE 8080

# Run the jar file
ENTRYPOINT ["java", "-jar", "order_service.jar"]
