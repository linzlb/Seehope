package com.training.day9.thread;


//���4���̣߳����������߳�ÿ�ζ�j����1�����������̶߳�jÿ�μ���1
public class TestThread6 { 
	private int j; 
	public static void main(String args[]){
	   TestThread6 tt=new TestThread6(); 
	   Inc inc=tt.new Inc(); 
	   Dec dec=tt.new Dec(); 
	   for(int i=0;i<2;i++){ 
	       Thread t=new Thread(inc); 
	       t.start(); 
		   Thread t2=new Thread(dec); 
	       t2.start();  
	       //����2��Ҳ����
	       /*t=new Thread(dec); 
	       t.start();*/
	   } 
	} 
	private synchronized void inc(){ 
	   j++; 
	   System.out.println(Thread.currentThread().getName()+"-inc:"+j); 
	} 
	private synchronized void dec(){ 
	   j--; 
	   System.out.println(Thread.currentThread().getName()+"-dec:"+j); 
	} 
	class Inc implements Runnable{ 
	   public void run(){ 
	       for(int i=0;i<10;i++){ 
	    	   inc(); 
	       }
		   //inc();
	   } 
	} 
	class Dec implements Runnable{ 
	   public void run(){ 
	       for(int i=0;i<10;i++){ 
	    	   dec(); 
	       } 
		   //dec();
	   } 
	} 
} 