FROM openjdk:17
ARG JAR_FILE=build/libs/*.jar

ARG JENKINS_HOME_USER_ID
ARG JENKINS_HOME_GROUP_ID

RUN groupadd -g $JENKINS_HOME_GROUP_ID jenkins && \
    useradd -m jenkins -u $JENKINS_HOME_USER_ID -g $JENKINS_HOME_GROUP_ID

COPY ${JAR_FILE} delivery-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java", "-jar", "delivery-0.0.1-SNAPSHOT.jar"]