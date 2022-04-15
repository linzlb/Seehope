package com.seehope.training.day5.single2;

public class Test {

	public static void main(String[] args) {

		Star star1 = Star.getInstance(0);
		Star star2 = Star.getInstance(0);
		System.out.println(star1==star2);
		
		
		
		Star.getInstance(0).action();
		Star.getInstance(1).action();
		Star.getInstance(2).action();
	}

}
