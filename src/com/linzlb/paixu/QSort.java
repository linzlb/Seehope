package com.linzlb.paixu;
/*快速排序思想：
一趟快速排序是：
1，随机产生一数列，选取第一个数（这里也可选其他的数）作为比较的基石，假设这个数为X,这样X=A[0]；设两个变量i=0，j=n-1；n是这个数列的长度
2，从前面开始找，找到第一个比A[0]大的数，找到了就与X交换
3，从后面开始找，找到第一个比A[0]小的数，找到了就与X交换
4，重复步骤2，3，直到i=j；
这样一趟快速排序就完成了；第一趟完成之后，X左边的数就全部小于X了，X右边的数九全部大于X，然后采用递归方式对X左边的数和X右边的数进行快速排序。 */
public class QSort {   
    /**  
       * @param pData 需要排序的数组  
       * @param left  左边的位置,初始值为0  
       * @param right 右边的位置,初始值为数组长度  
       */   
      public static void QuickSort(int[] pData,int left,int right)   
      {   
        int i,j;   
        int first,temp;   
        i = left;   
        j = right;   
        first = pData[left]; //这里选其他的数也行，不过一般选第一个  
        //一趟快速排序   
        while(true)   
        {   
        //从第二个数开始找大于中枢的数 ,从前面开始找大于pData[left]的数  
            while((++i)<right-1 && pData[i]<first);   
            //从最后一个数开始找第一个小于中枢pData[left]的数   
            while((--j)>left && pData[j]>first);   
            if(i>=j)   
                break;   
            //交换两边找到的数   
            temp = pData[i];   
            pData[i] = pData[j];   
            pData[j] = temp;   
     
        }   
        //交换中枢   
        pData[left] = pData[j];   
        pData[j] = first;   
        //递归快排中枢左边的数据   
        if(left<j)   
          QuickSort(pData,left,j);   
        //递归快排中枢右边的数据   
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