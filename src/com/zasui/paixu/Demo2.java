package com.zasui.paixu;

public class Demo2 {
	public static void main(String[] args) { 
		int[] array = {10,-3,5,34,-34,5,0,9}; //test data 
		System.out.println("����ǰ��");
		for(int arg : array) { 
			System.out.print(arg + " "); 
		}
		//���򷽷�
		sort(array);
		System.out.println("\n�����");
		for(int arg : array) { 
			System.out.print(arg + " "); 
		} 
	} 
	static void sort(int[] array) { 
		int length = array.length; 
		int temp; 
		boolean isSort; 
		for(int i = 1; i < length; i++) { 
			isSort = false; 
			for(int j = 0; j < length - i; j++) { 
				if(array[j] > array[j+1]) { 
					//���� 
					temp = array[j]; 
					array[j] = array[j+1]; 
					array[j+1] = temp; 
					isSort = true; 
				} 
			} 
			if(!isSort) break; //���û�з������������˳�ѭ�� 
		} 
	} 
}