#!/usr/bin/env bash
echo "********************************************************"
echo " Starting the Service Discovery (Eureka) Server"
echo "********************************************************"
java -Djava.security.egd=file:/dev/./urandom -jar /usr/local/eurekaserver/@project.build.finalName@.jar
