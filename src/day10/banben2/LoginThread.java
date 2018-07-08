package day10.banben2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Properties;

public class LoginThread extends Thread {
	private Socket socket;

	public LoginThread(Socket socket) {
		this.socket = socket;
	}

	public void run() {
		BufferedReader br = Util.createBufferedReader(this.socket, "gbk");
		PrintWriter pw = Util.createPrintWriter(socket, "gbk");
		String msg = null;
		boolean hasLogin = false;
		Properties p = new Properties(); //属性
		try {
			p.load(LoginThread.class.getClassLoader().getResourceAsStream(
					"./day10/banben2/data.conf"));
		} catch (IOException e1) {
			Util.close(this.socket);
		}
		try {
			while (null != (msg = br.readLine())) {
				hasLogin = false;
				String namePasswd[] = msg.split(":");
				String passwd = p.getProperty(namePasswd[0]);
				if (null == passwd || !passwd.equals(namePasswd[1])) {
					pw.println("用户名密码错误!");
					pw.flush();
				} else {
					if (null != Server.sockets.get(namePasswd[0])) {
						hasLogin = true;
						pw.println("已经登录过了!");
						pw.flush();
					} else {
						pw.println("欢迎你!" + namePasswd[0]);
						pw.flush();
						break;
					}
				}
			}
			if (null != msg && !hasLogin) {
				Util.startThread(new ServerThread(socket, msg.split(":")[0]),
						true);
				synchronized (Server.o) {
					Collection<Socket> sockets = Server.sockets.values();
					for (Socket socket : sockets) {
						PrintWriter pp = Util.createPrintWriter(socket, "gbk");
						pp.println(msg.split(":")[0] + "进入房间了");
						pp.flush();
					}
				}

			}
		} catch (IOException e) {
			Util.close(this.socket);
		}
	}
}
