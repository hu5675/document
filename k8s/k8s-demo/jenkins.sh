#!/bin/bash

workDir=`pwd`;
workspaceDir="${JENKINS_HOME}/workspace";
echo "$workDir";
echo "$workspaceDir";


cd k8s/k8s-demo/

mvn clean package -Dautoconfig.skip=true -Dmaven.test.skip=true;

##########

cd "$workDir/k8s/k8s-demo/user-service"
echo `pwd`;
chmod +x build.sh
chmod +x deploy.sh
sh build.sh
sh deploy.sh

##########


cd "$workDir/k8s/k8s-demo/message-service"
chmod +x build.sh
chmod +x deploy.sh
sh build.sh
sh deploy.sh

##########


cd "$workDir/k8s/k8s-demo/user-edge-service"
chmod +x build.sh
chmod +x deploy.sh
sh build.sh
sh deploy.sh

