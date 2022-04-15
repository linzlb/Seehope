package com.seehope.training.day6.zidingyiyichang;

public class Demo {
	static void compute(int a) throws MyException{
		System.out.println("Call compute("+ a +")");
		if(a>10) 
			throw new MyException(a);
		System.out.println("normal exit");
	}
	
	public static void main(String[] args) {
		try{
			compute(1);
			compute(100);
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
}
