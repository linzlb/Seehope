package com.linzlb.javaguide.datastructure.myhashmap;

/**
 * @Author: linzhengli
 * @Tel: 13570921913
 * @Date: 2020/6/7 13:13
 * @Function:
 */
public class TestMyHashMap {

    public static void main(String[] args) {
        MyMap<String,Integer> map = new MyHashMap<>();
        Long startTime = System.currentTimeMillis();
        for (int i=0;i<1000;i++){
            map.put("age"+i,10);
        }
        for (int i=0;i<1000;i++){
            System.out.println(map.get("age"+i));
        }
        Long endTime = System.currentTimeMillis();
        System.out.println("size="+map.size());
        System.out.println("time="+(endTime-startTime));
    }
}
