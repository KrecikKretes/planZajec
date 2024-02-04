FROM openjdk:17.0.1-jdk-slim
COPY --from=target /target/planZajec-1.1.0.jar planZajec.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","planZajec.jar"]