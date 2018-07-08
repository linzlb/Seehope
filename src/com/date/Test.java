package com.date;


import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Test {
	public static void main(String[] args) {
		//当前日期
		Date date = new Date();
		System.out.println(date);
		//转换当前日期到本地日期
		System.out.println(date.toLocaleString());
		//转换当前日期到国际日期
		System.out.println(date.toGMTString());
		//得到日期和时间
		int year = date.getYear();
		int month = date.getMonth() + 1;// 月是从0开始计数的，所以要加1
		int day = date.getDate();
        int hour = date.getHours();
		int minute = date.getMinutes();
		int second = date.getSeconds();
		int weekday = date.getDay();
		System.out.println( 1900+year + "-" + month + "-" + day + " " + hour + ":" + minute + ":" + second + " 星期" + weekday );
		
		System.out.println(new SimpleDateFormat("yyyy年MM月dd日，HH:mm:ss.SSS").format(new Date()));
		System.out.println(new SimpleDateFormat("yyyy年MM月dd日").format(new Date()));
		System.out.println(new SimpleDateFormat("HH:mm:ss.SSS").format(new Date()));
	}
}
