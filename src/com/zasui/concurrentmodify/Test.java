package com.zasui.concurrentmodify;

import java.util.ArrayList;
import java.util.Iterator;

public class Test {
	static ArrayList<Integer> list = new ArrayList<Integer>();
	public static void main(String[] args)  {
		demo2();
	}

	/**
	 * objc[682]: Class JavaLaunchHelper is implemented in both /Library/Java/JavaVirtualMachines/jdk1.8.0_101.jdk/Contents/Home/bin/java (0x10c8f14c0) and /Library/Java/JavaVirtualMachines/jdk1.8.0_101.jdk/Contents/Home/jre/lib/libinstrument.dylib (0x10c97d4e0).
	 * One of the two will be used. Which one is undefined.
	 */
	public static void demo() {
		ArrayList<Integer> list = new ArrayList<Integer>();
		list.add(2);
		Iterator<Integer> iterator = list.iterator();
		while(iterator.hasNext()){
			Integer integer = iterator.next();
			if(integer==2)
				list.remove(integer);
		}
	}

	/**
	 * 正常执行
	 */
	public static void demo2() {
		ArrayList<Integer> list = new ArrayList<Integer>();
		list.add(2);
		Iterator<Integer> iterator = list.iterator();
		while(iterator.hasNext()){
			Integer integer = iterator.next();
			if(integer==2)
				iterator.remove();   //注意这个地方
		}
	}

	/**
	 objc[688]: Class JavaLaunchHelper is implemented in both /Library/Java/JavaVirtualMachines/jdk1.8.0_101.jdk/Contents/Home/bin/java (0x10d2ce4c0) and /Library/Java/JavaVirtualMachines/jdk1.8.0_101.jdk/Contents/Home/jre/lib/libinstrument.dylib (0x10d35a4e0). One of the two will be used. Which one is undefined.
	 1
	 Exception in thread "Thread-0" java.util.ConcurrentModificationException
	 at java.util.ArrayList$Itr.checkForComodification(ArrayList.java:901)
	 at java.util.ArrayList$Itr.next(ArrayList.java:851)
	 at Test$1.run(Test.java:50)
	 */
	public static void demo3() {
		list.add(1);
		list.add(2);
		list.add(3);
		list.add(4);
		list.add(5);
		Thread thread1 = new Thread(){
			public void run() {
				Iterator<Integer> iterator = list.iterator();
				while(iterator.hasNext()){
					Integer integer = iterator.next();
					System.out.println(integer);
					try {
						Thread.sleep(100);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			};
		};
		Thread thread2 = new Thread(){
			public void run() {
				Iterator<Integer> iterator = list.iterator();
				while(iterator.hasNext()){
					Integer integer = iterator.next();
					if(integer==2)
						iterator.remove(); 
				}
			};
		};
		thread1.start();
		thread2.start();
	}
}