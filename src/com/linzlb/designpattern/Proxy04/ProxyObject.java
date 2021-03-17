package com.linzlb.designpattern.Proxy04;
//Proxy 
public class ProxyObject implements Subject{
	Subject sub;
	
	@Override
	public void action() {
		// TODO Auto-generated method stub
		System.out.println("代理开始");
		sub.action();
        System.out.println("代理结束");
	}
	
	
	public ProxyObject() {
        System.out.println("这是代理类ProxyObject的构造方法");
        sub = new SubjectImpl();
    }
    
}
