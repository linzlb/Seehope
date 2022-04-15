package com.seehope.training.day5.inter;

public class JapeneseMan extends Animal implements IThief , ICityManager{
	
	public void thief(){
		System.out.println("thief");
	}
	public void manager(){
		System.out.println("manager");
	}
	public void eat(){
		System.out.println("eat");
	}
	
}
