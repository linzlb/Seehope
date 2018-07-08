package day9.thread;
//守护线程例子

public class Daemon {
	public static void main(String[] args) {
		RunnableDan rd = new RunnableDan();
		Thread threadDan = new Thread(rd);//讲线程绑定这个任务
		
		DaemonThread dt = new DaemonThread();
		
		dt.setDaemon(true);//设置当前线程为守护线程
		
		threadDan.start();
		dt.start();
	}
}
//守护线程类
class DaemonThread extends Thread{
	public void run(){
		while(true){
			System.out.println("守护线程---还活着");
		}
	}
}

class Test{
	public static void printDan(){
		for(int i = 1; i<100; i+=2){
			System.out.println(i);
		}
	}
}

class RunnableDan implements Runnable{

	@Override
	public void run() {
		// TODO Auto-generated method stub
		Test.printDan();
	}
	
}
