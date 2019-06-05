package com.mars.k8s.user.edge;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
public class UserEdgeServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(UserEdgeServiceApplication.class, args);
    }

}
