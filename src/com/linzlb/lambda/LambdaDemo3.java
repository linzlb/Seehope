package com.linzlb.lambda;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * 类的详细说明
 * 如果继承某个接口{@link StateContext}，提供一个链接，方便使用
 * 如果是过期的接口，那么请尽量提供用于替换的类的链接地址{@link StateContext}
 *
 * @param <S> 如果用到泛型，可以这样注释
 * @param <E> 如果用到泛型，可以这样注释
 * @author jiangwan.lin@tuya.com
 * @since 2021-06-24 11:37 上午 / V1.0
 */
public class LambdaDemo3 {

    public void streamTest(){
        //获取姓张而且名字3位的
        List<String> list = new ArrayList<>();
        Collections.addAll(list, "张无忌", "周芷若", "赵敏", "张强", "张三丰");
        list.stream().filter(name->name.startsWith("张")).filter((name)->name.length()==3).forEach(System.out::println);
        System.out.println();
        list.stream().filter(s -> s.contains("张")).forEach(System.out::println);
        System.out.println();
        list.stream().limit(3).forEach(System.out::println);
        System.out.println();
        Stream<String> stream = Stream.of("1", "2", "3", "4", "5", "6");
        stream.map(Integer::parseInt).forEach(System.out::print);
        System.out.println();
        //自然排序
        list.stream().sorted().forEach(System.out::println);
        //逆序
        list.stream().sorted(Comparator.reverseOrder()).forEach(System.out::println);
        System.out.println();
        list.stream().distinct().forEach(System.out::println);
        System.out.println();
        Stream<Integer> stream2 = Stream.of(1, -5, 9, 100, 0);
        //第一个参数是默认值
        //第二个参数：对数据进行处理的方式
        Integer reduce = stream2.reduce(0, Integer::sum);
        System.out.println("reduce = " + reduce);
        System.out.println();
    }

    public void streamTest2(){
        Stream<Integer> stream1 = Stream.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 0);
        //将Stream流中的结果保存到List集合中
        List<Integer> list = stream1.collect(Collectors.toList());
        list.forEach(System.out::println);

        //将Stream流中的结果保存到Set集合中
        Stream<Integer> stream2 = Stream.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 0);
        Set<Integer> set = stream2.collect(Collectors.toSet());
        set.forEach(System.out::println);

        //将Stream流中的结果保存到ArrayList集合中
        Stream<Integer> stream3 = Stream.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 0);
        ArrayList<Integer> arrayList = stream3.collect(Collectors.toCollection(ArrayList::new));
        arrayList.forEach(System.out::println);

        //将Stream流中的结果保存到HashSet集合中
        Stream<Integer> stream4 = Stream.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 0);
        HashSet<Integer> hashSet = stream4.collect(Collectors.toCollection(HashSet::new));
        hashSet.forEach(System.out::println);

        //Stream流中的数据转换成Object数组
        Stream<Integer> stream11 = Stream.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 0);
        Object[] array = stream11.toArray();
        System.out.println("Stream流转换为Object数组：" + Arrays.toString(array));

        //Stream流中的数据转换成String数组
        Stream<String> stream22 = Stream.of("1", "2", "3", "4", "5", "6", "7", "8", "9", "0");
        String[] strings = stream2.toArray(String[]::new);
        System.out.println("Stream流转换为String数组 = " + Arrays.asList(strings));
    }

    //分组，多级分组
    public void streamTest3(){
        Stream<Person> stream = Stream.of(
                new Person("赵丽颖", 52, 95, "女"),
                new Person("杨颖", 56, 86, "女"),
                new Person("迪丽热巴", 56, 99, "女"),
                new Person("黄晓明", 52, 77, "男"));

        //先根据性别分组，性别相同再按照年龄分组
        Map<String, Map<Integer, List<Person>>> map = stream.collect(Collectors.groupingBy(Person::getSex, Collectors.groupingBy(Person::getAge)));
        map.forEach((sex, v1) -> {
            System.out.println("sex = " + sex);
            Map<Integer, List<Person>> map1 = v1;
            map1.forEach((age, v2) -> {
                System.out.print(age + "---->");
                System.out.println("personList = " + v2);
            });
        });
    }

    public static void main(String[] args) {
        LambdaDemo3 ld = new LambdaDemo3();
        ld.streamTest3();
    }
}
