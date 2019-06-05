#!/usr/bin/env bash
mvn clean package

docker login 10.160.2.15 -u hz1203298 -p 340251
docker build -t 10.160.2.83:6110/trip/user-service:latest .
docker logout
docker login 10.160.2.83 -u admin -p Harbor12345
docker push 10.160.2.83:6110/trip/user-service:latest
docker logout