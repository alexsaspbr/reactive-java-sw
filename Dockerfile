FROM openjdk:17
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} products.jar
ENTRYPOINT ["java", "-jar", "/products.jar"]