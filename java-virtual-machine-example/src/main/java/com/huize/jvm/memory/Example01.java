package com.huize.jvm.memory;

import org.apache.lucene.util.RamUsageEstimator;
import org.openjdk.jol.info.ClassLayout;

import jdk.nashorn.internal.ir.debug.ObjectSizeCalculator;
import org.apache.spark.util.SizeEstimator;

public class Example01 {

	@SuppressWarnings("restriction")
	public static void main(String[] args) throws IllegalAccessException {
		//Integer a = new Integer(10);
		Test a = new Test();
		//Object a = new Object();
		// lucene的RamUsageEstimator
		System.out.println(RamUsageEstimator.shallowSizeOf(a));
		// jol的ClassLayout
		System.out.println(ClassLayout.parseInstance(a).instanceSize());
		// JDK8的ObjectSizeCalculator
		// System.out.println(ObjectSizeCalculator.getObjectSize(a));
		// spark的SizeEstimator
		// System.out.println(SizeEstimator.estimate(a));
		// 自己借助Unsafe实现
		System.out.println(MemoryUtil.shallowSizeOf(a));
		
		System.out.println(ClassLayout.parseInstance(a).toPrintable());

	}

}
