package com.huize.polaris.colletion.aspect;

import org.springframework.cglib.proxy.CallbackFilter;

import java.lang.reflect.Method;

public class PolarisCallbackFilter implements CallbackFilter {

    @Override
    public int accept(Method method) {
        String methodName = method.getName();
        if (methodName.equals("equals") || methodName.equals("toString")
                || methodName.equals("hashCode") || methodName.equals("clone")) {
            return 1;
        }
        return 0;
    }
}
