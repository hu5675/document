package cherry.demo.main.annotation;

import java.lang.annotation.*;

@Documented
@Inherited
@Target(value = {ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface MutiTenantType {

    String value() default "";
}
