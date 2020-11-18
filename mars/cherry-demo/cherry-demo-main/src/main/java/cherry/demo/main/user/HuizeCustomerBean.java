package cherry.demo.main.user;

import cherry.config.PluginConfig;
import cherry.demo.api.UserService;
import cherry.demo.api.model.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @Author Mars
 * @Date 2020/10/23 14:05
 * @Version 1.0
 */
@Component
public class HuizeCustomerBean implements UserService {

    private static final Logger logger = LoggerFactory.getLogger(HuizeCustomerBean.class.getName());

    @Override
    public User getUser(String name) {
        logger.info("慧择-客户调用逻辑");
        return null;
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
