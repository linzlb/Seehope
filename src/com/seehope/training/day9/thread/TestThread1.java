package com.seehope.training.day9.thread;

public class TestThread1 {

	/**
	 *û���̵߳�ʱ��
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		fun();
		fun3();
	}
	
	public static void fun3(){
		System.out.println("3");
	}
	
	public static void fun(){
		fun2();
		System.out.println("1");
	}

	public static void fun2(){
		System.out.println("2");
	}
}
