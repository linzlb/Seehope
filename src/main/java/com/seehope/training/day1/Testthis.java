package com.seehope.training.day1;


public class Testthis {
	int a, b, c;
	
	public Testthis() {
		super();
	}
	public Testthis(int a, int b) {
		super();
		this.a = a;
		this.b = b;
	}
	public Testthis(int a, int b, int c) {
		this(a,b);
		this.c = c;
	}
	
	public static void main(String[] args) {
		Testthis t = new Testthis(1,2,3);
		System.out.println(t.a+"-"+t.b+"-"+t.c);
	}
}
