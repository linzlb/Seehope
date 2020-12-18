package com.seehope.training.day5.abs2;

public class Circle extends Shape{
	
	private double r;
	public Circle(double r){
		super();
		this.r = r;
		
	}
	public double calculateArea(){
		return 3.14 * r * r;
	}

}
