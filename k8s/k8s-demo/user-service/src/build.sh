#!/usr/bin/env bash
mvn clean package

docker build -t 10.160.2.83:6110/trip/user-service:latest .
docker login 10.160.2.83 -u admin -p Harbor12345
docker push 10.160.2.83:6110/trip/user-service:latest