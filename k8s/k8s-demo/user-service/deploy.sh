#!/usr/bin/env bash
IMAGE=`cat IMAGE_NAME`;
echo "update image to :${IMAGE}";
kubectl set image deployment/user-service-deployment user-service=${IMAGE}