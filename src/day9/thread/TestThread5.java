package day9.thread;

public class TestThread5 {

	public static void main(String[] args) {
		Object o1 = new Object();
		Object o2 = new Object();
		Jia jia = new Jia(o1, o2, "甲");
		Yi yi = new Yi(o1, o2, "乙");
		
		jia.start();
		yi.start();
	}
	
}

class Jia extends Thread{
	private Object o1;
	private Object o2;
	
	public Jia(Object o1, Object o2,String name) {
		super(name);
		this.o1 = o1;
		this.o2 = o2;
	}

	public void run(){
		synchronized(o1){
			System.out.println(this.getName()+"拥有筷子1");
			try {
				o1.wait();
			} catch (InterruptedException e) {
			}
			synchronized(o2){
				System.out.println(this.getName()+"拥有筷子2");
				System.out.println(this.getName()+"开始吃饭");
			}
		}
	}
}
class Yi extends Thread{
	private Object o1;
	private Object o2;
	
	public Yi(Object o1, Object o2,String name) {
		super(name);
		this.o1 = o1;
		this.o2 = o2;
	}

	public void run(){
		synchronized(o2){
			System.out.println(this.getName()+"拥有筷子1");
			synchronized(o1){
				System.out.println(this.getName()+"拥有筷子2");
				System.out.println(this.getName()+"开始吃饭");
				o1.notifyAll();
			}
		}
	}
}



