package com.linzlb.javaguide.algorithm.gongyeshu;

import java.util.Scanner;

/*��2���������Լ������С������*/
public class YueshuBeishu {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("�������һ������");
		int num1 = scanner.nextInt();
		System.out.println("������ڶ�������");
		int num2 = scanner.nextInt();
		int big = big(num1,num2);
		int small = small(num1,num2);
		if(big==0 || small==0){
			System.out.println("�����Լ��ʱ����������Ϊ0");
		}else{
			System.out.println(num1+"��"+num2+"�����Լ���ǣ�"+big);
			System.out.println(num1+"��"+num2+"����С�������ǣ�"+small);
		}
	}

	/*�����Լ�����ϴ�������Խ�С������Ȼ�󽫽�С������Ϊ��һ�εĴ�����
	������ΪС����ֱ����С����Ϊ0�����ؽϴ����*/
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
			System.out.println("��������Ϊ0");
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
	
	//����С������������֮���������Լ��
	public static int small(int num1,int num2){
		int big = big(num1,num2);
		if(big==0){
			System.out.println("�����Լ��ʱ����������Ϊ0");
			return 0;
		}else{
			return(num1*num2)/big;
		}
		
	}
	  
}
