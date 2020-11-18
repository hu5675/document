package cherry.demo.main;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;

/**
 * @Author Mars
 * @Date 2020/10/23 14:05
 * @Version 1.0
 */
@Component
public class Component2 implements InitializingBean {
    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("Component2");

    }
}
