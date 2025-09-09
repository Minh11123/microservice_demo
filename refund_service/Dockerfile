FROM openjdk:latest
WORKDIR /app
COPY target/refund_service.jar /app/refund_service.jar
EXPOSE 8084
ENTRYPOINT ["java","-jar","refund_service.jar"]
