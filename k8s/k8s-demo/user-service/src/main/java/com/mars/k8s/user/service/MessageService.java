package com.mars.k8s.user.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@FeignClient(name = "message-service",url = "${message.service}")
//@FeignClient(name = "message-service")
public interface MessageService {

    @GetMapping("/message-service/message/list")
    List<String> getMessageList();
}
