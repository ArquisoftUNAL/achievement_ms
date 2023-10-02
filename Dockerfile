FROM eclipse-temurin:20-jdk-alpine
RUN apk add --no-cache maven
WORKDIR /java
COPY . /java
RUN mvn package -Dmaven.test.skip=true
EXPOSE 8181
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/java/target/achievdb2-0.0.1-SNAPSHOT.jar"]