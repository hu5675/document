package com.vip.learn.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

@Component
public class UserService {

//    @Resource
    private OrderService orderService;

//    @Resource
    public void setXXXXXXX(OrderService orderService) {
        System.out.println("22222222222:" + orderService);
        this.orderService = orderService;
    }
//
//    public UserService(OrderService orderService) {
//        System.out.println("11111111111111:" + orderService);
//    }


    public void query() {
        System.out.println("3333333333:" + orderService);
    }
}
