FROM 10.160.2.15/jdk/alpine-oraclejdk8
MAINTAINER xxx xxx@mars.com

COPY target/user-service-0.0.1-SNAPSHOT.jar /user-service.jar
ENTRYPOINT ["java", "-jar", "/user-service.jar"]