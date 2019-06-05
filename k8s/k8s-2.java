cat <<EOF > /etc/sysctl.d/k8s.conf
net.ipv4.ip_forward = 1
net.bridge.bridge-nf-call-ip6tables = 1
net.bridge.bridge-nf-call-iptables = 1
net.bridge.bridge-nf-call-arptables = 1
EOF


sudo sysctl --system


systemctl daemon-reload
service docker restart


cat <<EOF > /etc/yum.repos.d/kubernetes.repo
[kubernetes]
name=Kubernetes
baseurl=https://mirrors.aliyun.com/kubernetes/yum/repos/kubernetes-el7-x86_64/
enabled=1
gpgcheck=0
EOF


https://docker.mirrors.ustc.edu.cn


Environment="HTTP_PROXY=http://127.0.01:8118/" "HTTPS_PROXY=https://127.0.01:8118/"

https://k8s.gcr.io/v2/


docker pull k8s.gcr.io/kube-apiserver:v1.14.1


docker login --username=燕儿飞战神 registry.cn-hangzhou.aliyuncs.com

hytmars1989

docker pull k8s.gcr.io/pause:3.1 

docker pull k8s.gcr.io/etcd:3.3.10

docker pull k8s.gcr.io/coredns:1.3.1

docker pull k8s.gcr.io/kube-scheduler:v1.14.1

docker pull k8s.gcr.io/kube-proxy:v1.14.1 

docker pull k8s.gcr.io/kube-apiserver:v1.14.1

docker pull k8s.gcr.io/kube-controller-manager:v1.14.1


docker tag k8s.gcr.io/pause:3.1 registry.cn-hangzhou.aliyuncs.com/mars_public/pause:3.1
docker tag k8s.gcr.io/etcd:3.3.10 registry.cn-hangzhou.aliyuncs.com/mars_public/etcd:3.3.10 
docker tag k8s.gcr.io/coredns:1.3.1  registry.cn-hangzhou.aliyuncs.com/mars_public/coredns:1.3.1
docker tag k8s.gcr.io/kube-scheduler:v1.14.1  registry.cn-hangzhou.aliyuncs.com/mars_public/kube-scheduler:v1.14.1
docker tag k8s.gcr.io/kube-proxy:v1.14.1  registry.cn-hangzhou.aliyuncs.com/mars_public/kube-proxy:v1.14.1
docker tag k8s.gcr.io/kube-apiserver:v1.14.1 registry.cn-hangzhou.aliyuncs.com/mars_public/kube-apiserver:v1.14.1
docker tag k8s.gcr.io/kube-controller-manager:v1.14.1  registry.cn-hangzhou.aliyuncs.com/mars_public/kube-controller-manager:v1.14.1


docker tag quay.io/coreos/flannel:v0.11.0-amd64 registry.cn-hangzhou.aliyuncs.com/mars_public/flannel:v0.11.0-amd64
docker tag k8s.gcr.io/kubernetes-dashboard-amd64:v1.10.1  registry.cn-hangzhou.aliyuncs.com/mars_public/ubernetes-dashboard-amd64:v1.10.1 

docker push registry.cn-hangzhou.aliyuncs.com/mars_public/pause:3.1 
docker push registry.cn-hangzhou.aliyuncs.com/mars_public/etcd:3.3.10  
docker push registry.cn-hangzhou.aliyuncs.com/mars_public/coredns:1.3.1  
docker push registry.cn-hangzhou.aliyuncs.com/mars_public/kube-scheduler:v1.14.1
docker push registry.cn-hangzhou.aliyuncs.com/mars_public/kube-proxy:v1.14.1  
docker push registry.cn-hangzhou.aliyuncs.com/mars_public/kube-apiserver:v1.14.1  
docker push registry.cn-hangzhou.aliyuncs.com/mars_public/kube-controller-manager:v1.14.1 

docker push registry.cn-hangzhou.aliyuncs.com/mars_public/flannel:v0.11.0-amd64
docker push registry.cn-hangzhou.aliyuncs.com/mars_public/kubernetes-dashboard-amd64:v1.10.1


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



# 临时禁用selinux
# 永久关闭 修改/etc/sysconfig/selinux文件设置
sed -i 's/SELINUX=permissive/SELINUX=disabled/' /etc/sysconfig/selinux
setenforce 0

# 临时关闭swap
# 永久关闭 注释/etc/fstab文件里swap相关的行
swapoff -a



# 开启forward
# Docker从1.13版本开始调整了默认的防火墙规则
# 禁用了iptables filter表中FOWARD链
# 这样会引起Kubernetes集群中跨Node的Pod无法通信

iptables -P FORWARD ACCEPT

# 配置转发相关参数，否则可能会出错
cat <<EOF >  /etc/sysctl.d/k8s.conf
net.bridge.bridge-nf-call-ip6tables = 1
net.bridge.bridge-nf-call-iptables = 1
vm.swappiness=0
EOF
sysctl --system


$ kubectl get node
The connection to the server localhost:8080 was refused - did you specify the right host or port?
What？上边不都显示安装完成了吗？其实是已经初始化完成了，只不过想使用集群的话，少了上边日志输出的那一步。

sudo cp /etc/kubernetes/admin.conf $HOME/
sudo chown $(id -u):$(id -g) $HOME/admin.conf
export KUBECONFIG=$HOME/admin.conf

export KUBECONFIG=/etc/kubernetes/admin.conf

kubectl get pods --all-namespaces -o wide

kubectl describe pod -n kube-system calico-node-v2k77


kubeadm join 172.31.212.230:6443 --token pizt8p.sr9xauheb2dokttv \
--discovery-token-ca-cert-hash sha256:cbed9a55fd128036547f6f2da49b0d309b3af977a8db44339ead651b101bb5d5 


kubeadm join 172.31.212.230:6443 --token tlsr28.5qinpz47conosdej --discovery-token-ca-cert-hash sha256:0433857ce2e8d5b158df0b2adbb940a585834fcd8a9500a02176523bcc39df40 

scp root@47.105.103.149:/etc/kubernetes/admin.conf .
kubectl --kubeconfig ./admin.conf get nodes

kubectl --kubeconfig ./admin.conf apply -f \
https://docs.projectcalico.org/v3.6/getting-started/kubernetes/installation/hosted/kubernetes-datastore/calico-networking/1.7/calico.yaml

kube-apiserver --advertise-address=172.31.212.230 --allow-privileged=true --authorization-mode=Node,RBAC --client-ca-file=/etc/kubernetes/pki/ca.crt --enable-admission-plugins=NodeRestriction --enable-bootstrap-token-auth=true --etcd-cafile=/etc/kubernetes/pki/etcd/ca.crt --etcd-certfile=/etc/kubernetes/pki/apiserver-etcd-client.crt --etcd-keyfile=/etc/kubernetes/pki/apiserver-etcd-client.key --etcd-servers=https://127.0.0.1:2379 --insecure-port=0 --kubelet-client-certificate=/etc/kubernetes/pki/apiserver-kubelet-client.crt --kubelet-client-key=/etc/kubernetes/pki/apiserver-kubelet-client.key --kubelet-preferred-address-types=InternalIP,ExternalIP,Hostname --proxy-client-cert-file=/etc/kubernetes/pki/front-proxy-client.crt --proxy-client-key-file=/etc/kubernetes/pki/front-proxy-client.key --requestheader-allowed-names=front-proxy-client --requestheader-client-ca-file=/etc/kubernetes/pki/front-proxy-ca.crt --requestheader-extra-headers-prefix=X-Remote-Extra- --requestheader-group-headers=X-Remote-Group --requestheader-username-headers=X-Remote-User --secure-port=6443 --service-account-key-file=/etc/kubernetes/pki/sa.pub --service-cluster-ip-range=10.96.0.0/12 --tls-cert-file=/etc/kubernetes/pki/apiserver.crt --tls-private-key-file=/etc/kubernetes/pki/apiserver.key


kubectl apply -f https://docs.projectcalico.org/v3.3/getting-started/kubernetes/installation/hosted/rbac-kdd.yaml

kubectl apply -f https://docs.projectcalico.org/v3.3/getting-started/kubernetes/installation/hosted/kubernetes-datastore/calico-networking/1.7/calico.yaml



failed to "StartContainer" for "calico-node" with CrashLoopBackOff

rm -rf /etc/kubernetes/*.conf
rm -rf /etc/kubernetes/manifests/*.yaml
docker ps -a |awk '{print $1}' |xargs docker rm -f
systemctl  stop kubelet


kubeadm init \
--apiserver-advertise-address=172.31.212.230 \
--image-repository registry.aliyuncs.com/google_containers \
--kubernetes-version=v1.14.1 \
--pod-network-cidr=10.244.0.0/16 \
--service-cidr=10.96.0.0/12 \
--ignore-preflight-errors=Swap


kubeadm init \
--apiserver-advertise-address=172.31.212.233 \
--image-repository registry.aliyuncs.com/google_containers \
--kubernetes-version=v1.13.0 \
--pod-network-cidr=192.168.0.0/16 \
--ignore-preflight-errors=Swap


/root/services/nginx-deployment.yaml
/var/lib/kubelet/config.yaml
/etc/kubernetes/manifests/kube-controller-manager.yaml
/etc/kubernetes/manifests/kube-scheduler.yaml
/etc/kubernetes/manifests/kube-apiserver.yaml
/etc/kubernetes/manifests/etcd.yaml


k8s.gcr.io/kube-apiserver:v1.13.0
k8s.gcr.io/kube-controller-manager:v1.13.0
k8s.gcr.io/kube-scheduler:v1.13.0
k8s.gcr.io/kube-proxy:v1.13.0
k8s.gcr.io/pause:3.1
k8s.gcr.io/etcd:3.2.24
k8s.gcr.io/coredns:1.3.1



export image=kubernetes-dashboard-amd64:v1.10.1
docker pull registry.cn-hangzhou.aliyuncs.com/mars_public/${image}
docker tag registry.cn-hangzhou.aliyuncs.com/mars_public/${image} quay.io/coreos/${image}
docker rmi registry.cn-hangzhou.aliyuncs.com/mars_public/${image}






