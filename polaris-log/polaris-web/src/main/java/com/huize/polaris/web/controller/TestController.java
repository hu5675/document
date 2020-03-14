package com.huize.polaris.web.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
public class TestController {

    @GetMapping("/test")
    public String test(HttpServletRequest request, Integer age) {
        System.out.println(age);
        return age + "";
    }

    @GetMapping("/test2")
    public String test2(HttpServletRequest request, Integer age) {
        System.out.println("test2" + age);
        return age + "";
    }
}
