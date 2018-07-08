package com.regexp;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Demo2 {
	public static void main(String[] args) {
		Pattern pattern = null;
		try {
			String data = "12345612334512333";
			pattern = Pattern.compile( "123{1,3}" );
			Matcher matcher = pattern.matcher( data );
			while (matcher.find()) {
				// 得到匹配的第一个字符位置
				int start = matcher.start();
				// 得到匹配的最后一个字符位置
				int end = matcher.end();
				// 提取匹配的字符串
				String match = data.substring(start, end);
				System.out.println( match );
			}
		} catch (Exception e) {e.printStackTrace();}
	}
}
