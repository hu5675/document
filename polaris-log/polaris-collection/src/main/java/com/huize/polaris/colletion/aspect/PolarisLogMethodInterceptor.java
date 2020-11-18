package com.huize.polaris.colletion.aspect;


import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;
import java.util.Map;

public class PolarisLogMethodInterceptor implements MethodInterceptor {

    //方法名-上报对象
    private Map<String, PolarisLogMethod> logMethodMap;

    public PolarisLogMethodInterceptor(Map<String, PolarisLogMethod> logMethodMap) {
        this.logMethodMap = logMethodMap;
    }


    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        try {
            String className = o.getClass().getSuperclass().getName();
            String methodName = method.getName();

            Object object = methodProxy.invokeSuper(o, objects);

            if (this.logMethodMap.keySet().contains(methodName)) {
                //TODO:上报逻辑,解析请求参数, 返参数，组装上报格式，调用数据中心日志组件上报
                PolarisLogMethod logMethod = this.logMethodMap.get(methodName);

                System.out.println(logMethod);
            }

            return object;

        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
    }

}
