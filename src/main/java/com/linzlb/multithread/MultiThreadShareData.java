package com.linzlb.multithread;


public class MultiThreadShareData {

	public static void main(String[] args) {
        ShareData1 sd = new ShareData1();
		new Thread(new MyRunnable1(sd)).start();
		new Thread(new MyRunnable2(sd)).start();
		
		final ShareData1 sd2 = new ShareData1();
		new Thread(new Runnable() {
			public void run() {
				sd2.decrement();
			}
		}).start();
		new Thread(new Runnable() {
			public void run() {
				sd2.increment();
			}
		}).start();
	}
	
	
}
class MyRunnable1 implements Runnable{
	private ShareData1 sd;
	@Override
	public void run() {
		sd.decrement();	
	}

	public MyRunnable1(ShareData1 sd) {
		this.sd = sd;
	}
	
}
class MyRunnable2 implements Runnable{
	private ShareData1 sd;
	@Override
	public void run() {
		sd.increment();	
	}

	public MyRunnable2(ShareData1 sd) {
		this.sd = sd;
	}
	
}
class ShareData1 {
	private int j = 0;
	public synchronized void increment(){
		j++;
		System.out.println(Thread.currentThread().getName()+"  increment:"+j);
	}
	public synchronized void decrement(){
		j--;
		System.out.println(Thread.currentThread().getName()+"  decrement:"+j);
	}
}