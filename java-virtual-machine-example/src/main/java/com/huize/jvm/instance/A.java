package com.huize.jvm.instance;

import java.io.Serializable;

public class A implements Cloneable, Serializable{
	
	private int a = 10;
	
	public A() {
	}

	public int getA() {
		return a;
	}

	public void setA(int a) {
		this.a = a;
	}

	@Override
	public String toString() {
		return "A [a=" + a + "]";
	}
	
	protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
