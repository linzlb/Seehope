package com.linzlb.designpattern.Proxy04;
//RealSubject 
public class SubjectImpl implements Subject {

	@Override
	public void action() {
		System.out.println("========");
        System.out.println("========");
        System.out.println("这是被代理的类(SubjectImpl)");
        System.out.println("========");
        System.out.println("========");
	}
	
}
