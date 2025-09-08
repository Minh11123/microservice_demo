FROM openjdk:latest
WORKDIR /app
COPY target/payment_service.jar /app/payment_service.jar
EXPOSE 8082
ENTRYPOINT ["java","-jar","payment_service.jar"]
