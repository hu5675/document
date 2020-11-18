package com.huize.jvm.java.example;

public class Example02 {
	public static void main(String[] args) {
		System.out.println(Cat.num);
	}
}
class Cat {
	public static Cat cat = new Cat();
	public static int num = 2;
	
	public Cat() {
		num++;
		System.out.println(num);
	}
}
