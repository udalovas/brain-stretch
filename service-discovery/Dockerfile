FROM openjdk:8-jdk-alpine
ARG JAR_FILE
MAINTAINER Alex Udalov <al.udalovas@gmail.com>

# install netcat-openbsd (?)
RUN apk update && apk upgrade && apk add netcat-openbsd
# add runnable jar and start script
WORKDIR /usr/local/service-discovery
ADD target/${JAR_FILE} ${JAR_FILE}
ADD Dockerrun.sh run.sh
# GO!
RUN chmod +x run.sh
CMD ./run.sh