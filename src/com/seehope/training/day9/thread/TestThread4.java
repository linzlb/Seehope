package com.seehope.training.day9.thread;

public class TestThread4 {
	public static void main(String[] args) {
		Object o = new Object();
		T1 nt = new T1(o, "�����߳�");
		nt.start();
		T2 ct = new T2(o, "�ַ��߳�");
		ct.start();
	}
}
class T1 extends Thread {
	Object o ;

	public T1(Object o, String name) {
		super(name);
		this.o = o;
	}
	
	public void run() {
		for (int i = 0; i < 100; i++) {
			synchronized (this.o) {
				o.notifyAll();
				System.out.println(Thread.currentThread().getName() + ":" + i);
				if(i == 99){
					Flag.flag = true;
				}
				if (!Flag.flag) {
					try {
						o.wait();
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		}
	}
}

class T2 extends Thread {
	Object o;

	public T2(Object o, String name) {
		super(name);
		this.o = o;
	}

	@Override
	public void run() {
		for (char c = 'A'; c <= 'z'; c++) {
			synchronized (this.o) {
				o.notifyAll();
				System.out.println(Thread.currentThread().getName() + ":" + c);
				if(c == 'z'){
					Flag.flag = true;
				}
				if (!Flag.flag) {
					try {
						o.wait();
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		}
	}
}

class Flag {
	public static boolean flag = false;
}
