package com.huize.polaris.colletion.annotation;

import com.huize.polaris.colletion.config.PloarisLogConfig;
import org.springframework.context.annotation.Import;

import java.lang.annotation.*;

@Documented
@Inherited
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Import(PloarisLogConfig.class)
public @interface EnablePloarisLog {


}
