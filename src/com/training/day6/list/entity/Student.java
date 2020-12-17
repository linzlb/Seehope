package com.training.day6.list.entity;

public class Student {
	private String name;
	private int age;
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return this.name+"-"+this.age;
	}
	public Student(String name, int age) {
		super();
		this.name = name;
		this.age = age;
	}
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	
}
