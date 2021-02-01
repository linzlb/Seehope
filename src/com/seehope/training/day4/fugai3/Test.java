package com.seehope.training.day4.fugai3;

public class Test {
	public static void main (String[] args)throws Exception{
		Animal a = new Cat();
		Animal a2 = new Dog();
		
		Food f1 = a.eat();
		Food f2 = a2.eat();

		System.out.println(a.name);
		System.out.println(a2.name);
		
		System.out.println(f1.getClass().getName());
		System.out.println(f2.getClass().getName());
	}

}
