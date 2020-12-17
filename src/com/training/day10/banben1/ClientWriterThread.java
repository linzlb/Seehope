package com.training.day10.banben1;


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
				IoUtil.createBufferedReader(System.in, "gbk");
		PrintWriter pw = 
				IoUtil.createPrintWriter(this.socket, "gbk");
		String str = null;
		
		try {
			while(null != (str = br.readLine())){
				if(str.trim().equals("exit")){
					IoUtil.close(socket);
					break;
				}
				pw.println(str);
				pw.flush();
			}
		} catch (IOException e) {
			IoUtil.close(socket);
		}
	}
}
