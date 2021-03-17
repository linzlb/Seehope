package com.linzlb.designpattern.Visitor24.jiandanlizi;
//简单例子
public class Test {
	public static void main(String[] args) {
		 A a = new A();  
	     a.method1();  
	     a.method2(new B()); 
	}
}
