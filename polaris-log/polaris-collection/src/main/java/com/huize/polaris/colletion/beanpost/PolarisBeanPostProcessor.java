package com.huize.polaris.colletion.beanpost;

import com.huize.polaris.colletion.aspect.PolarisCallbackFilter;
import com.huize.polaris.colletion.aspect.PolarisLogMethod;
import com.huize.polaris.colletion.aspect.PolarisLogMethodInterceptor;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.cglib.proxy.Callback;
import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.NoOp;

import java.util.Map;

public class PolarisBeanPostProcessor implements BeanPostProcessor {

    //拦截接口包
    private String basePackage;

    //方法名-上报对象
    private Map<String, PolarisLogMethod> logMethodMap;

    public PolarisBeanPostProcessor(String basePackage, Map<String, PolarisLogMethod> logMethodMap) {
        this.basePackage = basePackage;
        this.logMethodMap = logMethodMap;
    }


    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        if (bean != null && bean.getClass().getPackage().toString().contains(basePackage)) {
            Enhancer enhancer = new Enhancer();
            enhancer.setSuperclass(bean.getClass());
            enhancer.setCallbacks(new Callback[]{new PolarisLogMethodInterceptor(this.logMethodMap), NoOp.INSTANCE});
            enhancer.setCallbackFilter(new PolarisCallbackFilter());

            return enhancer.create();
        }
        return bean;
    }
}
