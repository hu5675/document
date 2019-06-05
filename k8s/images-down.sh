sudo docker pull registry.cn-hangzhou.aliyuncs.com/mars_public/pause:3.1 
sudo docker pull registry.cn-hangzhou.aliyuncs.com/mars_public/etcd:3.3.10  
sudo docker pull registry.cn-hangzhou.aliyuncs.com/mars_public/coredns:1.3.1  
sudo docker pull registry.cn-hangzhou.aliyuncs.com/mars_public/kube-scheduler:v1.14.1
sudo docker pull registry.cn-hangzhou.aliyuncs.com/mars_public/kube-proxy:v1.14.1  
sudo docker pull registry.cn-hangzhou.aliyuncs.com/mars_public/kube-apiserver:v1.14.1  
sudo docker pull registry.cn-hangzhou.aliyuncs.com/mars_public/kube-controller-manager:v1.14.1 

sudo docker pull registry.cn-hangzhou.aliyuncs.com/mars_public/flannel:v0.11.0-amd64
sudo docker pull registry.cn-hangzhou.aliyuncs.com/mars_public/kubernetes-dashboard-amd64:v1.10.1


sudo docker tag registry.cn-hangzhou.aliyuncs.com/mars_public/pause:3.1   k8s.gcr.io/pause:3.1
sudo docker tag registry.cn-hangzhou.aliyuncs.com/mars_public/etcd:3.3.10  k8s.gcr.io/etcd:3.3.10
sudo docker tag registry.cn-hangzhou.aliyuncs.com/mars_public/coredns:1.3.1  k8s.gcr.io/coredns:1.3.1
sudo docker tag registry.cn-hangzhou.aliyuncs.com/mars_public/kube-scheduler:v1.14.1  k8s.gcr.io/kube-scheduler:v1.14.1
sudo docker tag registry.cn-hangzhou.aliyuncs.com/mars_public/kube-proxy:v1.14.1  k8s.gcr.io/kube-proxy:v1.14.1 
sudo docker tag registry.cn-hangzhou.aliyuncs.com/mars_public/kube-apiserver:v1.14.1  k8s.gcr.io/kube-apiserver:v1.14.1
sudo docker tag registry.cn-hangzhou.aliyuncs.com/mars_public/kube-controller-manager:v1.14.1 k8s.gcr.io/kube-controller-manager:v1.14.1

sudo docker tag registry.cn-hangzhou.aliyuncs.com/mars_public/flannel:v0.11.0-amd64  quay.io/coreos/flannel:v0.11.0-amd64 
sudo docker tag registry.cn-hangzhou.aliyuncs.com/mars_public/kubernetes-dashboard-amd64:v1.10.1  k8s.gcr.io/kubernetes-dashboard-amd64:v1.10.1


sudo docker rmi registry.cn-hangzhou.aliyuncs.com/mars_public/pause:3.1 
sudo docker rmi registry.cn-hangzhou.aliyuncs.com/mars_public/etcd:3.3.10  
sudo docker rmi registry.cn-hangzhou.aliyuncs.com/mars_public/coredns:1.3.1  
sudo docker rmi registry.cn-hangzhou.aliyuncs.com/mars_public/kube-scheduler:v1.14.1
sudo docker rmi registry.cn-hangzhou.aliyuncs.com/mars_public/kube-proxy:v1.14.1  
sudo docker rmi registry.cn-hangzhou.aliyuncs.com/mars_public/kube-apiserver:v1.14.1  
sudo docker rmi registry.cn-hangzhou.aliyuncs.com/mars_public/kube-controller-manager:v1.14.1 

sudo docker rmi registry.cn-hangzhou.aliyuncs.com/mars_public/flannel:v0.11.0-amd64
sudo docker rmi registry.cn-hangzhou.aliyuncs.com/mars_public/kubernetes-dashboard-amd64:v1.10.1