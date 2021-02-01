package com.seehope.training.day3.stc;

public class Girl {
	public static int nums = 5;
	
	static {
		System.out.println("Girl static{}");
	}
	{
		System.out.println("Girl {}");
	}
	
	public Girl(){
		System.out.println("Girl Girl()");
	}
	
	public static void action(){
		System.out.println("Girl action..");
	}

}