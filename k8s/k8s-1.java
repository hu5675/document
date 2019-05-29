

部署ETCD（主节点）

service etcd stop
rm -rf /var/lib/etcd/*
rm -rf /lib/systemd/system/etcd.service

cp ~/kubernetes-starter/target/master-node/etcd.service /lib/systemd/system/
systemctl enable etcd.service
mkdir -p /var/lib/etcd
service etcd start

journalctl -f -u etcd.service


部署APIServer（主节点）


cp target/master-node/kube-apiserver.service /lib/systemd/system/
systemctl enable kube-apiserver.service
service kube-apiserver start

journalctl -f -u kube-apiserver


部署ControllerManager（主节点）

cp target/master-node/kube-controller-manager.service /lib/systemd/system/
systemctl enable kube-controller-manager.service
service kube-controller-manager start

journalctl -f -u kube-controller-manager


部署Scheduler（主节点）

cp target/master-node/kube-scheduler.service /lib/systemd/system/
systemctl enable kube-scheduler.service
service kube-scheduler start

journalctl -f -u kube-scheduler


/**** calico 所有节点 ******/

service kube-calico stop
systemctl disable kube-calico.service
rm -rf /lib/systemd/system/kube-calico.service

cp target/all-node/kube-calico.service /lib/systemd/system/
systemctl enable kube-calico.service
service kube-calico start

journalctl -f -u kube-calico


配置kubectl命令（任意节点）


kubectl config set-cluster kubernetes  --server=http://172.31.212.223:8080
kubectl config set-context kubernetes --cluster=kubernetes
kubectl config use-context kubernetes


/**** kubelet 节点安装 ******/

service kubelet stop

systemctl disable kubelet.service

rm -rf var/lib/kubelet
rm -rf /etc/kubernetes
rm -rf /etc/cni/net.d
rm -rf /lib/systemd/system/kubelet.service


mkdir -p /var/lib/kubelet
mkdir -p /etc/kubernetes
mkdir -p /etc/cni/net.d
cp target/worker-node/kubelet.service /lib/systemd/system/
cp target/worker-node/kubelet.kubeconfig /etc/kubernetes/
cp target/worker-node/10-calico.conf /etc/cni/net.d/

systemctl enable kubelet.service
service kubelet start
journalctl -f -u kubelet



mkdir -p /var/lib/kube-proxy
cp target/worker-node/kube-proxy.service /lib/systemd/system/
cp target/worker-node/kube-proxy.kubeconfig /etc/kubernetes/
systemctl enable kube-proxy.service
service kube-proxy start
journalctl -f -u kube-proxy



curl http://127.0.0.1:8001/api/v1/proxy/namespaces/default/pods/kubernetes-bootcamp-6564dc5dfc-lxkjp/

curl http://127.0.0.1:8001/api/v1/namespaces/default/pods/kubernetes-bootcamp-6564dc5dfc-lxkjp/proxy/

curl http://172.31.212.192:8001/api/v1/proxy/namespaces/default/pods/kubernetes-bootcamp-6564dc5dfc-lxkjp/


./kubernetes-bins/kubectl run kubernetes-bootcamp --image=jocatalin/kubernetes-bootcamp:v1 --port=8080

kubectl set image deploy kubernetes-bootcamp kubernetes-bootcamp=jocatalin/kubernetes-bootcamp:v2

kubectl scale deploy kubernetes-bootcamp --replicas=2


kubectl rollout status deploy kubernetes-bootcamp

kubectl rollout undo deploy kubernetes-bootcamp


kubectl expose deploy nginx-deployment --type="NodePort" --target-port=80 --port=8088


kubectl expose deploy kubernetes-bootcamp --type="NodePort" --target-port=8080 --port=8088



export POD_NAME=$(./kubectl get pods -o go-template --template '{{range .items}}{{.metadata.name}}{{"\n"}}{{end}}')



calicoctl get workloadendpoint --workload=default.nginx-deployment-6c54bd5869-c2srk  -oyaml


cat <<EOF > /etc/sysctl.d/k8s.conf
net.bridge.bridge-nf-call-ip6tables = 1
net.bridge.bridge-nf-call-iptables = 1
net.bridge.bridge-nf-call-arptables = 1
EOF

sudo sysctl --system


/***** 主节点 *****/

BIN_PATH=/root/kubernetes-bins
NODE_IP=172.31.212.223 
ETCD_ENDPOINTS=http://172.31.212.192:2379
MASTER_IP=172.31.212.223


/***** node 1 *****/

BIN_PATH=/root/kubernetes-bins
NODE_IP=172.31.212.224 
ETCD_ENDPOINTS=http://172.31.212.192:2379
MASTER_IP=172.31.212.223



/***** node 2 *****/

BIN_PATH=/root/kubernetes-bins
NODE_IP=172.31.212.225 
ETCD_ENDPOINTS=http://172.31.212.192:2379
MASTER_IP=172.31.212.223






setenforce 0
sed -i 's/^SELINUX=enforcing$/SELINUX=permissive/' /etc/selinux/config


cat <<EOF >  /etc/sysctl.d/k8s.conf
net.bridge.bridge-nf-call-ip6tables = 1
net.bridge.bridge-nf-call-iptables = 1
EOF
sysctl --system


sudo systemctl disable firewalld.service
sudo systemctl stop firewalld.service

sudo systemctl disable iptables.service
sudo systemctl stop iptables.service


ip route add 10.68.0.0/16 dev docker0

