package com.huize.jvm.objectheader;

import java.lang.reflect.Field;

import org.openjdk.jol.info.ClassLayout;
import org.openjdk.jol.vm.VM;

import sun.misc.Unsafe;

/**
 * 
 * -XX:+UseCompressedOops -XX:+UseCompressedClassPointers
 *
 */
public class Example02 {
	
	private static int a = 6;
	
	private static int c = 400;
	
	private static final long MOD = 3L;
	
	private static Object o = new Object();
	
	private int b = 6;

	public static void main(String[] args) throws Throwable {
		Example02 example02 = new Example02();
		
		System.out.println(ClassLayout.parseInstance(example02).toPrintable());
		int hashCode = example02.hashCode();
		System.out.println("10����hashCode��" + hashCode);
		System.out.println("16����hashCode��" + Integer.toHexString(hashCode));
		System.out.println(ClassLayout.parseInstance(example02).toPrintable());
		
		Field theUnsafe = Unsafe.class.getDeclaredField("theUnsafe");
		theUnsafe.setAccessible(true);
		Unsafe unsafe = (Unsafe) theUnsafe.get(Unsafe.class);
		System.out.println("2���ƶ���ͷ��" + Long.toBinaryString(unsafe.getLong(example02, 0L)));
		System.out.println("16���ƶ���ͷ��" + Long.toHexString(unsafe.getLong(example02, 0L)));
		System.out.println("��״̬: " + Long.toBinaryString(MOD & unsafe.getLong(example02, 0L)));
		long bOffset = unsafe.objectFieldOffset(Example02.class.getDeclaredField("b"));
		System.out.println("example02.b��ƫ�ƴ�С:" + bOffset);
		System.out.println("example02.b:" + unsafe.getInt(example02, bOffset));
	
		Class clazz = Example02.class;
		System.out.println(ClassLayout.parseInstance(clazz).toPrintable());
		
		long aOffset = unsafe.staticFieldOffset(Example02.class.getDeclaredField("a"));
		System.out.println("Example02.a��ƫ�ƴ�С:" + aOffset);
		System.out.println("Example02.a:" + unsafe.getInt(clazz, aOffset));
		
		long cOffset = unsafe.staticFieldOffset(Example02.class.getDeclaredField("c"));
		System.out.println("Example02.c��ƫ�ƴ�С:" + cOffset);
		System.out.println("Example02.c:" + unsafe.getInt(clazz, cOffset));
		
		long oOffset = unsafe.staticFieldOffset(Example02.class.getDeclaredField("o"));
		System.out.println("Example02.o��ƫ�ƴ�С:" + oOffset);
		System.out.println("Example02.o:" + Long.toHexString(unsafe.getLong(clazz, oOffset)));
		
		System.out.println("Example02.o�ĵ�ַ:" + getAddresses(unsafe, o));
		System.out.println("Example02.o�ĵ�ַ:" + Long.toHexString(VM.current().addressOf(o)));
	
	}
	
	public static String getAddresses(Unsafe unsafe, Object object) {  
        String address = "";  
        // sun.arch.data.model=32 // 32 bit JVM  
        // sun.arch.data.model=64 // 64 bit JVM  
        Object[] objects = new Object[] {object};
        boolean is64bit = Integer.parseInt(System.getProperty("sun.arch.data.model")) == 32 ? false : true;  
        int offset = unsafe.arrayBaseOffset(objects.getClass());  
        int scale = unsafe.arrayIndexScale(objects.getClass());  
        switch (scale)  {  
            case 4:  
                long factor = is64bit ? 8 : 1;  
                // ���ָ���ַ  
                address = Long.toHexString((unsafe.getInt(objects, offset) & 0xFFFFFFFFL) * factor);  
                break;  
            case 8:
            	address = Long.toHexString(unsafe.getLong(objects, offset));
            	break;
            default:
            	throw new Error("unsupported address size: " + scale);

        }  
        return address;  
    }  

}
