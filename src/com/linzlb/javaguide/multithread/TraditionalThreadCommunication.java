package com.linzlb.javaguide.multithread;

/**
 * 4.传统线程同步通信技术 wait/notify
 *
 * 子线程循环10次，主线程循环10次，子线程循环10次，主线程循环10次，如此循环10次
 * 设计思路：
 * 		1.子线程业务：循环10次；主线程业务：循环10次；
 * 		2.Business类用来实现业务，sub方法实现子线程业务，main方法实现主线程业务
 * 		3.如此循环10次，所以做个是不是子线程的标记subflag，并对Business加锁
 * 		4.如此循环10次，在执行的时候才给它循环
 */
public class TraditionalThreadCommunication {

	public static void main(String[] args) {
        final Business business = new Business();
		
		new Thread(new Runnable() {

			@Override
			public void run() {
				for(int i=1;i<=10;i++){
					business.sub(i);
				}
			}
		}).start();

		for(int i=1;i<=10;i++){
			business.main(i);
		}
	}
}



class Business{
	private boolean subflag = true;
	public synchronized void sub(int i){
		if(subflag){
			try {
				this.wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		for(int j=1;j<=10;j++){
			System.out.println("sub thread sequence of " + j + ",loop of " + i);
		}
		subflag = !subflag;
		this.notify();
	}
	public synchronized void main(int i){
		if(!subflag){
			try {
				this.wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		for(int j=1;j<=10;j++){
			System.out.println("main thread sequence of " + j + ",loop of " + i);
		}
		subflag = !subflag;
		this.notify();
	}
}