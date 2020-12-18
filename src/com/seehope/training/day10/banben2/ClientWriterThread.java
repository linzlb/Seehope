package com.seehope.training.day10.banben2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;

public class ClientWriterThread extends Thread{
	private Socket socket;
	public ClientWriterThread(Socket socket) {
		super();
		this.socket = socket;
	}
	public void run(){
		BufferedReader br =
				Util.createBufferedReader(System.in, "gbk");
		PrintWriter pw = 
				Util.createPrintWriter(this.socket, "gbk");
		String str = null;
		
		try {
			while(null != (str = br.readLine())){
				if(str.trim().equals("exit")){
					Util.close(socket);
					break;
				}
				pw.println(str);
				pw.flush();
			}
		} catch (IOException e) {
			Util.close(socket);
		}
	}
}