package com.seehope.training.day5.single;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//Earth e = new Earth(); //error
		Earth e = Earth.getInstance();
		Earth e2 = Earth.getInstance();
		System.out.println(e==e2);
	}

}
