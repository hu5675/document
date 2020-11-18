package com.huize.jvm.monitor;

import java.io.IOException;
import java.lang.reflect.Field;

import sun.misc.Unsafe;

/**
 * 
 * -XX:+UseSerialGC -Xmx10m -XX:InitialCodeCacheSize=20m -XX:MetaspaceSize=5m -XX:+PrintCodeCache
 *
 */
public class Main {
	
	public static void main(String[] args) throws Throwable {
		int c = 200;
		String s = "abc";
		Test test = new Test(8888);
		int result = add(c);
	}
	
	public static int add(int num) throws IOException {
		Main man = new Main();
		int result = man.increase(num);
		return result;
	}
	
	public int increase(int num) throws IOException {
		int result = num + 1;
		System.in.read();
		return result;
	}
}