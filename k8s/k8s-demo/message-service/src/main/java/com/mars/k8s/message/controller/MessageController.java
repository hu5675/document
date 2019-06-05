package com.mars.k8s.message.controller;

import com.mars.k8s.util.IPUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/message")
public class MessageController {

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    @ResponseBody
    public List<String> getMessageList() {
        List<String> result = new ArrayList<>();
        List<String> localIPList = IPUtils.getLocalIPList();
        for (String ip : localIPList) {
            result.add("message:" + ip);
        }
        return result;
    }
}
