package com.vip.learn.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
@Aspect
public class AopAspect {

	@PostConstruct
	public void init(){
		System.out.println(222222222);
	}

	@Pointcut("execution(* com.vip.learn.service.*.*(..))")
	public void pointcut(){

	}

	@Before("pointcut()")
	public void advice(JoinPoint joinPoint){
		System.out.println("aop before ---- log");
	}
}
