FROM openjdk:17-alpine
ARG JAR_FILE=build/libs/*.jar
COPY ${JAR_FILE} delivery-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java", "-jar", "delivery-0.0.1-SNAPSHOT.jar"]