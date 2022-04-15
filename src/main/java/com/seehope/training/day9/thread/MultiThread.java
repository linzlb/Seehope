package com.seehope.training.day9.thread;

public class MultiThread {

	public static void main(String[] args) {

		new Thread(new Thread1()).start();
		try {
			Thread.sleep(10);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		new Thread(new Thread2()).start();		
	}
	
	
	private static class Thread1 implements Runnable
	{
		@Override
		public void run() {
			/*���������Thread1�������Thread2�ڲ�run����Ҫ��ͬһ������Ϊ��������
			�������ﲻ����this����Ϊ��Thread2�����this�����Thread1��this����ͬһ������
			������MultiThread.class����ֽ�����󣬵�ǰ������������������ʱ��ָ��Ķ���ͬһ������*/
			synchronized (MultiThread.class) {
				System.out.println("enter thread1...");				
				try {
					/*�ͷ��������ַ�ʽ����һ�ַ�ʽ�ǳ�����Ȼ�뿪�������ķ�Χ��
					Ҳ�����뿪��synchronized�ؼ��ֹ�Ͻ�Ĵ��뷶Χ��
					��һ�ַ�ʽ������synchronized�ؼ��ֹ�Ͻ�Ĵ����ڲ����ü����������wait������
					���ʹ��wait�����ͷ�����*/
					System.out.println("thread1 is waiting");
					MultiThread.class.wait();	
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				
				System.out.println("thread1 is going on...");
				System.out.println("thread1 is being over!");			
			}
		}
		
	}
	
	private static class Thread2 implements Runnable
	{
		@Override
		public void run() {
			synchronized (MultiThread.class) {
				System.out.println("enter thread2...");		
				System.out.println("thread2 notify other thread can release wait status..");
				/*����notify���������ͷ����� ��ʹthread2���������sleep������Ϣ��10���룬
				��thread1��Ȼ����ִ�У���Ϊthread2û���ͷ���������Thread1�޷��ò�������*/
				MultiThread.class.notify();
				
				System.out.println("thread2 is sleeping ten millisecond...");
				try {
					Thread.sleep(10);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				System.out.println("thread2 is going on...");
				System.out.println("thread2 is being over!");
				
			}
		}
		
	}	
}