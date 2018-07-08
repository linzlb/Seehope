package day9.thread;

public class TestThread2 {
	public static void main(String[] args) {
		CharThread ct = new CharThread("字符线程");
		ct.start();
		
		Thread nt = new Thread(new NumTarget(),"数字线程");
		nt.start();
	}
}

class NumTarget implements Runnable{
	public void run() {
		for (int i = 0; i < 1000; i++) {
			System.out.println(Thread.currentThread().getName()+":"+i);
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
class CharThread extends Thread {

	public CharThread(String name) {
		super(name);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void run() {
		for (char c = 'a'; c <= 'z'; c++) {
			System.out.println(Thread.currentThread().getName()+":"+c);
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
}


