FROM openjdk:latest
WORKDIR /app
COPY target/job_service.jar /app/job_service.jar
EXPOSE 8081
ENTRYPOINT ["java","-jar","job_service.jar"]
