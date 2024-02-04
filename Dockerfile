FROM maven:3.8.3-openjdk-17 AS build
COPY . .
RUN mvn clean package -Pprod -DskipTests

FROM eclipse-temurin:17-alpine
COPY --from=build /target/planZajec-1.1.0.jar planZajec.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","planZajec.jar"]
