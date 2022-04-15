package com.linzlb.multithread;

/**
 * @function 1Traditional
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
					//System.out.println("2:" + this.getName());//this--run��������Ӧ���̶߳���
				}
			}
		};
		thread.start();
	}

	private static void newThread2(){
		//Runnable���߳���Ҫ���еĴ��������
		//����Ҫ���еĴ����Runnable����������������ı��뷽ʽ
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