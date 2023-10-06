FROM openjdk:17-alpine
LABEL authors="Daniel Vieira"

WORKDIR /app
COPY target/observability-0.0.1-SNAPSHOT.jar /app.jar
EXPOSE 8080

CMD ["java", "-jar", "/app.jar"]