FROM openjdk:17

ADD target/planZajec-1.4.0.jar .

EXPOSE 20348
CMD java -jar planZajec-1.4.0.jar