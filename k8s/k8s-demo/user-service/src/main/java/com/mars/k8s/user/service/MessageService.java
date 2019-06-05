package com.mars.k8s.user.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@FeignClient(name = "mars-message-service")
public interface MessageService {

    @GetMapping("/message-service/message/list")
    List<String> getMessageList();
}
