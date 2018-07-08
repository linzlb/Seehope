package com.digui;
/*一个整数，大于0，不用循环和本地变量，按照n，2n，4n，8n的顺序递增，当值大于5000时，把值按照指定顺序输出来。
例：n=1237,则输出为：
1237，
2474，
4948，
9896，
9896，
4948，
2474，
1237， 
提示：写程序时，先按递增方式的代码，写好递增的以后，再增加考虑递减部分*/
public class Test2 {
	public static void main(String[] args) {
		int x=1237;
		doubleNum(x);
	}
	public static void doubleNum(int n)
	{
		System.out.println("1递增部分---------------"+n);
		if(n<=5000)
			doubleNum(n*2);
		System.out.println("2递减部分---------------"+n);
	}
}
