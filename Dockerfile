FROM openjdk:17
ARG JAR_FILE=target/*.jar
COPY ./target/stone-scissors-paper-0.0.1-SNAPSHOT.jar stone-scissors-paper.jar
ENTRYPOINT ["java", "-jar", "/stone-scissors-paper.jar"]