package day10.banben2;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

public class Client {
	public static void main(String[] args){
		//1。创建用于连接服务器的socket
		Socket socket = null;
		try {
			socket = new Socket("127.0.0.1", 8888);
			Util.startThread(new ClientReaderThread(socket), false);
			Util.startThread(new ClientWriterThread(socket), false);
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
