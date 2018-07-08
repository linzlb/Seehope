package com.regexp;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
//判断是否匹配
public class Demo1 {
	public static void main(String[] args) {
		Pattern pattern = null;
		try
		{
			// 输入正则表达式
			//pattern = Pattern.compile( "\\d\\d\\d-\\d\\d\\d\\d\\d\\d\\d\\d" );
			pattern = Pattern.compile( "\\d{3,4}-\\d{7,8}" );
			// 绑定要判断的字符串
			Matcher matcher = pattern.matcher( "020-12345678" );
			boolean result = matcher.matches();// 得到匹配结果
			
			Matcher matcher2 = pattern.matcher( "0220-1234578" );
			boolean result2 = matcher2.matches();// 得到匹配结果
					
			System.out.println( result+"-"+result2 );
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
