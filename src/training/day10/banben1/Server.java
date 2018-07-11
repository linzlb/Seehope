package training.day10.banben1;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;


public class Server {
	public static final ArrayList<Socket> sockets = new ArrayList<Socket>();
	public static void main(String[] args){
		System.out.println("������������");
		ServerSocket ss = null;
		try {
			//1.��������Socket,�������˿�
			ss = new ServerSocket(8888);
			//2.�ȴ��������ӣ�������������ͻ������ӵ�Socket
			Object o = new Object();
			IoUtil.startThread(new ServerStauts(o), true);
			
			while(true){
				Socket socket = ss.accept();
				IoUtil.startThread(new ServerThread(socket, sockets, o), true);
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
}