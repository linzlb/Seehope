package com.linzlb.javaguide.algorithm.paixu;
import java.util.Calendar;
public class Demo {

	public static void main(String[] args) {

		int len = 80000;
		int arr1[] = new int[len];
		for(int i=0;i<len;i++){

			int t = (int) (Math.random()*10000);
			arr1[i] = t;	
		}
		/*int arr[]={1,6,0,-1,9,-13,33};
		Bubble b=new Bubble();
		b.sort(arr);
		for(int i=0; i<arr.length; i++){
			System.out.print(arr[i]+"   ");
		}*/
		
		//Bubble b=new Bubble();
		//Select s = new Select();
		InsertSort i = new InsertSort();
		

		java.util.Calendar cal = Calendar.getInstance();
		System.out.println("����ǰ��"+cal.getTime()); 
		//s.sort(arr1);
		//b.sort(arr1);
		i.sort(arr1);

		cal = Calendar.getInstance();
		System.out.println("�����"+cal.getTime());; 
		
	}

}



class Bubble{

	public void sort(int arr[]){
		int temp=0;

		for(int i=0; i<arr.length-1; i++){

			for(int j=0; j<arr.length-1-i; j++){
				if(arr[j]>arr[j+1]){
					//��λ
					temp = arr[j];
					arr[j] = arr[j+1];
					arr[j+1] = temp;
				}
			}
		}
	}
}

class Select{
	public void sort(int arr[]){

		int temp=0;
		for(int j=0;j<arr.length-1;j++){
		
			int min = arr[j];
			int minIndex = j;
			for(int k=j+1;k<arr.length;k++){
				if(min>arr[k]){
					min=arr[k];
					minIndex=k;
				}
			}

			temp=arr[j];
			arr[j]=arr[minIndex];
			arr[minIndex]=temp;
		}
	}
}


class InsertSort{
	public void sort(int arr[]){
		for(int i=1;i<arr.length;i++){
			int insertVal=arr[i];

			int index=i-1;
			while(index>=0&&insertVal<arr[index]){

				arr[index+1]=arr [index];

				index--;
			}

			arr[index+1]=insertVal;
		}
	}
}
