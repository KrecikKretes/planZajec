FROM maven:3.8.5-openjdk-17 AS build
COPY . .
RUN mvn clean package -DskipTests

FROM openjdk:17.0.1-jdk-slim
COPY --from=build /target/planZajec-1.1.0.jar planZajec.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","planZajec.jar"]