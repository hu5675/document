package com.mars.k8s.user.controller;

import com.mars.k8s.user.service.MessageService;
import com.mars.k8s.user.utils.CacheManager;
import com.mars.k8s.util.IPUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.time.temporal.TemporalField;
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


    @RequestMapping(value = "/cache_request", method = RequestMethod.GET)
    @ResponseBody
    public List<String> cacheRequest(HttpServletRequest request) throws InterruptedException {
        Long milliSecond = LocalDateTime.now().toInstant(ZoneOffset.of("+8")).toEpochMilli();
        CacheManager.requestHashMap.put(milliSecond,request);
        Thread.sleep(2000);
        return new ArrayList<>();
    }
}
