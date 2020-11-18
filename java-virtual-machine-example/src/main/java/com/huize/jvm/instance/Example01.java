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
		System.out.println("��ֵǰ��" + unsafeA);
		// �õ�һ�������ڲ����Եĵ�ַ
        long offset = unsafe.objectFieldOffset(A.class.getDeclaredField("a"));
        // ֱ�Ӹ������Ը�ֵ
        unsafe.getAndSetInt(unsafeA, offset, 30);
        System.out.println("��ֵ��" + unsafeA);
		B unsafeB = (B) unsafe.allocateInstance(B.class);
		System.out.println(unsafeB);
		
		
		// ���ļ�object.txt�ж�ȡ����
        FileInputStream fis = new FileInputStream("object.txt");
        ObjectInputStream ois = new ObjectInputStream(fis);

        // ͨ�������л��ָ�����obj
        A readA = (A)ois.readObject();
        ois.close();
        System.out.println(readA);
        
	}
	
	
	public static void writeObject() throws IOException {
		A newA = new A();
        // �����л�����д���ļ�object.txt��
        FileOutputStream fos = new FileOutputStream("object.txt");
        ObjectOutputStream os = new ObjectOutputStream(fos);
        os.writeObject(newA);
        os.close();
	}

}
