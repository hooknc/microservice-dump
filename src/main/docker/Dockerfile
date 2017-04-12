FROM ubuntu:latest

RUN apt-get update
RUN apt-get install -y openjdk-8-jdk
RUN apt-get clean

ADD ncdump-1.0-SNAPSHOT.jar ncdump.jar

RUN bash -c 'touch /ncdump.jar'

EXPOSE 8080

ENTRYPOINT ["java","-jar","ncdump.jar"]
