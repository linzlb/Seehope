package com.linzlb.javaguide.multithread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

//java5中并发库的线程池及定时器
public class ThreadPoolTest {

	public static void main(String[] args) {
        ThreadPoolTest tp = new ThreadPoolTest();
		tp.threadPool();
		tp.timer();
	}

	private void threadPool(){
		//ExecutorService threadPool = Executors.newFixedThreadPool(3);//固定线程池，同时只有3个线程，10个任务的话就只能同时操作3个任务
		//ExecutorService threadPool = Executors.newCachedThreadPool();//池子线程数是动态的
		ExecutorService threadPool = Executors.newSingleThreadExecutor();//如何实现线程死后重新启动！！就用这个
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
		}, 6, 2, TimeUnit.SECONDS);	//定时器，6秒开始，每个两秒操作一次
	}
}