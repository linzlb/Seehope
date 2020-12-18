package com.seehope.training.day9.lock;

//ģ����Ʊϵͳ

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Ticket {
	private static int ticket = 20;    
    private Lock lock = new ReentrantLock();  
  
    public void getTicket() {  
        lock.lock();  
        try {  
            Thread.sleep(1000);  
            if (ticket > 0) {  
                System.out.println(Thread.currentThread().getName()  
                        + "��Ʊ��ticket = ��" + ticket +"��");  
                ticket--;
            }else{
            	System.out.println("ϵͳ�ٴ�����20��Ʊ");
            	ticket = 20;
            }
        } catch (Exception e) {  
            e.printStackTrace();  
        } finally {  
            lock.unlock();  
        }  
    }  
}
