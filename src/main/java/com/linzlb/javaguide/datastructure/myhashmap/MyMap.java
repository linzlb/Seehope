package com.linzlb.javaguide.datastructure.myhashmap;

/**
 * @Author: linzhengli
 * @Tel: 13570921913
 * @Date: 2020/6/7 12:48
 * @Function: 定义我的Map接口
 */
public interface MyMap<K,V> {
    V put(K k, V v);
    V get(K k);
    int size();
    interface Entry<K,V>{
        K getKey();
        V getValue();
    }
}
