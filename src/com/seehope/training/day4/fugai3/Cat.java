package com.seehope.training.day4.fugai3;

public class Cat extends Animal{
	public String name = "cat";
	public Food eat(){
		//super.eat();
		System.out.println("cat eat");
		return new Food();
	}
	
	public void shangshu(){
		System.out.println("cat shangshu");
	}

}
