package com.vip.learn.lifecycle;

import org.springframework.context.Lifecycle;
import org.springframework.context.LifecycleProcessor;
import org.springframework.context.support.DefaultLifecycleProcessor;
import org.springframework.stereotype.Component;

//@Component("lifecycleProcessor")
@Component
public class MarsLifeCycle implements Lifecycle {
	private volatile boolean running = false;


	@Override
	public void start() {
		System.out.println("mars start");
		running = true;
	}

	@Override
	public void stop() {
		System.out.println("mars stop");
		running = false;
	}

	@Override
	public boolean isRunning() {
		return running;
	}

//	@Override
	public void onRefresh() {
		System.out.println("mars onRefresh");
	}

//	@Override
	public void onClose() {
		System.out.println("mars onClose");
	}
}
