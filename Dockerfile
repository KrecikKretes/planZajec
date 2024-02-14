FROM openjdk:17

ADD target/planZajec-1.1.0.jar .
ADD data ./data

EXPOSE 20348
CMD java -jar planZajec-1.1.0.jar