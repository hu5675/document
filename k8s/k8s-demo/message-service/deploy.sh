#!/usr/bin/env bash
IMAGE=`cat IMAGE_NAME`;
COUNT=`kubectl get deploy --show-labels | grep app=message-service | wc -l`;
if [[ ${COUNT} -gt 0 ]]; then
    echo "update image to :${IMAGE}";
    kubectl set image deployment/message-service-deployment message-service=${IMAGE}
else
    kubectl create -f message-service.yaml
fi
