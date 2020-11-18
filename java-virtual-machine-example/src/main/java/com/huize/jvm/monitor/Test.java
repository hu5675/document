package com.huize.jvm.monitor;

public class Test {
	public static int staticInt = 1000;
	private int instanceInt;
	private String instanceString = "abcd";

	public Test(int instanceInt) {
		this.instanceInt = instanceInt;
	}

	public int getInstanceInt() {
		return instanceInt;
	}
}