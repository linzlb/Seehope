package com.linzlb.lambda;

import java.util.Objects;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

/**
 * @Author: linzhengli
 * @Tel: 13570921913
 * @Date: 2021/4/14 14:25
 * @Function:lambda表达式使用
 * System.out.println();
 */
public class LambdaDemo {

    //Predicate 用来逻辑判断
    //Function 用在输入输出的地方
    //Supplier 用在无输入有输出的地方
    //Consumer 用在有输入无输出的地方

    public void predicateTest(){
        Predicate<String> predicate = s -> s.length()>0;
        boolean test = predicate.test("test");
        System.out.println("字符串长度大于0："+test);
        test = predicate.test("");
        System.out.println("字符串长度大于0："+test);
        test = predicate.negate().test("");
        System.out.println("字符串长度小于0："+test);

        Predicate<Object> pre = Objects::isNull;
        Objects o1 = null;
        test = pre.test(o1);
        System.out.println("对象不为空："+test);
    }

    public void functionTest(){
        Function<String,Integer> toInt = Integer::valueOf;
        //toInt 的执行结果作为第二个backToString的输入
        Function<String,String> backToString = toInt.andThen(String::valueOf);
        String result = backToString.apply("1234");
        System.out.println(result);

        Function<Integer,Integer> add = i -> {
            System.out.println("first input:"+i);
            return i*2;
        };
        Function<Integer,Integer> zero = i -> {
            System.out.println("second input:"+i);
            return i*0;
        };
        Integer res = zero.apply(8);
        System.out.println(res);
    }

    public void supplierTest(){
        Supplier<String> supplier = () -> "special type value";
        String s = supplier.get();
        System.out.println(s);
    }

    public void consumerTest(){
        Consumer<Integer> add5 = i -> {
            System.out.println("old i="+i);
            i+=5;
            System.out.println("new i="+i);
        };
        add5.accept(10);
    }

    public static void main(String[] args) {
        LambdaDemo ld = new LambdaDemo();
//        ld.predicateTest();
//        ld.functionTest();
//        ld.supplierTest();
        ld.consumerTest();
    }
}
