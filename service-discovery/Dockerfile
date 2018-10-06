FROM openjdk:8-jdk-alpine
MAINTAINER Alex Udalov <al.udalovas@gmail.com>
RUN apk update && apk upgrade && apk add netcat-openbsd
# prepare a runnable artifact
RUN mkdir -p /usr/local/service-discovery
#ADD target/@project.build.finalName@.jar /usr/local/service-discovery
ARG JAR_FILE
ADD target/${JAR_FILE} /usr/local/service-discovery
# start script
ADD Dockerrun.sh run.sh
RUN chmod +x run.sh
# GO!
CMD ./run.sh
