package com.linzlb.paixu;
/*��������˼�룺
һ�˿��������ǣ�
1���������һ���У�ѡȡ��һ����������Ҳ��ѡ������������Ϊ�ȽϵĻ�ʯ�����������ΪX,����X=A[0]������������i=0��j=n-1��n��������еĳ���
2����ǰ�濪ʼ�ң��ҵ���һ����A[0]��������ҵ��˾���X����
3���Ӻ��濪ʼ�ң��ҵ���һ����A[0]С�������ҵ��˾���X����
4���ظ�����2��3��ֱ��i=j��
����һ�˿������������ˣ���һ�����֮��X��ߵ�����ȫ��С��X�ˣ�X�ұߵ�����ȫ������X��Ȼ����õݹ鷽ʽ��X��ߵ�����X�ұߵ������п������� */
public class QSort {   
    /**  
       * @param pData ��Ҫ���������  
       * @param left  ��ߵ�λ��,��ʼֵΪ0  
       * @param right �ұߵ�λ��,��ʼֵΪ���鳤��  
       */   
      public static void QuickSort(int[] pData,int left,int right)   
      {   
        int i,j;   
        int first,temp;   
        i = left;   
        j = right;   
        first = pData[left]; //����ѡ��������Ҳ�У�����һ��ѡ��һ��  
        //һ�˿�������   
        while(true)   
        {   
        //�ӵڶ�������ʼ�Ҵ���������� ,��ǰ�濪ʼ�Ҵ���pData[left]����  
            while((++i)<right-1 && pData[i]<first);   
            //�����һ������ʼ�ҵ�һ��С������pData[left]����   
            while((--j)>left && pData[j]>first);   
            if(i>=j)   
                break;   
            //���������ҵ�����   
            temp = pData[i];   
            pData[i] = pData[j];   
            pData[j] = temp;   
     
        }   
        //��������   
        pData[left] = pData[j];   
        pData[j] = first;   
        //�ݹ����������ߵ�����   
        if(left<j)   
          QuickSort(pData,left,j);   
        //�ݹ���������ұߵ�����   
        if(right>i)   
          QuickSort(pData,i,right);   
      }   
     
      public static void main(String[] args){   
       
         int [] pData = new int[5];   
         for(int i = 0; i< 5; i++)   
              pData[i] = (int)(Math.random()*100);//Produce 10 random integers   
           
          for(int i = 0; i<pData.length; i++){   
              System.out.print(pData[i]+" ");    
          }  
          QSort.QuickSort(pData, 0, pData.length);   
           
          System.out.println("\n***********************");   
           
          for(int i = 0; i<pData.length; i++){   
              System.out.print(pData[i]+" ");   
          }  
      }    
 }  