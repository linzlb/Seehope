package com.seehope.training.day10.banben1;

import java.io.BufferedReader;
import java.io.IOException;
import java.net.Socket;

public class ClientReaderThread extends Thread{
	private Socket socket;
	public ClientReaderThread(Socket socket) {
		super();
		this.socket = socket;
	}
	public void run() {
		BufferedReader br = 
			IoUtil.createBufferedReader(this.socket, "gbk");
		String str = null;
		try {
			while(null != (str = br.readLine())) {
				System.out.println(str);
			}
		} catch (IOException e) {
			e.printStackTrace();
			IoUtil.close(socket);
		}
	}
}
