package com.mars.k8s.user.controller;

import com.mars.k8s.util.IPUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    @ResponseBody
    public List<String> getUserList() {
        return IPUtils.getLocalIPList();
    }
}
