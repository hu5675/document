package cherry.demo.main.user;

import cherry.config.PluginConfig;
import cherry.demo.api.UserService;
import cherry.demo.api.model.User;
import cherry.demo.main.annotation.MutiTenantMethod;
import cherry.demo.main.annotation.MutiTenantType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @Author Mars
 * @Date 2020/10/23 14:05
 * @Version 1.0
 */
@Component
@Primary
@MutiTenantType(value = "userService")
public class DefaultCustomerBean implements UserService {

    private static final Logger logger = LoggerFactory.getLogger(DefaultCustomerBean.class.getName());

    @Override
    @MutiTenantMethod
    public User getUser(String name) {
        logger.info("默认实现-客户调用逻辑");
        User user = new User();
        user.setAge(1111);
        return user;
    }

    @Override
    public List<User> getUsers() {
        return null;
    }

    @Override
    public int insert(User user) {
        return 0;
    }


    @Override
    public void init(PluginConfig config) {

    }

    @Override
    public void destroy() {

    }
}
