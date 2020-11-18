package com.huize.polaris.colletion.config;

import com.huize.polaris.colletion.aspect.PolarisLogMethod;
import com.huize.polaris.colletion.beanpost.PolarisBeanPostProcessor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.json.JacksonJsonParser;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
@PropertySource(value = {"classpath:polaris_log.properties"}, encoding = "utf-8")
@ConfigurationProperties(prefix = "polaris")
@Slf4j
public class PloarisLogConfig {

    /**
     * 拦截接口包
     */
    @Value("${polaris.basePackage:testPackage}")
    private String basePackage;

    /**
     * 方法对应关系
     */
    private Map<String, String> methods = new HashMap<>();

    /**
     * 方法名-上报对象
     */
    private Map<String, PolarisLogMethod> logMethodMap = new HashMap<>();

    public void setMethods(Map<String, String> methods) {
        this.methods = methods;
        if ("testPackage".equals(this.basePackage)) {
            log.info("请配置polaris.basePackage,接口扫描包路径!!!!!");
            System.exit(-10000);
        }
        for (String methodName : this.methods.keySet()) {
            String methodValue = this.methods.get(methodName);
            Map<String, Object> parseMap = new JacksonJsonParser().parseMap(methodValue);
            PolarisLogMethod logMethod = new PolarisLogMethod();
            try {
                logMethod.setMark(parseMap.get("mark").toString());
                logMethod.setPlatform(Integer.valueOf(parseMap.get("platform").toString()));
                logMethod.setClientType(Integer.valueOf(parseMap.get("clientType").toString()));
                logMethod.setReportPoint(methodName);
                //TODO: 这里增加解析 数据报文格式

                logMethodMap.put(methodName, logMethod);
            } catch (Exception ex) {
                log.info("polaris_log.properties配置文件不正确,请检查!!!!!!");
                System.exit(-20000);
            }
        }
    }

    @Bean
    PolarisBeanPostProcessor polarisBeanPostProcessor() {
        return new PolarisBeanPostProcessor(basePackage, this.logMethodMap);
    }


    @Bean
    PolarisLogMethod polarisLogMethod() {
        return new PolarisLogMethod();
    }


}
