package com.gc;

public class Test {
	public static void main( String [] args ){
		for( int i = 0; i < 5; i ++ ){
			Car c = new Car();
			//System.gc()����,�ܽ���JVM������������,���ǲ���ǿ���������գ�����ʱ����JVM������
			//���Կ���ÿ��ִ�еĽ������һ��������car�������������ǹ̶���
			System.gc();
		}
	}
}

class Car{
	static int count = 0;
	//finalize����������������ڶ��󱻻���ʱ�Զ�������
	protected void finalize() throws Throwable
	{
		this.count ++;
		System.out.println( "����Car���ͱ���" + this.count + "��" );
	}
}
