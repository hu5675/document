
flannel:

kubeadm init --kubernetes-version=v1.14.1 --pod-network-cidr=10.244.0.0/16  

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



http://192.168.145.209:8001/api/v1/namespaces/kube-system/services/https:kubernetes-dashboard:/proxy/#!/login

vim dashboard-admin.yaml

apiVersion: rbac.authorization.k8s.io/v1beta1
kind: ClusterRoleBinding
metadata:
  name: kubernetes-dashboard
labels:
  k8s-app: kubernetes-dashboard
roleRef:
  apiGroup: rbac.authorization.k8s.io
  kind: ClusterRole
  name: cluster-admin
subjects:
  - kind: ServiceAccount
  name: kubernetes-dashboard
  namespace: kube-system    