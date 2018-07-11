package training.day10.banben2;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;

public class Server {
	public static final HashMap<String, Socket> sockets = new HashMap<String, Socket>();
	public static final Object o = new Object();
	public static void main(String[] args){
		System.out.println("������������");
		ServerSocket ss = null;
		try {
			//1.��������Socket,�������˿�
			ss = new ServerSocket(8888);
			//2.�ȴ��������ӣ�������������ͻ������ӵ�Socket
			Object o = new Object();
			Util.startThread(new ServerStauts(o), true);
			
			while(true){
				Socket socket = ss.accept();
				Util.startThread(new LoginThread(socket), true);
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
}
