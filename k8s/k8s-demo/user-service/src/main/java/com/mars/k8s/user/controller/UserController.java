package com.mars.k8s.user.controller;

import com.mars.k8s.user.service.MessageService;
import com.mars.k8s.util.IPUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {

    @Resource
    private MessageService messageService;

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    @ResponseBody
    public List<String> getUserList() {
        List<String> result = new ArrayList<>();
        List<String> localIPList = IPUtils.getLocalIPList();
        for (String ip : localIPList) {
            result.add("user:" + ip);
        }

        List<String> messageList = messageService.getMessageList();
        result.addAll(messageList);
        return result;
    }
}
