package com.vip.learn.facade;

import com.vip.learn.service.CityService;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.Map;

@Component
public class CityFacadeImpl {

    @Resource
    private Map<String, CityService> cityServiceMap;

    public void query(){
        System.out.println(cityServiceMap);
    }
}
