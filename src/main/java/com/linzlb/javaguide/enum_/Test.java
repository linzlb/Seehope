package com.linzlb.javaguide.enum_;

/**
 * @Author: linzhengli
 * @Tel: 13570921913
 * @Date: 2020/12/18 10:09
 * @Function:
 */
public class Test {

    public static void main(String[] args) {
//        简单来说，我们通过上面的代码避免了定义常量，我们将所有和 pizza 订单的状态的常量都统一放到了一个枚举类型里面。
//        System.out.println(PizzaStatus.ORDERED.name());//ORDERED
//        System.out.println(PizzaStatus.ORDERED);//ORDERED
//        System.out.println(PizzaStatus.ORDERED.name().getClass());//class java.lang.String
//        System.out.println(PizzaStatus.ORDERED.getClass());//class shuang.kou.enumdemo.enumtest.PizzaStatus

        System.out.println(PinType.FORGET_PASSWORD.getCode());
        System.out.println(PinType.FORGET_PASSWORD.getMessage());
        System.out.println(PinType.FORGET_PASSWORD.toString());
    }
}
