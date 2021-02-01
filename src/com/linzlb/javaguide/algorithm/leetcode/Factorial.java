package com.linzlb.javaguide.algorithm.leetcode;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @Author: linzhengli
 * @Tel: 13570921913
 * @Date: 2020/6/7 13:20
 * @Function: 阶乘的实现
        如果使用操作系统的计算器来计算阶乘，数字一大就变成了科学计数法，后面的精度全部没了。
        这时怎么办呢~如果直接使用java，int，double不够用，此时就可以用下数据结构和算法的思想咯。
        阶乘实际上就是一个 大的数 * 一个普通的int范围的数
        这个大数就可以用数组来表示，然后从右往左进位，就小学加法的那种进位方式即可。
 */
public class Factorial {

    public static void main(String[] args) {
        //50!=? 大数字运算，int，double不够用的时候怎能么办？
        int n = 50;
        int[] ints = new int[100];
        ints[ints.length-1]=1;
        for (int i=1; i<=n; i++){
            ints=dashujisuan(ints,i);
        }
        showResult(ints);
    }

    /**
     * 去除前面的0并展示结果
     * @param ints
     */
    private static void showResult(int[] ints) {
        StringBuilder sb = new StringBuilder();
        System.out.print("不去除0的时候=");
        for (int i=0;i<ints.length;i++){
            sb.append(ints[i]);
            System.out.print(ints[i]);
        }
        System.out.println("");
        Pattern p = Pattern.compile("[1-9].*$");
        //创建Matcher对象
        Matcher m=p.matcher(sb.toString());
        if(m.find()) {
            System.out.println("格式处理后="+m.group(0));
        }
    }


    /**
     * 阶乘实际上就是一个 大数*一个普通的int范围的数
     * 用数组表示大数，然后*int范围的数，再进位
     * @param ints
     * @param num
     * @return
     */
    private static int[] dashujisuan(int[] ints, int num) {
        //计算每一位
        for (int i=0;i<ints.length;i++){
            ints[i]*=num;
        }
        //进位
        for (int i=ints.length-1;i>0;i--){
            ints[i-1]+=ints[i]/10;
            ints[i]=ints[i]%10;
        }
        return ints;
    }
}
