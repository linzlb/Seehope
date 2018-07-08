package com.jdk5;
//枚举
public class Demo4 {
	public enum Sex {
		男,
		女,
		人妖
	} 
	
	public static void youAre( Sex sex ) {
		System.out.println( sex );
	}
	
	public static void main( String [] args ) throws Exception {
		Demo4.youAre( Sex.人妖 );
	}
}
