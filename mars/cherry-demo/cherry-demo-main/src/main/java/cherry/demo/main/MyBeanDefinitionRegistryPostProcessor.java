package cherry.demo.main;

import cherry.DefaultPluginFactory;
import cherry.Plugin;
import cherry.PluginFactory;
import com.huize.framework.catfish.agent.annotation.CatfishRemote;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.BeanDefinitionRegistryPostProcessor;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.context.annotation.Configuration;

import java.lang.annotation.Annotation;
import java.lang.reflect.AnnotatedElement;
import java.util.List;

/**
 * @Author Mars
 * @Date 2020/10/23 14:01
 * @Version 1.0
 */
@Configuration
public class MyBeanDefinitionRegistryPostProcessor implements BeanDefinitionRegistryPostProcessor, InitializingBean {

    private PluginFactory pluginFactory;

    @Override
    public void postProcessBeanDefinitionRegistry(BeanDefinitionRegistry registry) throws BeansException {
        System.out.println("postProcessBeanDefinitionRegistry");
        List<String> pluginNames = pluginFactory.getPluginNames();
        for (String pluginName : pluginNames) {
            Plugin plugin = pluginFactory.getPlugin(pluginName);
            System.out.println(plugin.getClass());
            RootBeanDefinition rootBeanDefinition = new RootBeanDefinition(plugin.getClass());

            rootBeanDefinition.setQualifiedElement(new AnnotatedElement() {
                @Override
                public <T extends Annotation> T getAnnotation(Class<T> annotationClass) {
                    return (T) annotationClass.getAnnotation(CatfishRemote.class);
                }

                @Override
                public Annotation[] getAnnotations() {
                    return new Annotation[0];
                }

                @Override
                public Annotation[] getDeclaredAnnotations() {
                    return new Annotation[0];
                }
            });

            registry.registerBeanDefinition(pluginName, rootBeanDefinition);
        }
    }

    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory configurableListableBeanFactory) throws BeansException {
        System.out.println("postProcessBeanFactory");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        pluginFactory = new DefaultPluginFactory("classpath:plugins.xml");
    }
}
