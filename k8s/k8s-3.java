
flannel:

kubeadm init --pod-network-cidr=10.244.0.0/16 

export KUBECONFIG=/etc/kubernetes/admin.conf

kubectl get pods --all-namespaces -o wide

kubectl apply -f https://raw.githubusercontent.com/coreos/flannel/a70459be0084506e4ec919aa1c114638878db11b/Documentation/kube-flannel.yml


export image=kubernetes-dashboard-amd64:v1.10.1
docker pull registry.cn-hangzhou.aliyuncs.com/mars_public/${image}
docker tag registry.cn-hangzhou.aliyuncs.com/mars_public/${image} k8s.gcr.io/${image}
docker rmi registry.cn-hangzhou.aliyuncs.com/mars_public/${image}


wget https://raw.githubusercontent.com/kubernetes/dashboard/v1.10.1/src/deploy/recommended/kubernetes-dashboard.yaml
kubectl apply -f kubernetes-dashboard.yaml


获取token:

kubectl -n kube-system describe $(kubectl -n kube-system get secret -n kube-system -o name | grep namespace) | grep token



RBAC

kubectl -n kube-system get secret -n kube-system -o name | grep dashboard

kubectl -n kube-system  get secret dashboard-token-rss4r -o jsonpath={.data.token}| base64 -d


kubectl proxy --address='172.31.212.238' --port=8080 --accept-hosts='^*$'

