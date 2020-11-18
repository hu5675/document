package com.vip.learn;

import com.vip.learn.config.AppConfig;
import com.vip.learn.facade.CityFacadeImpl;
import com.vip.learn.service.CityService;
import com.vip.learn.service.OrderService;
import com.vip.learn.service.UserService;
import lombok.val;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

//@SpringBootApplication


public class VipLearnApplication {

    public static void main(String[] args) {
//        SpringApplication.run(VipLearnApplication.class, args);

//
//        Log log = LogFactory.getLog("jcl");
//        log.info("12");

		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

        UserService userService = context.getBean(UserService.class);

        userService.query();
//        context.getBean(CityService.class).query();
//
//        context.getBean(CityService.class).query();

//        context.getBean(CityFacadeImpl.class).query();

//        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
////		context.register(AppConfig.class);
//		context.register(ApolloApplicationContextInitializer.class);
//
////        context.refresh();
//        CityService citySerivice = context.getBean(CityService.class);

//		context.registerShutdownHook();

//		Runtime.getRuntime().addShutdownHook(new Thread(){
//			@Override
//			public void run() {
//				System.out.println("this is hook demo start");
//				// TODO
//				try {
//					Thread.sleep(10000);
//				} catch (InterruptedException e) {
//					e.printStackTrace();
//				}
//				System.out.println("this is hook demo finish");
//			}
//		});

//		System.out.println(citySerivice);

//        citySerivice.query();

//		context.start();
//		context.stop();
    }

}
