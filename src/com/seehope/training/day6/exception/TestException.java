package com.seehope.training.day6.exception;

public class TestException {
	public static void main(String[] args) {
		//test1();//java.lang.NullPointerException
		test2();
		chufa(1,0);//java.lang.ArithmeticException: / by zero
	}

	public static void test1(){
		Student s =null;
		s.study();
	}
	
	public static void test2(){
		try {
			Class c = Class.forName("day6.exception.Studen");
			//Class c = Class.forName("Student");
			System.out.println("--------");
		} catch (Exception e) {
			System.out.println("��û���ҵ�...");
		} finally {
			System.out.println("�ͷ���Դ....");//һ����ִ��
		}

		System.out.println("����ִ��");
	}
	
	public static void chufa(int a, int b){
		System.out.println(a/b);
	}
}


class Student {
	public void study() {
		System.out.println("study����");
	}
}