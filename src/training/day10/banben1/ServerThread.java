package training.day10.banben1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.ArrayList;

public class ServerThread extends Thread {
	private Socket socket;
	private ArrayList<Socket> sockets;
	private Object o;
	public ServerThread(Socket socket, ArrayList<Socket> sockets, Object o) {
		this.socket = socket;
		this.sockets = sockets;
		this.o = o;
		synchronized (o) {
			this.sockets.add(this.socket);
			System.out.println("���ǵ�" + this.sockets.size() + "������!");
		}
	}

	public void run() {
		BufferedReader br = IoUtil.createBufferedReader(this.socket, "gbk");
		String msg = null;
		try {
			while (null != (msg = br.readLine())) {
				for(Socket socket : this.sockets){
					PrintWriter pw = 
							IoUtil.createPrintWriter(socket, "gbk");
					pw.println(msg);
					pw.flush();
				}
			}
			synchronized(this.o){
				this.sockets.remove(this.socket);
			}
		} catch (IOException e) {
			synchronized(this.o){
				IoUtil.close(this.socket);
				this.sockets.remove(this.socket);
			}
		}
	}

}
