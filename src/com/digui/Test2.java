package com.digui;
/*һ������������0������ѭ���ͱ��ر���������n��2n��4n��8n��˳���������ֵ����5000ʱ����ֵ����ָ��˳���������
����n=1237,�����Ϊ��
1237��
2474��
4948��
9896��
9896��
4948��
2474��
1237�� 
��ʾ��д����ʱ���Ȱ�������ʽ�Ĵ��룬д�õ������Ժ������ӿ��ǵݼ�����*/
public class Test2 {
	public static void main(String[] args) {
		int x=1237;
		doubleNum(x);
	}
	public static void doubleNum(int n)
	{
		System.out.println("1��������---------------"+n);
		if(n<=5000)
			doubleNum(n*2);
		System.out.println("2�ݼ�����---------------"+n);
	}
}
