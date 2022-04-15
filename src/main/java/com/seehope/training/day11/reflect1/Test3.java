/*
 * ����ָ�����͵�ʵ��
 */
package com.seehope.training.day11.reflect1;

public class Test3 {
	public static void main(String[] args) {
		try {
			Class myClass = Class.forName( "java.lang.String" );
			Object instance = myClass.newInstance();
			String str = (String) instance;
			str = "Linzl";
			System.out.println(str);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
