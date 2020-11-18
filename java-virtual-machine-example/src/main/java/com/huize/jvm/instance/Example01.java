package com.huize.jvm.instance;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

import sun.misc.Unsafe;

public class Example01 {
	
	static {
		try {
			writeObject();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException, CloneNotSupportedException, NoSuchFieldException, IOException {
		A newA = new A();
		System.out.println(newA);
		B newB = new B(20);
		System.out.println(newB);
		
		Class<?> klassA = Class.forName("com.huize.jvm.instance.A");
		A classA = (A) klassA.newInstance();
		System.out.println(classA);
		Class<?> klassB = Thread.currentThread().getContextClassLoader().loadClass("com.huize.jvm.instance.B");
		Constructor<B> constructor = (Constructor<B>) klassB.getConstructor(int.class);
		B classB = constructor.newInstance(20);
		System.out.println(classB);
		
		A cloneA = (A) newA.clone();
		System.out.println(cloneA);
		B cloneB = (B) newB.clone();
		System.out.println(cloneB);
		
		Field f = Unsafe.class.getDeclaredField("theUnsafe");
		f.setAccessible(true);
		Unsafe unsafe = (Unsafe) f.get(null);
		A unsafeA = (A) unsafe.allocateInstance(A.class);
		System.out.println("赋值前：" + unsafeA);
		// 得到一个对象内部属性的地址
        long offset = unsafe.objectFieldOffset(A.class.getDeclaredField("a"));
        // 直接给此属性赋值
        unsafe.getAndSetInt(unsafeA, offset, 30);
        System.out.println("赋值后：" + unsafeA);
		B unsafeB = (B) unsafe.allocateInstance(B.class);
		System.out.println(unsafeB);
		
		
		// 从文件object.txt中读取数据
        FileInputStream fis = new FileInputStream("object.txt");
        ObjectInputStream ois = new ObjectInputStream(fis);

        // 通过反序列化恢复对象obj
        A readA = (A)ois.readObject();
        ois.close();
        System.out.println(readA);
        
	}
	
	
	public static void writeObject() throws IOException {
		A newA = new A();
        // 将序列化对象写入文件object.txt中
        FileOutputStream fos = new FileOutputStream("object.txt");
        ObjectOutputStream os = new ObjectOutputStream(fos);
        os.writeObject(newA);
        os.close();
	}

}
