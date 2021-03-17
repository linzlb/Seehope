package com.zasui.map;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * @Author: linzhengli
 * @Tel: 13570921913
 * @Date: 2021/3/4 11:27
 * @Function:Test 遍历hashmap
 */
public class TraverseMap {

    public static void main(String[] args) {

        // 创建并赋值 HashMap
        Map<Integer, String> map = new HashMap();
        map.put(1, "Java");
        map.put(2, "JDK");
        map.put(3, "Spring Framework");
        map.put(4, "MyBatis framework");
        map.put(5, "Java中文社群");

        //1迭代器EntrySet
        Iterator<Map.Entry<Integer, String>> iterator = map.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<Integer, String> entry = iterator.next();
            System.out.print(entry.getKey());
            System.out.print(entry.getValue());
        }
        //2迭代器 KeySet
        Iterator<Integer> iterator2 = map.keySet().iterator();
        while (iterator2.hasNext()) {
            Integer key = iterator2.next();
            System.out.print(key);
            System.out.print(map.get(key));
        }
        //3.ForEach EntrySet
        for (Map.Entry<Integer, String> entry : map.entrySet()) {
            System.out.print(entry.getKey());
            System.out.print(entry.getValue());
        }
        //4.ForEach KeySet
        for (Integer key : map.keySet()) {
            System.out.print(key);
            System.out.print(map.get(key));
        }
        //5lambda
        map.forEach((key, value) -> {
            System.out.print(key);
            System.out.print(value);
        });
        //6.Streams API 单线程
        map.entrySet().stream().forEach((entry) -> {
            System.out.print(entry.getKey());
            System.out.print(entry.getValue());
        });
        //7.Streams API 多线程
        map.entrySet().parallelStream().forEach((entry) -> {
            System.out.print(entry.getKey());
            System.out.print(entry.getValue());
        });
    }
}
