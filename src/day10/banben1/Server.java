package day10.banben1;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;


public class Server {
	public static final ArrayList<Socket> sockets = new ArrayList<Socket>();
	public static void main(String[] args){
		System.out.println("服务器启动了");
		ServerSocket ss = null;
		try {
			//1.创建服务Socket,并监听端口
			ss = new ServerSocket(8888);
			//2.等待请求连接，并产生用于与客户端连接的Socket
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