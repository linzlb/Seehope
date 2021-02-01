package com.seehope.training.day4.fugai3;

public class Animal {
	
	public String name = "zhengli";
	protected Food eat(){
		System.out.println("animal eat");
		return new Food();
	}

}
