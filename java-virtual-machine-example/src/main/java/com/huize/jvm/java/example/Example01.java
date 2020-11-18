package com.huize.jvm.java.example;

public class Example01 {
	public static void main(String[] args) {
		Car car = new Benz();
	}
}
class Car {
	private String name = "car";
	public Car() {
		call();
	}
	public void call() {
		System.out.println(name);
	}
}
class Benz extends Car{
	private String name = "benz";
	@Override
	public void call() {
		System.out.println(name);
	}
}
