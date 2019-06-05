#!/usr/bin/env bash
mvn clean package -Dautoconfig.skip=true -Dmaven.test.skip=true;
TIME=`date "+%Y%m%d%H%M"`;
GIT_REVISION=`git log -1 --pretty=format:%h`;
IMAGE_NAME=10.160.2.83:6110/trip/message-service:${TIME}_${GIT_REVISION};
docker login 10.160.2.15 -u hz1203298 -p 340251
docker build -t ${IMAGE_NAME} .
docker logout
docker login 10.160.2.83:6110 -u admin -p Harbor12345
docker push ${IMAGE_NAME}
docker logout

echo "${IMAGE_NAME}" > IMAGE_NAME