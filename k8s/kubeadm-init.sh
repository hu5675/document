kubeadm init --kubernetes-version=v1.14.1 --pod-network-cidr=10.244.0.0/16 --service-cidr=10.96.0.0/12 --ignore-preflight-errors=Swap 

mkdir -p $HOME/.kube
sudo cp -i /etc/kubernetes/admin.conf $HOME/.kube/config
sudo chown $(id -u):$(id -g) $HOME/.kube/config


kubectl -n kube-system describe $(kubectl -n kube-system get secret -n kube-system -o name | grep namespace) | grep token


 docker ps -a | grep 'Exited' | awk '{print $1}' | xargs docker rm


 docker run -d -v /home/it/mars/jenkins_home:/var/jenkins_home -v /home/it/mars/apache-maven-3.6.1:/usr/local/maven -p 8080:8080 -p 50000:50000 jenkins/jenkins