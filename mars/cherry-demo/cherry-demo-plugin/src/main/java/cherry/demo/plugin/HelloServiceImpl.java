package cherry.demo.plugin;

import cherry.config.PluginConfig;
import cherry.demo.api.HelloService;
import com.huize.framework.catfish.agent.annotation.CatfishRemote;
import org.springframework.stereotype.Component;

/**
 * ${DESCRIPTION}
 *
 * @author Ricky Fung
 */
@CatfishRemote
@Component
public class HelloServiceImpl implements HelloService {
    private PluginConfig config;

    @Override
    public String echo(String msg) {
        System.out.println("echo [" + msg + "]");
        this.config.getPluginContext().setAttribute("echo", msg);
        return "echo [" + msg + "]";
    }

    @Override
    public void hello(String msg) {
        System.out.println("hello "+msg);
        System.out.println("encoding="+config.getInitParameter("encoding"));
        this.config.getPluginContext().setAttribute("hello", msg);
        System.out.println("attr:"+this.config.getPluginContext().getAttribute("hello"));
    }

    @Override
    public void init(PluginConfig config) {
        this.config = config;
        System.out.println("HelloServiceImpl init...");
    }

    @Override
    public void destroy() {
        System.out.println("HelloServiceImpl destroy...");
    }
}
