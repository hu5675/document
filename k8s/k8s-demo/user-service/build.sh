#!/usr/bin/env bash
maven clean package -Dautoconfig.skip=true -Dmaven.test.skip=true;
TIME=`date "+%Y%m%d%H%M"`;
GIT_REVISION=`git log -1 --pretty=format:%h`;
docker login 10.160.2.15 -u hz1203298 -p 340251
docker build -t 10.160.2.83:6110/trip/user-service:${TIME}_${GIT_REVISION} .
docker logout
docker login 10.160.2.83:6110 -u admin -p Harbor12345
docker push 10.160.2.83:6110/trip/user-service:${TIME}_${GIT_REVISION}
docker logout