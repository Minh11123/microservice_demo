# Use an official OpenJDK runtime as a parent image
FROM openjdk:latest

# Set the working directory inside the container
WORKDIR /app

# Copy the application's jar file to the container
COPY dist/Authen_service.jar /app/Authen_service.jar

# Make port 8080 available to the world outside this container
EXPOSE 8888

# Run the jar file
ENTRYPOINT ["java", "-jar", "Authen_service.jar"]
