package com.linzlb.digui;
//第1个人10，第2个比第1个人大2岁，依次递推，请用递归方式计算出第8个人多大？
public class Test {
	public static void main(String [] args)
	{
		for (int i = 1; i < 8+1; i++) {
			System.out.println("第"+i+"个人"+computeAge(i)+"岁");
		}
	}
	
	public static int computeAge(int n)
	{
		if(n==1) return 10;
		return computeAge(n-1) + 2;
	}
}
