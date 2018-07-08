package day9.thread;


//设计4个线程，其中两个线程每次对j增加1，另外两个线程对j每次减少1
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
	       //上面2句也可以
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