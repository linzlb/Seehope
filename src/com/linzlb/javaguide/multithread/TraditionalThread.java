package com.linzlb.javaguide.multithread;

/**
 * @function 1.传统创建线程的方法
 * @author linzlb
 * @date 20170402
 */
public class TraditionalThread {

	private static void newThread1(){
        Thread thread = new Thread(){
			@Override
			public void run() {
				while(true){
					try {
						Thread.sleep(500);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					System.out.println("1:" + Thread.currentThread().getName());
					//System.out.println("2:" + this.getName());//this--run方法所对应的线程对象
				}
			}
		};
		thread.start();
	}

	private static void newThread2(){
		//Runnable是线程所要运行的代码的宿主
		//将所要运行的代码放Runnable对象更体现面向对象的编码方式
		Thread thread = new Thread(new Runnable() {

			@Override
			public void run() {
				while(true){
					try {
						Thread.sleep(500);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					System.out.println("2:" + Thread.currentThread().getName());
				}	
			}
		});	
		thread.start();
	}

	private static void newThread3(){
		new Thread(){
			@Override
			public void run() {
				while(true){
					try {
						Thread.sleep(500);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					System.out.println("3:" + Thread.currentThread().getName());
				}	
			}
		}.start();
	}

	//new Thread(runnable.run1) {run2}.start();这种结构，结构是run2，如果run2不覆盖，就是run1
	private static void newThread4(){
		new Thread(new Runnable() {
			
			@Override
			public void run() {
				while(true){
					try {
						Thread.sleep(500);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					System.out.println("Runnable4:" + Thread.currentThread().getName());
				}	
			}
		}){
			@Override
			public void run() {
				while(true){
					try {
						Thread.sleep(500);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					System.out.println("Thread4:" + Thread.currentThread().getName());
				}	
			}
		}.start();
	}
	
	public static void main(String[] args) {
//		newThread1();
//		newThread2();
//		newThread3();
		newThread4();
		
	}
}