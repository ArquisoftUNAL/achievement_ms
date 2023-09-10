FROM openjdk:20-jdk-alpine
COPY target/achievdb2-0.0.1-SNAPSHOT.jar achievdb2-app.jar
ENTRYPOINT ["java", "-jar", "achievdb2-app.jar"]