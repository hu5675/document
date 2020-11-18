package com.huize.jvm.java.example;

public class Example03 {

	public void sayHello(Human human) {
		System.out.println("hello, human!");
	}

	public void sayHello(Boy boy) {
		System.out.println("hello, boy!");
	}

	public void sayHello(Baby baby) {
		System.out.println("hello, baby!");
	}

	public static void main(String[] args) {
		Human boy = new Boy();
		Human baby = new Baby();
		Example03 example03 = new Example03();
		example03.sayHello(boy);
		example03.sayHello(baby);
	}
}
class Human {
}
class Boy extends Human{
}
class Baby extends Boy{
}
