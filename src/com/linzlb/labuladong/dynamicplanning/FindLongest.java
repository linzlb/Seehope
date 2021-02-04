package com.linzlb.labuladong.dynamicplanning;

/**
 * @Author: linzhengli
 * @Tel: 13570921913
 * @Date: 2021/2/4 09:53
 * @Function:查找最长递增子序列
 * eg.输入nums=[10,9,2,5,3,7,101,18]
 * 其中最长递增子序列是[2,3,7,101]
 *
 * 其他：
 * 二维递增子序列：信封嵌套问题
 * 很多信封，大的可以嵌套小的，求最多可以嵌套多少个（俄罗斯套娃问题）
 * 解题思路：
 * 先对宽度W进行升序排列，如果遇到W相同的，按高度h降序排列（因为宽度一样不能嵌套）
 * 再对高度h作为一个数组，求这个数组对最长子序列长度，就得到答案～
 */
public class FindLongest {

    public static int findLongest(int[] arry) {
        int n = arry.length;
        //base case c[] 全部初始化为1
        int [] c=new int[n];
        for(int i=0; i<n; i++){
            c[i]=1;//初始化为1
            for(int j=0; j<i; j++){
                if(arry[j]<arry[i]){
                    //数学归纳法的思想
                    //当最后一个数比前面一个大，那就加1，否则和前面的最大的一样
                    c[i]=Math.max(c[j]+1, c[i]);
                }
            }
        }
        //重新遍历一下数组，找到最长的递增子序列长度
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
