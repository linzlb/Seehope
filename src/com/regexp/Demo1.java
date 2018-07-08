package com.regexp;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
//�ж��Ƿ�ƥ��
public class Demo1 {
	public static void main(String[] args) {
		Pattern pattern = null;
		try
		{
			// ����������ʽ
			//pattern = Pattern.compile( "\\d\\d\\d-\\d\\d\\d\\d\\d\\d\\d\\d" );
			pattern = Pattern.compile( "\\d{3,4}-\\d{7,8}" );
			// ��Ҫ�жϵ��ַ���
			Matcher matcher = pattern.matcher( "020-12345678" );
			boolean result = matcher.matches();// �õ�ƥ����
			
			Matcher matcher2 = pattern.matcher( "0220-1234578" );
			boolean result2 = matcher2.matches();// �õ�ƥ����
					
			System.out.println( result+"-"+result2 );
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
