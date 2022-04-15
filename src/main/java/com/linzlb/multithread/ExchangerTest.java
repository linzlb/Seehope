package com.linzlb.multithread;

import java.util.concurrent.Exchanger;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 17.java5 Exchanger
 */
public class ExchangerTest {
    public static void main(String[] args) {
		ExecutorService service = Executors.newCachedThreadPool();
		final Exchanger exchanger = new Exchanger();
		service.execute(new Runnable(){
			public void run() {
				try {				
					String data1 = "T1data111111111111";
					System.out.println("Thread" + Thread.currentThread().getName() +
					"data1" + data1 +"～");
					Thread.sleep((long)(Math.random()*10000));
					String data2 = (String)exchanger.exchange(data1);
					System.out.println("Thread" + Thread.currentThread().getName() +
					"data2" + data2);
				}catch(Exception e){
					e.getStackTrace();
				}
			}	
		});
		service.execute(new Runnable(){
			public void run() {
				try {				
					String data1 = "T2data2222222222222";
					System.out.println("Thread" + Thread.currentThread().getName() +
							"data1" + data1 +"～");
					Thread.sleep((long)(Math.random()*10000));					
					String data2 = (String)exchanger.exchange(data1);
					System.out.println("Thread" + Thread.currentThread().getName() +
							"data2" + data2);
				}catch(Exception e){
					e.getStackTrace();
				}				
			}	
		});	
		
		service.shutdown();
	}
}