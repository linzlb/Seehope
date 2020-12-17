package com.training.day5.inter;

public class JapeneseMan extends Animal implements IThief , ICityManager{
	
	public void thief(){
		System.out.println("͵�ֻ�");
	}
	public void manager(){
		System.out.println("ִ��");
	}
	
	public void eat(){
		System.out.println("�Զ���");
	}
	
}
