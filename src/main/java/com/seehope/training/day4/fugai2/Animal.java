package com.seehope.training.day4.fugai2;

public class Animal {
	public String name = "zhengli";
	public Food eat(){
		System.out.println("animal eat");
		return new Food();
	}
}
