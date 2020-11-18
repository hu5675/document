package cherry.demo.main;

import cherry.demo.api.UserService;
import cherry.demo.main.user.QixinCustomerBean;
import com.google.common.collect.Lists;
import com.huize.framework.catfish.agent.annotation.EnableCatfishAgent;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.stereotype.Component;

import java.lang.annotation.Annotation;
import java.util.ArrayList;

/**
 * @Author Mars
 * @Date 2020/10/23 13:52
 * @Version 1.0
 */
@SpringBootApplication
@EnableCatfishAgent
public class Application {


    public static void main(String[] args) {
        Component1 component = new Component1();
        Annotation annotation = component.getClass().getAnnotation(Component.class);

        ConfigurableApplicationContext applicationContext = SpringApplication.run(Application.class, args);

        UserService userService = (UserService) applicationContext.getBean(UserService.class);
        System.out.println(userService.getUser("1222"));


//        Component1 component1 = (Component1) applicationContext.getBean("component1");
//        component1.printUser();
//
//        DefaultListableBeanFactory defaultListableBeanFactory = (DefaultListableBeanFactory) ApplicationContextUtil.getApplicationContext().getAutowireCapableBeanFactory();
//        ArrayList<String> beanDefinitionNames = Lists.newArrayList(defaultListableBeanFactory.getBeanDefinitionNames());
//
//        Component1 c1 = (Component1) defaultListableBeanFactory.getSingleton("component1");
//
//        defaultListableBeanFactory.removeBeanDefinition("component1");
//
//        Component1 c2 = (Component1) defaultListableBeanFactory.getSingleton("component1");
//
//        //创建bean信息.
//        BeanDefinitionBuilder beanDefinitionBuilder = BeanDefinitionBuilder.genericBeanDefinition(QixinCustomerBean.class);
//
//        defaultListableBeanFactory.registerBeanDefinition("component1",beanDefinitionBuilder.getBeanDefinition());
//
//        QixinCustomerBean qixinCustomerBean = (QixinCustomerBean) applicationContext.getBean("component1");
//        System.out.println("QixinCustomerBean:" + qixinCustomerBean);
////
////        UserService userService = (UserService) applicationContext.getBean("userService");
////        userService.getUser("");
//
//

    }
}
