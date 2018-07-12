package com.linzlb.jdk5;
/*
 * 动态参数 可以传多个
 * 注意：
 * 可变参数只能是最后一个参数
 * 并且在同一个方法中只能有一个可变参数
 */
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
