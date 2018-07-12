package com.linzlb.jdk5;
//foreach
public class Demo3 {
	public static void main(String[] args) {
		String [] list = { "Frederic", "Janet", "LINZL" };
		for ( String name: list ) {
			System.out.println( name );
		}
	}
}
