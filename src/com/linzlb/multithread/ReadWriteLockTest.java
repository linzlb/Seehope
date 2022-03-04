package com.linzlb.multithread;

import java.util.Random;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/*
12.ReadWriteLock
 */
public class ReadWriteLockTest {
    public static void main(String[] args) {
		test();
	}
	private static void test(){
		final Queue queue = new Queue();
		for(int i=0;i<3;i++){
			new Thread(){
				public void run(){
					while(true){
						queue.get();						
					}
				}
				
			}.start();

			new Thread(){
				public void run(){
					while(true){
						queue.put(new Random().nextInt(10000));
					}
				}			
				
			}.start();
		}
	}
}
class Queue{
	private Object data = null;
	ReadWriteLock rwl = new ReentrantReadWriteLock();
	public void get(){
		rwl.readLock().lock();
		try {
			System.out.println(Thread.currentThread().getName() + " be ready to read data!");
			Thread.sleep((long)(Math.random()*1000));
			System.out.println(Thread.currentThread().getName() + "have read data :" + data);			
		} catch (InterruptedException e) {
			e.printStackTrace();
		}finally{
			rwl.readLock().unlock();
		}
	}
	
	public void put(Object data){
		rwl.writeLock().lock();
		try {
			System.out.println(Thread.currentThread().getName() + " be ready to write data!");					
			Thread.sleep((long)(Math.random()*1000));
			this.data = data;		
			System.out.println(Thread.currentThread().getName() + " have write data: " + data);					
		} catch (InterruptedException e) {
			e.printStackTrace();
		}finally{
			rwl.writeLock().unlock();
		}
	}
}