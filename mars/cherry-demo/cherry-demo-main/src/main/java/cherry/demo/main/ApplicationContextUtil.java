package cherry.demo.main;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;
import org.springframework.web.context.WebApplicationContext;

/**
 * @Author Mars
 * @Date 2020/11/18 10:04
 * @Version 1.0
 */
@Component
public class ApplicationContextUtil implements ApplicationContextAware {

    /**
     * Spring应用上下文环境
     */
    private static WebApplicationContext applicationContext;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        ApplicationContextUtil.applicationContext = (WebApplicationContext) applicationContext;
    }

    /**
     * 获取上下文对象
     *
     * @return
     */
    public static WebApplicationContext getApplicationContext() {
        return applicationContext;
    }
}
