package com.seehope.training.day1;

/**
 * 1+2+...+n
 */
public class JiaFa {
	public static void main(String[] args) {
		sumFor(100);
	}
	
	public static void sumFor(int var){
		int sum=0;
		for(int i=1;i<=var;i++){
			sum+=i;
		}
		System.out.println("1+...+" + var + "=" +sum);
	}
}
