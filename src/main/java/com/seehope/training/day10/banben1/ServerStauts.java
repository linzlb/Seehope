package com.seehope.training.day10.banben1;

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
				System.out.println("��ǰ��" + Server.sockets.size() +"�û�����");
			}
		}
	}
}
