# Docker Image name: order-service-app-demo

# Use the official image as a parent image.
FROM openjdk:8-jdk-alpine

# Creates a mount point with the specified name 
VOLUME /tmp

# variable that users can pass at build-time to the builder with the docker build command 
ARG JAR_FILE

# Add files into docker image
ADD ${JAR_FILE} app.jar

# Allows you to configure a container that will run as an executable
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/app.jar"]