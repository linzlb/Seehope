package com.training.day9.lock;

public class MyLock implements Runnable{
	private Ticket ticket = new Ticket();
	@Override
	public void run() {
		// TODO Auto-generated method stub
		for(int i=0; i<10; i++){
			ticket.getTicket();
		}
	}
	public static void main(String[] args) {
		MyLock lock = new MyLock();
		Thread t1 = new Thread(lock);  
        Thread t2 = new Thread(lock);  
        Thread t3 = new Thread(lock);  
        t1.start();  
        t2.start();  
        t3.start();  
	}
}
