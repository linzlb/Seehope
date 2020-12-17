package com.training.day4.fugai3;

public class Cat extends Animal{
	public String name = "cat";
	public Food eat(){
		//super.eat();
		System.out.println("����..");
		return new Food();
	}
	
	public void shangshu(){
		System.out.println("����");
	}

}
