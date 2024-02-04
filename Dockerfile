FROM maven:3.8.5-openjdk-17-slim AS build
WORKDIR /app
COPY . /app
RUN apt-get update && \
    apt-get install -y maven && \
    apt-get clean;

RUN mvn clean package
RUN mvn spring-boot:run

FROM openjdk:17.0.1-jdk
COPY --from=build /target/planZajec-1.1.0.jar planZajec.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","planZajec.jar"]

