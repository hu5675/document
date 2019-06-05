sudo yum remove docker \
                  docker-client \
                  docker-client-latest \
                  docker-common \
                  docker-latest \
                  docker-latest-logrotate \
                  docker-logrotate \
                  docker-selinux \
                  docker-engine-selinux \
                  docker-engine

sudo rm -rf /etc/systemd/system/docker.service.d

sudo rm -rf /var/lib/docker

sudo  rm -rf /var/run/docker


sudo yum install -y yum-utils \
      device-mapper-persistent-data \
      lvm2

sudo yum-config-manager \
--add-repo \
https://download.docker.com/linux/centos/docker-ce.repo

sudo yum-config-manager --enable docker-ce-edge
sudo yum install docker-ce

# 查看docker 版本
sudo docker --version

#开启启动
sudo systemctl enable docker

# 启动docker
sudo systemctl start docker

#安装docker-compose
# sudo curl -L "https://github.com/docker/compose/releases/download/1.23.1/docker-compose-$(uname -s)-$(uname -m)" -o /usr/local/bin/docker-compose
# sudo chmod +x /usr/local/bin/docker-compose
# sudo docker-compose --version