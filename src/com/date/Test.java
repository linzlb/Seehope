package com.date;


import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Test {
	public static void main(String[] args) {
		//��ǰ����
		Date date = new Date();
		System.out.println(date);
		//ת����ǰ���ڵ���������
		System.out.println(date.toLocaleString());
		//ת����ǰ���ڵ���������
		System.out.println(date.toGMTString());
		//�õ����ں�ʱ��
		int year = date.getYear();
		int month = date.getMonth() + 1;// ���Ǵ�0��ʼ�����ģ�����Ҫ��1
		int day = date.getDate();
        int hour = date.getHours();
		int minute = date.getMinutes();
		int second = date.getSeconds();
		int weekday = date.getDay();
		System.out.println( 1900+year + "-" + month + "-" + day + " " + hour + ":" + minute + ":" + second + " ����" + weekday );
		
		System.out.println(new SimpleDateFormat("yyyy��MM��dd�գ�HH:mm:ss.SSS").format(new Date()));
		System.out.println(new SimpleDateFormat("yyyy��MM��dd��").format(new Date()));
		System.out.println(new SimpleDateFormat("HH:mm:ss.SSS").format(new Date()));
	}
}
