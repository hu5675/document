package cherry.demo.main;

import cherry.demo.api.UserService;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * @Author Mars
 * @Date 2020/10/23 14:05
 * @Version 1.0
 */
@Component
public class Component1 implements InitializingBean {

    @Resource
    private UserService userService;

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("Component1");
    }

    public void printUser() {
        System.out.println(userService.getUser("printUser"));
    }
}
