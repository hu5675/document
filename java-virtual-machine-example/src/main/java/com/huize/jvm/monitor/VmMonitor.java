package com.huize.jvm.monitor;

import java.util.List;

import org.openjdk.jol.info.ClassLayout;

import sun.jvm.hotspot.code.CodeBlob;
import sun.jvm.hotspot.code.CodeCacheVisitor;
import sun.jvm.hotspot.debugger.Address;
import sun.jvm.hotspot.debugger.OopHandle;
import sun.jvm.hotspot.interpreter.OopMapCacheEntry;
import sun.jvm.hotspot.memory.StringTable;
import sun.jvm.hotspot.memory.StringTable.StringVisitor;
import sun.jvm.hotspot.memory.SymbolTable;
import sun.jvm.hotspot.memory.SymbolTable.SymbolVisitor;
import sun.jvm.hotspot.oops.*;
import sun.jvm.hotspot.runtime.JavaThread;
import sun.jvm.hotspot.runtime.JavaVFrame;
import sun.jvm.hotspot.runtime.StackValueCollection;
import sun.jvm.hotspot.runtime.Threads;
import sun.jvm.hotspot.runtime.VM;
import sun.jvm.hotspot.tools.Tool;
import sun.jvm.hotspot.utilities.MethodArray;

public class VmMonitor extends Tool {

	public static void main(String[] args) throws Exception {
		VmMonitor kk = new VmMonitor();
		kk.execute(args);
	}

	@SuppressWarnings({ "unchecked", "unused" })
	@Override
    public void run() {
        VM vm = VM.getVM();
        vm.getCodeCache().iterate(new CodeCacheVisitor() {
			public void visit(CodeBlob codeBlob) {
			}
			public void prologue(Address startAddress, Address endAddress) {
				System.out.println("CodeCache开始地址：" + startAddress);
	        	System.out.println("CodeCache结束地址：" + endAddress);
			}
			public void epilogue() {
			}
		});
        Threads threads = VM.getVM().getThreads();
        JavaThread cur = threads.first();
        while(cur != null) {
        	String threadName = cur.getThreadName();
        	String threadId = cur.getAddress().toString();
        	String threadCode = threadName + "@" + threadId;
        	String startAddress = cur.getAddress().toString();
        	long stackSize = cur.getStackSize();
        	String endAddress = cur.getAddress().addOffsetTo(cur.getStackSize()).toString();
        	System.out.println("############### 虚拟机栈" + threadCode + "开始  ##############");
        	System.out.println("线程栈开始地址：" + startAddress);
        	System.out.println("线程栈结束地址：" + endAddress);
        	System.out.println("线程栈大小：" + stackSize);
        	if("main".equals(threadName)) {
				for (JavaVFrame vf = cur.getLastJavaVFrameDbg(); vf != null; vf = vf.javaSender()) {
					String methodName = vf.getFrame().getInterpreterFrameMethod().getName().asString();
					if("main".equals(methodName) || "add".equals(methodName) || "increase".equals(methodName)) {
						System.out.println("############### 栈帧" + methodName + "开始  ##############");
						StackValueCollection collection = vf.getLocals();
						System.out.println("局部变量个数：" + collection.size());
						for(int j = 0; j < collection.size(); j++) {
							if(collection.get(j).getType() == 12) {
								OopHandle handle = collection.get(j).getObject();
								ObjectHeap objectHeap = VM.getVM().getObjectHeap();
								Oop oop = objectHeap.newOop(handle);
								if(oop != null) {
									oop.iterate(new OopPrinter(System.out), true);
								}
							} else {
								collection.get(j).printOn(System.out);
								System.out.println();
							}
						}
						System.out.println("############### 栈帧" + methodName + "结束  ##############");
					}
				}
				System.out.println("############### 虚拟机栈" + threadCode + "结束  ##############");
        	}
        	cur = cur.next();
        }
        
        System.out.println("############### StringTable开始  ##############");
        StringTable stringTable = vm.getStringTable();
        System.out.println(vm.getStringTable().getAddress().toString());
        stringTable.stringsDo(new StringVisitor() {
			public void visit(Instance instance) {
				String value = OopUtilities.stringOopToString(instance);
				if("abc".equals(value) || "abcd".equals(value)) {
					System.out.println("\"" + OopUtilities.stringOopToString(instance) + "\" @" + instance.getHandle().toString());
					instance.iterate(new OopPrinter(System.out), true);
				}
				// instance.iterate(new OopPrinter(System.out), true);
			}
		});
        System.out.println("############### StringTable结束  ##############");
        System.out.println("############### SymbolTable开始  ##############");
        SymbolTable symbolTable = vm.getSymbolTable();
        System.out.println(vm.getSymbolTable().getAddress().toString());
        /*
        symbolTable.symbolsDo(new SymbolVisitor() {
			@Override
			public void visit(Symbol symbol) {
				symbol.printValueOn(System.out);
				System.out.println("@" + symbol.getAddress().toString());
			}
		});
		*/
        System.out.println("############### SymbolTable结束  ##############");
        System.out.println("############### JVM堆空间分布开始  ##############");
        vm.getUniverse().print();
        System.out.println("############### JVM堆空间分布结束 ##############");
        final ObjectHeap objectHeap = vm.getObjectHeap();
        objectHeap.iterate(new HeapVisitor() {
            @Override
            public void prologue(long l) {
            }
            @Override
            public boolean doObj(Oop oop) {
                System.out.println("############### Oop部分信息开始  ##############");
                oop.iterate(new OopPrinter(System.out), true);
                System.out.println("Oop实例大小: " + oop.getObjectSize() + "byte");
                System.out.println("############### Oop部分信息结束  ##############");
                System.out.println("############### Klass部分信息开始  ##############");
                Klass klass = oop.getKlass();
                System.out.println("Oop.Klass for " + klass);
                System.out.println("Oop.Klass.JavaMirror for " + klass.getJavaMirror());
                if(klass instanceof InstanceKlass) {
                	InstanceKlass instanceKlass = (InstanceKlass)klass;
                	System.out.println("Oop.Klass.size:" + instanceKlass.getSize());
					List<Object> list = instanceKlass.getAllFields();
                	System.out.println("属性：");
                	for(Object field : list) {
                		if(field instanceof IntField) {
                			IntField intField = (IntField)field;
                			if(intField.isStatic()) {
                				System.out.println(intField.getID().getName() + ":" + intField.getValue(klass.getJavaMirror()));
                			} else {
                				System.out.println(intField.getID().getName() + ":" + intField.getValue(oop));
                			}
                		}else if(field instanceof NarrowOopField) {
                			NarrowOopField narrowOopField = (NarrowOopField)field;
                			System.out.println(narrowOopField.getID().getName() + ":" + narrowOopField.getValue(oop));
                		}
                	}
                	MethodArray methodArray = instanceKlass.getMethods();
                	System.out.println("方法：");
                	for(int i = 0; i < methodArray.getLength(); i++) {
                		Method method = methodArray.at(i);
                		method.printValueOn(System.out);
                		System.out.println();
                	}
                }
                System.out.println("############### Klass部分信息结束  ##############");
                System.out.println("############### Class部分信息开始  ##############");
                klass.getJavaMirror().iterate(new OopPrinter(System.out), true);
                System.out.println("############### Class部分信息结束  ##############");
                return false;
            }
            @Override
            public void epilogue() {
            }
        }, new ObjectHeap.ObjectFilter() {
            @Override
            public boolean canInclude(Oop oop) {
                Klass klass = oop.getKlass();
                return klass.getName() != null &&
                        "com/huize/jvm/monitor/Test".equals(klass.getName().asString());
            }
        });
    }

}