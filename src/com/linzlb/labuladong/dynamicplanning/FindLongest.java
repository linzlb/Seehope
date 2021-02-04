package com.linzlb.labuladong.dynamicplanning;

/**
 * @Author: linzhengli
 * @Tel: 13570921913
 * @Date: 2021/2/4 09:53
 * @Function:���������������
 * eg.����nums=[10,9,2,5,3,7,101,18]
 * �����������������[2,3,7,101]
 *
 * ������
 * ��ά���������У��ŷ�Ƕ������
 * �ܶ��ŷ⣬��Ŀ���Ƕ��С�ģ���������Ƕ�׶��ٸ�������˹�������⣩
 * ����˼·��
 * �ȶԿ��W�����������У��������W��ͬ�ģ����߶�h�������У���Ϊ���һ������Ƕ�ף�
 * �ٶԸ߶�h��Ϊһ�����飬����������������г��ȣ��͵õ��𰸡�
 */
public class FindLongest {

    public static int findLongest(int[] arry) {
        int n = arry.length;
        //base case c[] ȫ����ʼ��Ϊ1
        int [] c=new int[n];
        for(int i=0; i<n; i++){
            c[i]=1;//��ʼ��Ϊ1
            for(int j=0; j<i; j++){
                if(arry[j]<arry[i]){
                    //��ѧ���ɷ���˼��
                    //�����һ������ǰ��һ�����Ǿͼ�1�������ǰ�������һ��
                    c[i]=Math.max(c[j]+1, c[i]);
                }
            }
        }
        //���±���һ�����飬�ҵ���ĵ��������г���
        int max=0;
        for(int i=0; i<n; i++){
            if(c[i]>max)
                max=c[i];
        }
        return max;
    }

    //for debug
    public static void main(String[] args) {
        int[] arry = new int[]{10,9,2,5,3,7,101,18};
        findLongest(arry);
    }

}
