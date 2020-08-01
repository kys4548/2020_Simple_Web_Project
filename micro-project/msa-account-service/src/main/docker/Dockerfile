FROM openjdk:8-jdk-alpine
RUN apk update && apk upgrade && apk add netcat-openbsd
RUN mkdir -p /usr/local/msa-account-service
ADD @project.build.finalName@.jar /usr/local/msa-account-service
ADD run.sh run.sh
RUN chmod +x run.sh
RUN sed -i 's/\r$//' run.sh
CMD ["sh", "./run.sh"]