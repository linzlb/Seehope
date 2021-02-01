package com.seehope.training.day4.fugai3;

public class Dog extends Animal{

	public String name = "dog";
	public Bone eat(){
		System.out.println("dog eat");
		return new Bone();
	}
}
