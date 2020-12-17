package com.training.day5.single;

public class Earth {

	private static  Earth earth;
	private Earth(){
		
	}
	public static Earth getInstance(){
		if(Earth.earth == null){
			Earth.earth = new Earth();
		}
		return Earth.earth;
	}
}
