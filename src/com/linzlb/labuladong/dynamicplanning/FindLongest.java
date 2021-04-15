package com.linzlb.labuladong.dynamicplanning;

import java.util.Arrays;

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

    //一维 最长递增子序列
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

    //二维，信封嵌套
    public int maxEnvelopes(int[][] envelopes) {
        if (envelopes.length == 0)
            return 0;
        // 按宽度升序排列，如果宽度⼀样，则按⾼度降序排列
        Arrays.sort(envelopes, (t1, t2) -> {
            if (t1[0] < t2[0])
                return -1;
            else if (t1[0] == t2[0]) {
                if (t1[1] > t2[1])
                    return -1;
                else if (t1[1] == t2[1])
                    return 0;
            }
            return 1;
        });
        // 对⾼度数组寻找 LIS
        int[] dp = new int[envelopes.length];
        Arrays.fill(dp, 1);
        int max = 1;
        for (int i = 1; i < envelopes.length; i++) {
            for (int j = 0; j < i; j++) {
                if (envelopes[i][1] > envelopes[j][1])
                    dp[i] = Math.max(dp[i], dp[j] + 1);
            }
            max = Math.max(max, dp[i]);
        }
        return max;
    }

    //for debug
    public static void main(String[] args) {
        int[] arry = new int[]{10,9,2,5,3,7,101,18};
        System.out.println(findLongest(arry));
    }

}