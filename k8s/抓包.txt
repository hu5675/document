我抓包看了  

主机（node1: 172.31.212.224)  容器 container1 ip： 172.20.38.64 

主机（node2： 172.31.212.225)  容器 container2 ip： 172.20.160.192

在 container1 中 ping 通  172.31.212.225  ping 不通  container2 （172.20.160.192）


container1  ping container2 时   主机node2  没收到请求  



/sbin/iptables -t nat -I POSTROUTING -s 172.20.0.0/16 -j MASQUERADE

/sbin/iptables -t nat -I POSTROUTING -s 172.20.0.0/16 -j MASQUERADE