package com.paixu;
import java.util.Calendar;
public class Demo {

	public static void main(String[] args) {

		int len = 80000;
		int arr1[] = new int[len];
		for(int i=0;i<len;i++){
			//让程序随机产生一个1到1000的数
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
		
		//在排序前打印系统时间
		java.util.Calendar cal = Calendar.getInstance();
		System.out.println("排序前："+cal.getTime()); 
		//s.sort(arr1);
		//b.sort(arr1);
		i.sort(arr1);
		//重新获得实例，因为getInstance是单态的。
		cal = Calendar.getInstance();
		System.out.println("排序后："+cal.getTime());; 
		
	}

}


//1.冒泡排序法
class Bubble{
	//排序方法
	public void sort(int arr[]){
		int temp=0;
		//排序
		//外层循环，决定一共走几次
		for(int i=0; i<arr.length-1; i++){
			//内层循环，开始比较，前面的比后面的大就交换
			for(int j=0; j<arr.length-1-i; j++){
				if(arr[j]>arr[j+1]){
					//换位
					temp = arr[j];
					arr[j] = arr[j+1];
					arr[j+1] = temp;
				}
			}
		}
	}
}

//2.选择排序法,每次找到最小放在前面。一直循环下去
class Select{
	public void sort(int arr[]){
		//认为第一个是最小的
		int temp=0;
		for(int j=0;j<arr.length-1;j++){
		
			int min = arr[j];
			//记录最小数的下标
			int minIndex = j;
			for(int k=j+1;k<arr.length;k++){
				if(min>arr[k]){
					//修改最小
					min=arr[k];
					minIndex=k;
				}
			}
			//当退出for循环后就找到这次的最小值
			temp=arr[j];
			arr[j]=arr[minIndex];
			arr[minIndex]=temp;
		}
	}
}


//3.插入排序法
class InsertSort{
	public void sort(int arr[]){
		for(int i=1;i<arr.length;i++){
			int insertVal=arr[i];
			//insertVal准备和前一个数比较
			int index=i-1;
			while(index>=0&&insertVal<arr[index]){
				//将把arr[index]向后移动
				arr[index+1]=arr [index];
				//让index向前移动
				index--;
			}
			//将insertVal插入到适当位置
			arr[index+1]=insertVal;
		}
	}
}
