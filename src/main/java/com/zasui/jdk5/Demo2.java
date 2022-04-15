package com.zasui.jdk5;

public class Demo2 {
	public static void doTest(int j, String...paramList){
		String[] list = paramList;
		for(int i=0; i<list.length; i++){
			System.out.println(list[i]);
		}
	}
	
	public static void main(String[] args) {
		Demo2.doTest(4, "a", "b", "c");
	}
}
