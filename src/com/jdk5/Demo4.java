package com.jdk5;
//ö��
public class Demo4 {
	public enum Sex {
		��,
		Ů,
		����
	} 
	
	public static void youAre( Sex sex ) {
		System.out.println( sex );
	}
	
	public static void main( String [] args ) throws Exception {
		Demo4.youAre( Sex.���� );
	}
}
