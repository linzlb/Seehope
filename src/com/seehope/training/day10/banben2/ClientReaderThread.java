package com.seehope.training.day10.banben2;

import java.io.BufferedReader;
import java.io.IOException;
import java.net.Socket;

public class ClientReaderThread extends Thread{
	private Socket socket;
	public ClientReaderThread(Socket socket) {
		super();
		this.socket = socket;
	}
	public void run(){
		BufferedReader br =
				Util.createBufferedReader(this.socket, "gbk");
		String str = null;
		try {
			while(null != (str = br.readLine())){
				System.out.println(str);
			}
		} catch (IOException e) {
			Util.close(socket);
		}
	}
}
