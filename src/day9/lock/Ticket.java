package day9.lock;

//模拟买票系统

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
                        + "买票：ticket = 第" + ticket +"张");  
                ticket--;
            }else{
            	System.out.println("系统再次生成20张票");
            	ticket = 20;
            }
        } catch (Exception e) {  
            e.printStackTrace();  
        } finally {  
            lock.unlock();  
        }  
    }  
}
