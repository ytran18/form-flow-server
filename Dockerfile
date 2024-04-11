FROM maven:3.9.6-openjdk-17

WORKDIR /app

COPY pom.xml .
COPY src ./src

RUN mvn clean package -DskipTests

FROM openjdk:17

WORKDIR /app

COPY --from=build /app/target/mongo-restAPI-0.0.1-SNAPSHOT.jar /app/

CMD ["java", "-jar", "mongo-restAPI-0.0.1-SNAPSHOT.jar"]
