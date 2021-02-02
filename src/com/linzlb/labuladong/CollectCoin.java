package com.linzlb.labuladong;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author: linzhengli
 * @Tel: 13570921913
 * @Date: 2021/2/2 14:01
 * @Function:����Ǯ���� ��̬�滮���⡫ ���ҳ�״̬ת�Ʒ���
 * ����k����ֵ��Ӳ�ң���ֵΪc1,c2,...,ck,ÿ��Ӳ����������
 * �ٸ�һ���ܽ��amount������������Ҫ��öӲ�Ҵճ�������
 */
public class CollectCoin {

    public static int[] coins = new int[]{1,2,5,10};//Ӳ�����

    //�����ƽ⣬ʱ�临�Ӷ�O(n^k)
    //coinsΪӲ����ֵ��amountΪĿ���� ,�ݹ�д��
    public static int coinChange(int amount){
        if (amount == 0){
            return 0;
        }
        if (amount < 0){
            return -1;
        }
        int res = Integer.MAX_VALUE;//����Сֵ���ȳ�ʼ��������
        for (int coin: coins){
            int subProblem = coinChange(amount-coin);
            if (subProblem == -1){
                continue;
            }
            res = Math.min(res, subProblem+1);
        }
        return res == Integer.MAX_VALUE ? -1 : res;
    }


    //����¼
    public static Map<Integer,Integer> map = new HashMap();
    //��Ϊ��"����¼"�ĵݹ飬ʱ�临�Ӷ�O(nk)
    public static int coinChange2(int amount){
        //�Ȳ鱸��¼
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
        int res = Integer.MAX_VALUE;//����Сֵ���ȳ�ʼ��������
        for (int coin: coins){
            int subProblem = coinChange2(amount-coin);
            if (subProblem == -1){
                continue;
            }
            res = Math.min(res, subProblem+1);
        }
        //���뱸��¼
        map.put(amount, res == Integer.MAX_VALUE ? -1 : res);
        return res == Integer.MAX_VALUE ? -1 : res;
    }

    public static void main(String[] args) {
//        System.out.println(coinChange(123));//����������������Ϊ�������̫��
        System.out.println(coinChange2(123));
    }
}
