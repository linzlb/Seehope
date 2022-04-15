package com.seehope.training.day8.io1;

import java.io.UnsupportedEncodingException;

public class TestEncoding {
	public static void main(String[] args) {
		String str = "翠雯";
		String str2 = "政利";
		try{
			byte[] b = str.getBytes("utf8");
			System.out.println(b.length );
			String s = new String(b, "utf8");
			String s1 = new String(b, "gbk");
			System.out.println(s);
			System.out.println(s1);
			
			
			byte[] b2 = str2.getBytes("gbk");
			System.out.println(b2.length );
			String s2 = new String(b2, "gbk");
			System.out.println(s2);
			
		} catch(UnsupportedEncodingException e) {
			e.printStackTrace();
		}
	}
}
