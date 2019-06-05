package com.mars.k8s.user.edge.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@FeignClient(name = "user-service")
public interface UserService {

    @GetMapping("/user-service/user/list")
    List<String> getMessageList();
}
