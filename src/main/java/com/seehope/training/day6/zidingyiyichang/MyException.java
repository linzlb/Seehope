package com.seehope.training.day6.zidingyiyichang;

public class MyException extends Exception{
	private int detail;
	public MyException(int a){
		detail = a;
	}
	public String toString(){
		return "LinZhengli-Exception["+ detail +"]";//��ʱ�׳�����쳣�ı�����Ϣ
	}
}
