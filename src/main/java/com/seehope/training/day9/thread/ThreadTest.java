package com.seehope.training.day9.thread;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;


//��lock�����˸�д
public class ThreadTest {

	private int j;
	private Lock lock = new ReentrantLock();
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ThreadTest tt = new ThreadTest();
		for(int i=0;i<2;i++)
		{
			new Thread(tt.new Adder()).start();
			new Thread(tt.new Subtractor()).start();
		}
	}

	private class Subtractor implements Runnable
	{

		@Override
		public void run() {
			// TODO Auto-generated method stub
			while(true)
			{
				/*synchronized (ThreadTest.this) {			
					System.out.println("j--=" + j--);
					//�������쳣�ˣ������ͷ���
				}*/
				lock.lock();
				try
				{
					System.out.println("j--=" + j--);
				}finally
				{
					lock.unlock();
				}
			}
		}
		
	}
	
	private class Adder implements Runnable
	{

		@Override
		public void run() {
			// TODO Auto-generated method stub
			while(true)
			{
				/*synchronized (ThreadTest.this) {
				System.out.println("j++=" + j++);	
				}*/
				lock.lock();
				try
				{
					System.out.println("j++=" + j++);
				}finally
				{
					lock.unlock();
				}				
			}			
		}
		
	}
}