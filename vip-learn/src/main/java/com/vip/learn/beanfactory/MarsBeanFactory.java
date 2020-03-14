package com.vip.learn.beanfactory;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.AutowireCapableBeanFactory;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.GenericBeanDefinition;
import org.springframework.stereotype.Component;

@Component
public class MarsBeanFactory implements BeanFactoryPostProcessor {

    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
//        GenericBeanDefinition userService = (GenericBeanDefinition) beanFactory.getBeanDefinition("userService");
//        userService.setAutowireMode(AutowireCapableBeanFactory.AUTOWIRE_CONSTRUCTOR);
    }

}
