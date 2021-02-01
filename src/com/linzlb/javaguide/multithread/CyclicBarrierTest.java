package com.linzlb.javaguide.multithread;

import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 15.java5��CyclicBarrierͬ������
 */
public class CyclicBarrierTest {

	public static void main(String[] args) {
        ExecutorService threadPool = Executors.newCachedThreadPool();
		final CyclicBarrier cb = new CyclicBarrier(3);
		for (int i = 0; i < 3; i++) {
			Runnable runnable = new Runnable() {
				
				@Override
				public void run() {
					try {
						Thread.sleep((long)(Math.random()*10000));	
						System.out.println("�߳�" + Thread.currentThread().getName() 
								+ "�������Ｏ�ϵص�1����ǰ����" + (cb.getNumberWaiting()+1) 
								+ "���Ѿ����" + (cb.getNumberWaiting()==2?"�������ˣ������߰�":"���ڵȺ�"));						
						cb.await();
						
						Thread.sleep((long)(Math.random()*10000));	
						System.out.println("�߳�" + Thread.currentThread().getName()  
								+ "�������Ｏ�ϵص�2����ǰ����" + (cb.getNumberWaiting()+1) 
								+ "���Ѿ����" + (cb.getNumberWaiting()==2?"�������ˣ������߰�":"���ڵȺ�"));
						cb.await();	
						Thread.sleep((long)(Math.random()*10000));	
						System.out.println("�߳�" + Thread.currentThread().getName()  
								+ "�������Ｏ�ϵص�3����ǰ����" + (cb.getNumberWaiting() + 1) 
								+ "���Ѿ����" + (cb.getNumberWaiting()==2?"�������ˣ������߰�":"���ڵȺ�"));						
						cb.await();						
					} catch (Exception e) {
						e.printStackTrace();
					}		
				}
			};
			threadPool.execute(runnable);
		}
		threadPool.shutdown();
	}
}
