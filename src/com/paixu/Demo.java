package com.paixu;
import java.util.Calendar;
public class Demo {

	public static void main(String[] args) {

		int len = 80000;
		int arr1[] = new int[len];
		for(int i=0;i<len;i++){
			//�ó����������һ��1��1000����
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
		
		//������ǰ��ӡϵͳʱ��
		java.util.Calendar cal = Calendar.getInstance();
		System.out.println("����ǰ��"+cal.getTime()); 
		//s.sort(arr1);
		//b.sort(arr1);
		i.sort(arr1);
		//���»��ʵ������ΪgetInstance�ǵ�̬�ġ�
		cal = Calendar.getInstance();
		System.out.println("�����"+cal.getTime());; 
		
	}

}


//1.ð������
class Bubble{
	//���򷽷�
	public void sort(int arr[]){
		int temp=0;
		//����
		//���ѭ��������һ���߼���
		for(int i=0; i<arr.length-1; i++){
			//�ڲ�ѭ������ʼ�Ƚϣ�ǰ��ıȺ���Ĵ�ͽ���
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

//2.ѡ������,ÿ���ҵ���С����ǰ�档һֱѭ����ȥ
class Select{
	public void sort(int arr[]){
		//��Ϊ��һ������С��
		int temp=0;
		for(int j=0;j<arr.length-1;j++){
		
			int min = arr[j];
			//��¼��С�����±�
			int minIndex = j;
			for(int k=j+1;k<arr.length;k++){
				if(min>arr[k]){
					//�޸���С
					min=arr[k];
					minIndex=k;
				}
			}
			//���˳�forѭ������ҵ���ε���Сֵ
			temp=arr[j];
			arr[j]=arr[minIndex];
			arr[minIndex]=temp;
		}
	}
}


//3.��������
class InsertSort{
	public void sort(int arr[]){
		for(int i=1;i<arr.length;i++){
			int insertVal=arr[i];
			//insertVal׼����ǰһ�����Ƚ�
			int index=i-1;
			while(index>=0&&insertVal<arr[index]){
				//����arr[index]����ƶ�
				arr[index+1]=arr [index];
				//��index��ǰ�ƶ�
				index--;
			}
			//��insertVal���뵽�ʵ�λ��
			arr[index+1]=insertVal;
		}
	}
}
