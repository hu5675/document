package com.huize.jvm.instance;

public class B implements Cloneable{
	
	private int b = 10;
	
	public B(int b) {
		this.b = b;
	}

	@Override
	public String toString() {
		return "B [b=" + b + "]";
	}
	
	protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

}
