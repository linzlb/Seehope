package day10.banben1;

public class ServerStauts extends Thread{
	Object o;
	public ServerStauts(Object o) {
		this.o = o;
	}
	
	public void run() {
		while(true) {
			try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			synchronized(this.o) {
				System.out.println("当前有" + Server.sockets.size() +"用户在线");
			}
		}
	}
}
