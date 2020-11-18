package com.huize.jvm.gc;

import java.lang.reflect.InvocationTargetException;

/**
 * 
 * -Xms10m -Xmx10m -XX:+PrintGC -XX:+PrintGCDetails
 *
 */
public class Example01 {
	
	public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException {
		byte[] bytes = new byte[5*1024*1204];
		bytes = null;
		byte[] bytes2 = new byte[5*1024*1204];
	}

}
