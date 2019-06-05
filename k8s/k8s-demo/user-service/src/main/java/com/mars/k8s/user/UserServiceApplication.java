package com.mars.k8s.user;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class UserServiceApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext applicationContext = SpringApplication.run(UserServiceApplication.class, args);
		Object userController = applicationContext.getBean("userController");
		System.out.println(userController);
	}

}
