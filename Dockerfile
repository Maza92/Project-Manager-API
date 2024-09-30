FROM openjdk:21
WORKDIR /app
COPY target/manager-0.0.1-SNAPSHOT.jar /app/manager-0.0.1-SNAPSHOT.jar
EXPOSE 8080
CMD ["java", "-jar", "/app/manager-0.0.1-SNAPSHOT.jar"]
