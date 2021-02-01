package com.linzlb.javaguide.algorithm.paixu;

public class Demo2 {
	public static void main(String[] args) { 
		int[] array = {10,-3,5,34,-34,5,0,9}; //test data 
		System.out.println("排序前：");
		for(int arg : array) { 
			System.out.print(arg + " "); 
		}
		//排序方法
		sort(array);
		System.out.println("\n排序后：");
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
					//交换 
					temp = array[j]; 
					array[j] = array[j+1]; 
					array[j+1] = temp; 
					isSort = true; 
				} 
			} 
			if(!isSort) break; //如果没有发生交换，则退出循环 
		} 
	} 
}
