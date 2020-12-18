package com.seehope.training.day10.lin;

import java.net.InetAddress;

public class GetIP {
	public static void main(String[] args) {
		InetAddress baiduIP = null;
		InetAddress myIP = null;
		try{
			baiduIP = InetAddress.getByName("www.baidu.com");
			myIP = InetAddress.getLocalHost();
		}catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println(baiduIP);
		System.out.println(myIP);
	}
}
