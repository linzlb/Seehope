package com.training.day10.lin;

import java.net.URL;

public class UseURL {
	public static void main(String[] args) {
		URL url = null;
		try{
			url = new URL("http://www.abcd.com:8088/java/network.html#UDP");
		}catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("The URL is:  "+url);
		System.out.println("use tostring:  "+url.toString());
		System.out.println("use toExternalForm:  "+url.toExternalForm());
		System.out.println("protocol is:  "+url.getProtocol());
		System.out.println("host is:  "+url.getHost());
		System.out.println("port is:  "+url.getPort());
		System.out.println("file is:  "+url.getFile());
	}
}
