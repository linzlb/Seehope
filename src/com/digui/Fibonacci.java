package com.digui;
/*
 * f(0)=1;
 * f(1)=1;
 * f(n)=f(n-1)+f(n-2);
 */
public class Fibonacci {
	public static void main(String args[]){
		int num = 6;
		for(int i=0; i<num+1; i++){
			System.out.println("f("+i+")="+ fibonacci(i));
		}	
	}

	static int fibonacci(int n){
		//쳲������㷨��
		if(n<=1) return 1;
		return fibonacci(n-1)+fibonacci(n-2);
	} 
}
