package com.seehope.training.day2;

public class TestYinYong{
	public static void main(String[] args){
		Student stu = new Student();
		System.out.println(stu);
		System.out.println(stu.age);
		System.out.println(stu.length);
	}
}

class Student{
	public int age = 15;
	public int length=168;
}
