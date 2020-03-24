FROM openjdk:8u242-jre-slim

RUN mkdir /app
ADD sinaspider-0.0.1-SNAPSHOT.jar /app/
WORKDIR /app

CMD ["java", "-jar", "sinaspider-0.0.1-SNAPSHOT.jar", "--spring.config.location=application.yml"]
