FROM openjdk:8-jdk-alpine

WORKDIR /app
COPY ./target/scd-elasticsearch-0.0.1-SNAPSHOT.jar /app
RUN mkdir /bck
EXPOSE 8083
VOLUME /bck:/home/sergio/Downloads
ENTRYPOINT java -jar scd-elasticsearch-0.0.1-SNAPSHOT.jar
