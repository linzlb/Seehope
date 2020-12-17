package com.training.day2;

public class TestObject{
	public static void main(String[] args){
		testToString();
		testFinalize();
	}

	public static void testToString(){
		Account a = new Account();
//		System.out.println(a.toString());
		System.out.println(a);
	}

	public static void testFinalize(){
		while(true){	
			Account a = new Account();
		}
	}
}

class Account{
	public String toString(){
		return "i am account����дtoString��";	
	}
	public void finalize(){
		System.out.println("I will Dead!");
	}
}
