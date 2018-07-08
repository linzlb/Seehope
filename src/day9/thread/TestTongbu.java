package day9.thread;


public class TestTongbu implements Runnable {
	int b = 100;
	
	public synchronized void m1() throws Exception{
		//Thread.sleep(2000);
		b = 1000;
		Thread.sleep(5000);
		//b = 1000;
		System.out.println("b = " + b);
	}
	
	/*public synchronized void m2() throws Exception {
		Thread.sleep(2500);
		b = 2000;
	}*/
	public void m2() throws Exception {
		Thread.sleep(500);
		b = 2000;
		System.out.println(b);
	}
	public void run() {
		try {
			m1();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) throws Exception {
		TestTongbu tt = new TestTongbu();
		Thread t = new Thread(tt);
		t.start();
		
		tt.m2();
		System.out.println(tt.b);
	}
}