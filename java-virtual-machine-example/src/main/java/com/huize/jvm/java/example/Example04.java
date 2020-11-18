package com.huize.jvm.java.example;

public class Example04 {

	public static void main(String[] args) {
		int a = 10;
		func1(a);
		System.out.println(a);
		
		Dog dog = new Dog();
		dog.d = 10;
		func2(dog);
		System.out.println(dog.d);
		
		int b = 10;
		func3(b);
		System.out.println(b);
		
		int[] arr = {10, 20};
		func3(arr);
		System.out.println(arr[0]);
	}
	
	public static void func1(int a) {
		a++;
	}
	public static void func2(Dog dog) {
		dog.d++;
	}
	public static void func3(int ... a) {
		a[0]++;
	}

}
class Dog {
	public int d = 3;
	
	public Dog() {
	}
}
