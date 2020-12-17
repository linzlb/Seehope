package com.zasui.regexp.xiazaihtml;

import java.io.BufferedReader; 
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern; 

public class EmailParse{ 
	public static void main(String[] args) { 
		String s; 
		String urldomain = "http://tieba.baidu.com/p/2314539885";
		s=EmailParse.getWebCon(urldomain); //这是要抓取的网页,自己可以试下.  
	} 
	
	public static String getWebCon(String domain){ 
		System.out.println("开始抓取邮件地址..("+domain+")"); 
		StringBuffer sb=new StringBuffer(); 
		try{ 
			java.net.URL url=new java.net.URL(domain); 
			BufferedReader in=new BufferedReader(new InputStreamReader(url.openStream())); 
			String line; 
			while((line=in.readLine())!=null) { 
//				parse(line); //逐行验证
				System.out.println(line);
			} 
			in.close(); 
		}catch(Exception e) { 
			sb.append(e.toString()); 
			System.err.println(e); 
		} 
		return sb.toString(); 
	} 
	//验证！！
	private static void parse(String line) { 
		Pattern p=Pattern.compile("[\\w[.-]]+@[\\w[.-]]+\\.[\\w]+");//邮箱的正则表达式 ,具体参照API
		Matcher m=p.matcher(line); 
		while(m.find()) { 
			System.out.println(m.group()); 
		} 
	} 
}