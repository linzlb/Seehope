package com.linzlb.digui;
//��1����10����2���ȵ�1���˴�2�꣬���ε��ƣ����õݹ鷽ʽ�������8���˶��
public class Test {
	public static void main(String [] args)
	{
		for (int i = 1; i < 8+1; i++) {
			System.out.println("��"+i+"����"+computeAge(i)+"��");
		}
	}
	
	public static int computeAge(int n)
	{
		if(n==1) return 10;
		return computeAge(n-1) + 2;
	}
}
