package com.concurrentmodify;

import java.util.ArrayList;
import java.util.Iterator;

public class Test {
	static ArrayList<Integer> list = new ArrayList<Integer>();
	public static void main(String[] args)  {
		demo3();
	}
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
