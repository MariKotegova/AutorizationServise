FROM openjdk:8-jdk-alpine

EXPOSE 8081

ADD build/libs/AutorizationServise-0.0.1-SNAPSHOT.jar myapp.jar

CMD ["java", "-jar", "myapp.jar"]