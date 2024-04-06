FROM ubuntu:latest AS build

RUN apt-get update
RUN apt-get install openjdk-17-jdk -y
COPY . .

RUN ./mvnw bootJar --no-daemon

FROM openjdk:17-jdk-slim

EXPOSE 8080

COPY --from=target /target/classlodge-1.jar classlodge.jar
#COPY --from=build /build/libs/classlodge-1.jar classlodge.jar

ENTRYPOINT ["java", "-jar", "classlodge.jar"]