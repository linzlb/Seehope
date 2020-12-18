package com.seehope.training.day10.banben1;

import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

public class Client {
	public static void main(String[] args) {
		//�����������ӷ�������socket
		Socket socket = null;
		try {
			socket = new Socket("127.0.0.1",8888);
			IoUtil.startThread(new ClientReaderThread(socket), false);
			IoUtil.startThread(new ClientWriterThread(socket), false);
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
