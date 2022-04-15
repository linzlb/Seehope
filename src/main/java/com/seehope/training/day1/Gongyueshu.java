package com.seehope.training.day1;

public class Gongyueshu {
	
	public static void main(String args[]){
		int a=26460, b=12375;
		while(b!=0){
			System.out.print("gcd("+a+","+b+")\n=");
			int k = a % b;
			a = b;
			b = k;
		}
		System.out.println("gcd("+a+","+b+")="+a);
	}

}