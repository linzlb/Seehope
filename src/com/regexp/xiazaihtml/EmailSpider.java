package com.regexp.xiazaihtml;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/*
 * 抓取网页中的邮箱 
 */
public class EmailSpider {

	public static void main(String[] args) {
		String url = "G:\\java\\IO流测试区\\1.htm";
		List l = getEmail(url);
		for(int i = 0; i<l.size(); i++){
			System.out.println(l.get(i));
		}
	}

	//传进一个网页地址,返回网页中的邮箱的列表
	private static List getEmail(String url){
		List emailList = new ArrayList();
		try {
			BufferedReader br = new BufferedReader(new FileReader(url));
			String line = "";

			while((line=br.readLine()) != null) {//逐行读取
				List l = parse(line);
				for(int i = 0; i<l.size(); i++){
					emailList.add(l.get(i));
				}
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return emailList;
	}
	
	//邮箱验证！！
	private static List parse(String line) {
		Pattern p = Pattern.compile("[\\w[.-]]+@[\\w[.-]]+\\.[\\w]+");//得到邮箱这种格式的字符串
		Matcher m = p.matcher(line);
		List<String> l = new ArrayList<String>();
		while(m.find()) {
			//System.out.println(m.group());//输出
			l.add(m.group());
		}
		return l;
	}

}
