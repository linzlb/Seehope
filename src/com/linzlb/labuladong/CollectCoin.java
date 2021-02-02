package com.linzlb.labuladong;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author: linzhengli
 * @Tel: 13570921913
 * @Date: 2021/2/2 14:01
 * @Function:凑零钱问题 动态规划问题～ 先找出状态转移方程
 * 给你k种面值的硬币，面值为c1,c2,...,ck,每种硬币数量无限
 * 再给一个总金额amount，问你最少需要几枚硬币凑出这个金额
 */
public class CollectCoin {

    public static int[] coins = new int[]{1,2,5,10};//硬币面额

    //暴力破解，时间复杂度O(n^k)
    //coins为硬币面值，amount为目标金额 ,递归写法
    public static int coinChange(int amount){
        if (amount == 0){
            return 0;
        }
        if (amount < 0){
            return -1;
        }
        int res = Integer.MAX_VALUE;//找最小值，先初始化个最大的
        for (int coin: coins){
            int subProblem = coinChange(amount-coin);
            if (subProblem == -1){
                continue;
            }
            res = Math.min(res, subProblem+1);
        }
        return res == Integer.MAX_VALUE ? -1 : res;
    }


    //备忘录
    public static Map<Integer,Integer> map = new HashMap();
    //改为带"备忘录"的递归，时间复杂度O(nk)
    public static int coinChange2(int amount){
        //先查备忘录
        if (map.containsKey(amount)){
            return map.get(amount);
        }
        //base case
        if (amount == 0){
            return 0;
        }
        if (amount < 0){
            return -1;
        }
        int res = Integer.MAX_VALUE;//找最小值，先初始化个最大的
        for (int coin: coins){
            int subProblem = coinChange2(amount-coin);
            if (subProblem == -1){
                continue;
            }
            res = Math.min(res, subProblem+1);
        }
        //记入备忘录
        map.put(amount, res == Integer.MAX_VALUE ? -1 : res);
        return res == Integer.MAX_VALUE ? -1 : res;
    }

    public static void main(String[] args) {
//        System.out.println(coinChange(123));//半天出不来结果，因为运算次数太大
        System.out.println(coinChange2(123));
    }
}
