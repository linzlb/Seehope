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
				// �õ�ƥ��ĵ�һ���ַ�λ��
				int start = matcher.start();
				// �õ�ƥ������һ���ַ�λ��
				int end = matcher.end();
				// ��ȡƥ����ַ���
				String match = data.substring(start, end);
				System.out.println( match );
			}
		} catch (Exception e) {e.printStackTrace();}
	}
}
