package com.zasui.jdk5;

import java.util.Date;

public class Demo7<T> {
	public void printType(T t) {
		System.out.println(t.toString());
	}
	
	public static void main(String [] args) throws Exception {
		Demo7 < Date > test = new Demo7 < Date > ();
		Date d = new Date();
		test.printType( d );
		
		Demo7 < String > test2 = new Demo7 < String > ();
		String str = "Frederic";
		test2.printType( str );
	}
}
