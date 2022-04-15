package com.linzlb.designpattern.Singleton17;

public class Test {

	/**
	 * @林政利
	 */
	public static void main(String[] args) {
		Singleton sing = Singleton.getInstance();
        Singleton sing2 = Singleton.getInstance();
        System.out.println(sing);
        System.out.println(sing2);
	}

}
