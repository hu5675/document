package com.huize.jvm.bytecode.example;

/**
 * 
 * javap -v com.huize.jvm.bytecode.example.Test
 *
 */
public class Example01 {

	public static void main(String[] args) {
		Test test = new Test();
		int result = test.add(5);
		System.out.println(result);
	}

}
