package com.huize.jvm.objectheader;

import sun.misc.Unsafe;
import java.lang.reflect.Field;

import org.openjdk.jol.info.ClassLayout;

public class Example01 {
	private static Unsafe unsafe;
	// 为了只显示最后两位。我们不太关注对象头前面的信息。
	private static final long MOD = 3L;

	public static void main(String[] args) throws Exception {
		Field theUnsafe = Unsafe.class.getDeclaredField("theUnsafe");
		theUnsafe.setAccessible(true);
		unsafe = (Unsafe) theUnsafe.get(Unsafe.class);
		final Object o = new Object();
		System.out.println("   这里我们只取对象头信息的锁标记位！");
		System.out.println("一 无锁 : " + Long.toBinaryString(MOD & unsafe.getLong(o, 0L)));
		System.out.println("一 无锁 : " + Long.toBinaryString(unsafe.getLong(o, 0L)));
		System.out.println(ClassLayout.parseInstance(o).toPrintable());
		lock(o);
	}

	public static void lock(final Object o) throws InterruptedException {
		// 轻量锁 第一次锁
		synchronized (o) {
			System.out.println("二轻量锁: " + Long.toBinaryString(MOD & unsafe.getLong(o, 0L)));
			System.out.println("二轻量锁 : " + Long.toBinaryString(unsafe.getLong(o, 0L)));
			System.out.println(ClassLayout.parseInstance(o).toPrintable());
			// 锁膨胀
			syncObject(o, 100L);
			System.out.println("三重量锁: " + Long.toBinaryString(MOD & unsafe.getLong(o, 0L)));
			System.out.println("三重量锁 : " + Long.toBinaryString(unsafe.getLong(o, 0L)));
			System.out.println(ClassLayout.parseInstance(o).toPrintable());
		}
	}

	/**
	 * ObjectMonitor 让锁发生膨胀 Thread.sleep(time);一定要有这个，不然可能Main 线程先执行。不能打印出重量锁的标记
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
		// 让上面的线程一定先执行完
		Thread.sleep(time);
	}
}