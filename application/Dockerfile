FROM openjdk:8-jdk-alpine
ARG JAR_FILE=target/spring-boot-web.jar
WORKDIR /opt/app
cp target/sample.multimodule.application-0.0.1-SNAPSHOT.jar /opt/app/app.jar
COPY ${JAR_FILE} app.jar
ENTRYPOINT ["java","-jar","app.jar"]