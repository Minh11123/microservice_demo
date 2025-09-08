FROM openjdk:latest
WORKDIR /app
COPY target/inventory_service.jar /app/inventory_service.jar
EXPOSE 8083
ENTRYPOINT ["java","-jar","inventory_service.jar"]
