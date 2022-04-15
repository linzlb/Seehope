package com.seehope.training.day10.banben1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;


public class IoUtil {
	public static BufferedReader createBufferedReader(Socket socket, String charset) {
		try {
			return new BufferedReader(new InputStreamReader(socket.getInputStream(), charset));
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}
	}
	public static BufferedReader createBufferedReader(InputStream is, String charset) {
		try {
			return new BufferedReader(new InputStreamReader(is, charset));
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}
	}
	public static PrintWriter createPrintWriter(Socket socket, String charset) {
		try {
			return new PrintWriter(new OutputStreamWriter(socket.getOutputStream(), charset));
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}
	}
	public static void close(Socket socket) {
		if (null != socket) {
			try {
				socket.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	public static void startThread(Thread t, boolean isDeamon){
		t.setDaemon(isDeamon);
		t.start();
	}
}
