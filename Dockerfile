FROM openjdk:8-jdk-alpine
RUN adduser -S payment
RUN apk --no-cache add curl
USER payment
WORKDIR /usr/local/bin/payment
VOLUME /tmp
ADD target/*.jar /usr/local/bin/payment/app.jar
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/usr/local/bin/payment/app.jar"]