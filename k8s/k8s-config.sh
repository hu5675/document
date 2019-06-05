sudo yum -y remove firewalld
sudo sed -i  's/SELINUX=enforcing/SELINUX=disabled/g' /etc/selinux/config
sudo sed -i "s/PasswordAuthentication no/PasswordAuthentication yes/g" /etc/ssh/sshd_config
sudo sed -i 's/.*swap.*/#&/' /etc/fstab

sudo setenforce 0
sudo swapoff -a


sudo cat >> /etc/yum.repos.d/kubernetes.repo <<EOF
[kubernetes]
name=Kubernetes
baseurl=https://mirrors.aliyun.com/kubernetes/yum/repos/kubernetes-el7-x86_64/
enabled=1
gpgcheck=0
EOF

sudo cat <<EOF >  /etc/sysctl.d/k8s.conf
net.bridge.bridge-nf-call-ip6tables = 1
net.bridge.bridge-nf-call-iptables = 1
vm.swappiness = 0
net.ipv4.ip_forward= 1
EOF

sudo echo "* soft nofile 65536" >> /etc/security/limits.conf
sudo echo "* hard nofile 65536" >> /etc/security/limits.conf
sudo echo "* soft nproc 65536"  >> /etc/security/limits.conf
sudo echo "* hard nproc 65536"  >> /etc/security/limits.conf
sudo echo "* soft  memlock  unlimited"  >> /etc/security/limits.conf
sudo echo "* hard memlock  unlimited"  >> /etc/security/limits.conf

sudo sysctl --system

