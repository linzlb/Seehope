package com.linzlb.javaguide.bigdecimal;

import java.math.BigDecimal;
import java.util.Objects;

/**
 * BigDecimal
 * @author jiangwan.lin@tuya.com
 * @since 2021-09-01 11:38 上午 / V1.0
 */
public class Test {

    //浮点数之间的等值判断，基本数据类型不能用==来比较，包装数据类型不能用 equals 来判断。
    private static void test1(){
        float a = 1.0f - 0.9f;
        float b = 0.9f - 0.8f;
        System.out.println(a);// 0.100000024
        System.out.println(b);// 0.099999964
        System.out.println(a == b);// false
    }

    //使用 BigDecimal 来定义浮点数的值，再进行浮点数的运算操作。
    private static void test2(){
        BigDecimal a = new BigDecimal("1.0");
        BigDecimal b = new BigDecimal("0.9");
        BigDecimal c = new BigDecimal("0.8");

        BigDecimal x = a.subtract(b);
        BigDecimal y = b.subtract(c);

        System.out.println(x); /* 0.1 */
        System.out.println(y); /* 0.1 */
        System.out.println(Objects.equals(x, y)); /* true */
    }
    public static void main(String[] args) {
        test1();
        test2();
    }
}
