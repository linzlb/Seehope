package com.seehope.training.day5.inter;

public interface IThief {
	int a = 5;
	//static int a = 5;//ok
	//static final int a = 5;//ok
	//public static final a = 5;//ok
	//˵���ӿ��е����Զ���static  final  public
	
	void thief();
	//abstract void thief();//ok
	//public abstract void thief();//ok
	//˵���ӿ��еķ�������public   abstract
}
