package com.seehope.training.day2;

public class TestSwitch{
	public static void main(String[] args){
		int a = 6;
		//long a = 3;//error
		switch(a){
		case 1:
			System.out.println("1");
			break;
		case 2:
			System.out.println("2");
			break;
		case 3:
			System.out.println("3");
			break;
		case 4:
			System.out.println("4");
			break;
		default:
			System.out.println("888888888");
			break;
		}
	}
}
