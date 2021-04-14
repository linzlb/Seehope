package com.linzlb.lambda;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * @Author: linzhengli
 * @Tel: 13570921913
 * @Date: 2021/4/14 14:25
 * @Function:lambda表达式使用
 * System.out.println("============================");
 */
public class LambdaDemo2 {

    public void streamTest(){
        List<String> lists = new ArrayList<String>();
        lists.add("a1");
        lists.add("a2");
        lists.add("b1");
        lists.add("b2");
        lists.add("b3");
        lists.add("o1");

        //Filter 对流对象中的所有元素进行过滤，该操作是一个中间操作，
        // 这意味着你可以在操作返回结果的基础上进行其他操作
        lists.stream().filter(s -> s.startsWith("a"))
                .filter(s -> s.endsWith("1"))
                .forEach(System.out::println);
        System.out.println("============================");
        //结合 Comparator 接口，该操作返回一个排序后的流的视图
        //原始流不会变
        System.out.println("默认 Comparator：");
        lists.stream().sorted().forEach(System.out::println);
        System.out.println("自定义 Comparator：");
        lists.stream().sorted((p1,p2) -> p2.compareTo(p1)).forEach(System.out::println);
        System.out.println("============================");
        //结合Function接口，该操作可以将流对象中的每个元素映射为另一个元素
        lists.stream().map(String::toUpperCase)
                .sorted()
                .forEach(System.out::println);
        System.out.println("自定义映射规则：");
        Function<String,String> function = p -> {
            return p + ".txt";
        };
        lists.stream().map(String::toLowerCase)
                .map(function)
                .sorted()
                .forEach(System.out::println);
        System.out.println("============================");

        //完结方法
        //匹配 match
        //流对象中只要有一个元素匹配就返回true
        boolean anyWithA = lists.stream().anyMatch(s -> s.startsWith("a"));
        System.out.println(anyWithA);
        //流对象中只要所有元素匹配就返回true
        boolean allWithA = lists.stream().allMatch(s -> s.startsWith("a"));
        System.out.println(allWithA);
        System.out.println("============================");
        //收集 collect
        List<String> list =
                lists.stream().filter(p ->
                    p.startsWith("a")
                ).sorted().collect(Collectors.toList());
        list.stream().forEach(System.out::println);
        System.out.println("============================");
        //计数 count
        long count = lists.stream().count();
        System.out.println(count);
        System.out.println("============================");

        //规约 reduce
        Optional<String> optional =
                lists.stream().sorted()
                    .reduce((s1, s2) -> {
                        System.out.println(s1+"|"+s2);
                        return s1 + "==" +s2;
                    });

    }

//    串行排序：9945ms
//    并行排序：2293ms
    public void parallelStreamTest(){
        List<String> bigLists = new ArrayList<>();
        for (int i=0; i<10000000; i++) {
            UUID uuid = UUID.randomUUID();
            bigLists.add(uuid.toString());
        }
        long startTime = System.nanoTime();
        long count = bigLists.stream().sorted().count();
        long endTime = System.nanoTime();
        long millis = TimeUnit.NANOSECONDS.toMillis(endTime-startTime);
        System.out.println("串行排序："+millis+"ms");
        long startTime2 = System.nanoTime();
        long count2 = bigLists.parallelStream().sorted().count();
        long endTime2 = System.nanoTime();
        long millis2 = TimeUnit.NANOSECONDS.toMillis(endTime2-startTime2);
        System.out.print("并行排序："+millis2+"ms");
    }

    public static void main(String[] args) {
        LambdaDemo2 ld = new LambdaDemo2();
//        ld.streamTest();
        ld.parallelStreamTest();
    }
}
