package com.training.day1;


public class JiuJiu
{
	public static void main (String[] args)
	{
		chengFa();
	}
	public static void chengFa()
	{
		for (int i = 1;i <= 9; i++)
		{
			for (int j = 1;j <= i ;j++ )
			{
				System.out.print(j + "x" + i + "=" + (i*j) + " ");
			}
			System.out.println();
		}
	}
}
