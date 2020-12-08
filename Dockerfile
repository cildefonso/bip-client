FROM adoptopenjdk/openjdk9-openj9:latest

WORKDIR /app

COPY target/bip-client-0.0.1-SNAPSHOT.jar /app/bip-client.jar

ENTRYPOINT ["java","-jar","bip-client.jar"]