package com.linzlb.multithread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

//java5�в�������̳߳ؼ���ʱ��
public class ThreadPoolTest {

	public static void main(String[] args) {
        ThreadPoolTest tp = new ThreadPoolTest();
		tp.threadPool();
		tp.timer();
	}

	private void threadPool(){
		//ExecutorService threadPool = Executors.newFixedThreadPool(3);//�̶��̳߳أ�ͬʱֻ��3���̣߳�10������Ļ���ֻ��ͬʱ����3������
		//ExecutorService threadPool = Executors.newCachedThreadPool();//�����߳����Ƕ�̬��
		ExecutorService threadPool = Executors.newSingleThreadExecutor();//���ʵ���߳������������������������
		for(int i=1;i<=10;i++){
			final int task = i;
			threadPool.execute(new Runnable(){
				@Override
				public void run() {
					for(int j=1;j<=10;j++){
						try {
							Thread.sleep(20);
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
						System.out.println(Thread.currentThread().getName() 
								+ " is looping of " + j + " for  task of " + task);
					}
				}
			});
		}
		System.out.println("all of 10 tasks have committed! ");
	}
	private void timer(){
		Executors.newScheduledThreadPool(3).scheduleWithFixedDelay(new Runnable() {
			public void run() {
				System.out.println("bombing!");
			}
		}, 6, 2, TimeUnit.SECONDS);	//��ʱ����6�뿪ʼ��ÿ���������һ��
	}
}