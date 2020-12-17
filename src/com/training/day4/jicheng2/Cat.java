package com.training.day4.jicheng2;

public class Cat extends Animal{
	private String name;
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Cat(String name){
		//super();
		super("super...");
		this.name = name;
	}
	
	

}
