FROM openjdk:17-jdk
WORKDIR /app
COPY target/mongo-restAPI-0.0.1-SNAPSHOT.jar /app/
CMD ["java", "-jar", "your-app.jar"]