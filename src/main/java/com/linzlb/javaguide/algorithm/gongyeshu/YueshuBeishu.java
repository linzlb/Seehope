package com.linzlb.javaguide.algorithm.gongyeshu;

import java.util.Scanner;

/*求2个数的最大公约数和最小公倍数*/
public class YueshuBeishu {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("请输入第一个数：");
		int num1 = scanner.nextInt();
		System.out.println("请输入第二个数：");
		int num2 = scanner.nextInt();
		int big = big(num1,num2);
		int small = small(num1,num2);
		if(big==0 || small==0){
			System.out.println("求最大公约数时，除数不能为0");
		}else{
			System.out.println(num1+"和"+num2+"的最大公约数是："+big);
			System.out.println(num1+"和"+num2+"的最小公倍数是："+small);
		}
	}

	/*求最大公约数：较大的数除以较小的数，然后将较小的数作为下一次的大数，
	余数作为小数，直到较小的数为0，返回较大的数*/
	public static int big(int num1,int num2){
		int big = 0;
		int small = 0;
		if(num1>num2){
			big = num1;
			small = num2;
		}else{
			small = num1;
			big = num2;
		}
		if(small==0){
			System.out.println("除数不能为0");
			return 0;
		}
		while(true){
			if(small==0){
				return big;
			}else{
				int temp = big;
				big = small;
				small = temp%small;
			}
		}
	}

	//求最小公倍数：两数之积除以最大公约数
	public static int small(int num1,int num2){
		int big = big(num1,num2);
		if(big==0){
			System.out.println("求最大公约数时，除数不能为0");
			return 0;
		}else{
			return(num1*num2)/big;
		}

	}

}