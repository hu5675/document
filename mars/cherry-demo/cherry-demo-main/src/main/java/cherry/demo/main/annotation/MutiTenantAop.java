package cherry.demo.main.annotation;

import cherry.demo.main.ApplicationContextUtil;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

/**
 * @Author Mars
 * @Date 2020/11/18 16:13
 * @Version 1.0
 */

@Component
@Aspect
public class MutiTenantAop {

    @Around("@annotation(cherry.demo.main.annotation.MutiTenantMethod)")
    public Object doAround(ProceedingJoinPoint pjp) throws Throwable {
        Object[] args = pjp.getArgs();

        Method method = ((MethodSignature) pjp.getSignature()).getMethod();

        Object object = ApplicationContextUtil.getApplicationContext().getBean("huizeCustomerBean");
        Method[] newMethods = object.getClass().getMethods();
        for (int index = 0; index < newMethods.length; index++) {
            if (newMethods[index].getName().equals(method.getName()) && newMethods[index].getParameters().length == args.length) {
                Object result = newMethods[index].invoke(object, args);
                return result;
            }
        }

        Object obj = pjp.proceed(args);
        return obj;
    }
}
