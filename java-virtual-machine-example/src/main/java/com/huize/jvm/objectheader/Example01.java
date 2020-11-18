package com.huize.jvm.objectheader;

import sun.misc.Unsafe;
import java.lang.reflect.Field;

import org.openjdk.jol.info.ClassLayout;

public class Example01 {
	private static Unsafe unsafe;
	// Ϊ��ֻ��ʾ�����λ�����ǲ�̫��ע����ͷǰ�����Ϣ��
	private static final long MOD = 3L;

	public static void main(String[] args) throws Exception {
		Field theUnsafe = Unsafe.class.getDeclaredField("theUnsafe");
		theUnsafe.setAccessible(true);
		unsafe = (Unsafe) theUnsafe.get(Unsafe.class);
		final Object o = new Object();
		System.out.println("   ��������ֻȡ����ͷ��Ϣ�������λ��");
		System.out.println("һ ���� : " + Long.toBinaryString(MOD & unsafe.getLong(o, 0L)));
		System.out.println("һ ���� : " + Long.toBinaryString(unsafe.getLong(o, 0L)));
		System.out.println(ClassLayout.parseInstance(o).toPrintable());
		lock(o);
	}

	public static void lock(final Object o) throws InterruptedException {
		// ������ ��һ����
		synchronized (o) {
			System.out.println("��������: " + Long.toBinaryString(MOD & unsafe.getLong(o, 0L)));
			System.out.println("�������� : " + Long.toBinaryString(unsafe.getLong(o, 0L)));
			System.out.println(ClassLayout.parseInstance(o).toPrintable());
			// ������
			syncObject(o, 100L);
			System.out.println("��������: " + Long.toBinaryString(MOD & unsafe.getLong(o, 0L)));
			System.out.println("�������� : " + Long.toBinaryString(unsafe.getLong(o, 0L)));
			System.out.println(ClassLayout.parseInstance(o).toPrintable());
		}
	}

	/**
	 * ObjectMonitor ������������ Thread.sleep(time);һ��Ҫ���������Ȼ����Main �߳���ִ�С����ܴ�ӡ���������ı��
	 *
	 * @param o
	 * @param time
	 * @throws InterruptedException
	 */
	public static void syncObject(final Object o, long time) throws InterruptedException {
		new Thread(new Runnable() {
			public void run() {
				synchronized (o) {
				}
			}
		}).start();
		// ��������߳�һ����ִ����
		Thread.sleep(time);
	}
}