package day8.fanxing;

import java.util.Date;

public class zidingyi<T> {
	public void printType(T t){
		System.out.println(t.toString());
	}
	public static void main(String[] args) {
		zidingyi<Date> test = new zidingyi<Date>();
		Date d = new Date();
		test.printType(d);
		
		zidingyi<String> test2 = new zidingyi<String>();
		String s = "linlin";
		test2.printType(s);
	}
	
}
