package training.day9.thread;
//�ػ��߳�����

public class Daemon {
	public static void main(String[] args) {
		RunnableDan rd = new RunnableDan();
		Thread threadDan = new Thread(rd);//���̰߳��������
		
		DaemonThread dt = new DaemonThread();
		
		dt.setDaemon(true);//���õ�ǰ�߳�Ϊ�ػ��߳�
		
		threadDan.start();
		dt.start();
	}
}
//�ػ��߳���
class DaemonThread extends Thread{
	public void run(){
		while(true){
			System.out.println("�ػ��߳�---������");
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
