#!/bin/sh
while ! `nc -z 192.168.99.100 $CONFIGSERVER_PORT`; do sleep 3; echo "config server waiting..."; done
while ! `nc -z 192.168.99.100 $DATABASESERVER_PORT`; do sleep 3; echo "database server waiting..."; done
java -Dspring.cloud.config.uri=$CONFIGSERVER_URI -Dspring.profiles.active=$PROFILE -jar /usr/local/msa-account-service/@project.build.finalName@.jar