package com.linzlb.javaguide.algorithm.digui;

/**
 * @Author: linzhengli
 * @Tel: 13570921913
 * @Date: 2021/1/27 17:20
 * @Function:Fibonacci,跳台阶问题
 * 一只?一次可以跳上1级台阶，也可以跳上2级，求?跳上n级台阶总共有几种跳法。
 * 分析：
 * 如果有2种跳法，1阶或2阶，
 *  1。第一次跳1阶，跳法是f(n-1)
 *  2。第一次跳2阶，跳法是f(n-2)
 * 所以总跳法是f(n)=f(n-1)+f(n-2) ,f(1)=1,f(2)=2
 */
public class JumpFloor {
    //递归～
    public int jumpFloor(int number){
        if (number <= 0){
            return 0;
        }else if (number == 1){
            return 1;
        }else if (number == 2){
            return 2;
        }
        return jumpFloor(number-2)+jumpFloor(number-1);
    }

    //递归效率低，用迭代优化～
    public int jumpFloor2(int number){
        if (number <= 0){
            return 0;
        }else if (number == 1){
            return 1;
        }else if (number == 2){
            return 2;
        }
        int first = 1, second = 2, third = 0;
        for (int i = 3; i <= number; i++){
            third = first+second;
            first = second;
            second = third;
        }
        return third;
    }

    //变态跳台阶问题
    //一只?一次可以跳上1级台阶，也可以跳上2级，也可以跳上n级，求?跳上n级台阶总共有几种跳法。
    //在n>2的时候，f(n)=f(n-1)+f(n-2)+...+f(1)=2^(n-1)
    public int jumpFloor3(int number){
        //2^(n-1) 用位移操作，更快
        return 1<<--number;
    }
}
