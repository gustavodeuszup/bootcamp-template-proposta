FROM openjdk:11-jre-slim
COPY ./target/proposta-0.0.1-SNAPSHOT.jar /usr/src/test/
WORKDIR /usr/src/test
EXPOSE 8080
CMD ["java", "-jar", "proposta-0.0.1-SNAPSHOT.jar"]