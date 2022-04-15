package com.linzlb.multithread;

import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

/**
 * 2.TimerTask
 */
public class TraditionalTimerTest {

	private static void testTimer(){
        TimerTask task = new TimerTask() {
			
			@Override
			public void run() {
				System.out.println("boom!");
				
			}
		};
		new Timer().schedule(task, 5000, 2000);//5000�����ʼ��ÿ��2000����һ��
	}

	private static void showTime(){
		Thread thread = new Thread(new Runnable() {
			
			@Override
			public void run() {
				while(true){
					System.out.println(new Date().getSeconds());
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				
			}
		});
		thread.start();
	}
	public static void main(String[] args) {
		//testTimer();
		showTime();
		new Timer().schedule(new MyTimerTask(), 2000);
	}
}

class MyTimerTask extends TimerTask{
	private static int count = 0;
	
	@Override
	public void run() {
		count = (count+1)%2;
		System.out.println("bombing!");
		new Timer().schedule(/*new TimerTask() {

			@Override
			public void run() {
				System.out.println("bombing!");
			}
		}*/new MyTimerTask(),2000+2000*count);
	}
}