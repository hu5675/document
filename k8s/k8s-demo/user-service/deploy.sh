#!/usr/bin/env bash
IMAGE=`cat IMAGE_NAME`;
COUNT=`kubectl get deploy --show-labels | grep app=user-service | wc -l`;
if [[ ${COUNT} -gt 0 ]]; then
    echo "update image to :${IMAGE}";
    kubectl set image deployment/user-service-deployment user-service=${IMAGE}
else
    kubectl create -f user-service.yaml
fi
