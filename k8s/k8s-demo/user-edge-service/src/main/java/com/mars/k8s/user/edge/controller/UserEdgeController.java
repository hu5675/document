package com.mars.k8s.user.edge.controller;

import com.mars.k8s.user.edge.service.UserService;
import com.mars.k8s.util.IPUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/user-edge")
public class UserEdgeController {

    @Resource
    private UserService userService;

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    @ResponseBody
    public List<String> getUserList() {
        List<String> result = new ArrayList<>();
        List<String> localIPList = IPUtils.getLocalIPList();
        for (String ip : localIPList) {
            result.add("user-edge:" + ip);
        }

        List<String> userList = userService.getMessageList();
        result.addAll(userList);
        return result;
    }
}
