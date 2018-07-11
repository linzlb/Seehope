package training.day9.thread;

public class TestThread8 extends Thread{
	private static Object o = new Object();
	private static int count = 0;
	private int num = 0;
	private char ID;
	private int id;
	public TestThread8(int id,char ID){
		this.id = id;
		this.ID = ID;
	}
	public void run(){
		synchronized (o) {
			while(num<10){
				if(count%3==id){
					System.out.println("ID="+ID);
					++count;
					++num;
					o.notifyAll();
				}else{
					try{
						o.wait();
					}catch (Exception e) {
						// TODO: handle exception
					}
				}
			}
		}
	}
	public static void main(String[] args) {
		(new TestThread8(0,'A')).start();
		(new TestThread8(1,'B')).start();
		(new TestThread8(2,'C')).start();
	}
}
