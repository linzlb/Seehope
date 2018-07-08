package day10.banben2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Collection;

public class ServerThread extends Thread {
	private Socket socket;
	private String userName;
	public ServerThread(Socket socket, String userName) {
		this.socket = socket;
		this.userName = userName;
		synchronized (Server.o) {
			Server.sockets.put(userName, this.socket);
		}
	}

	public void run() {
		BufferedReader br = Util.createBufferedReader(this.socket, "gbk");
		String msg = null;
		try {
			while (null != (msg = br.readLine())) {
				synchronized (Server.o) {
					Collection<Socket> sockets = Server.sockets.values();
					for (Socket socket : sockets) {
						PrintWriter pw = Util.createPrintWriter(socket, "gbk");
						pw.println(this.userName+"˵:"+msg);
						pw.flush();
					}
				}
			}
			synchronized (Server.o) {
				Server.sockets.remove(this.userName);
			}
		} catch (IOException e) {
			synchronized (Server.o) {
				Util.close(this.socket);
				Server.sockets.remove(this.userName);
			}
		}
	}
}
