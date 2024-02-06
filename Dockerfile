FROM maven:3.9.2-eclipse-temurin-17-alpine as builder

COPY ./src src/
COPY ./pom.xml pom.xml
COPY ./data data/

RUN mvn clean package -DskipTests

FROM eclipse-temurin:17-jre-alpine
COPY --from=builder target/*.jar app.jar
COPY data/* data/
COPY src/* src/
EXPOSE 443
CMD ["java","-jar","app.jar"]