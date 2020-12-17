package com.linzlb.javaguide.myhashmap;

/**
 * @Author: linzhengli
 * @Tel: 13570921913
 * @Date: 2020/6/7 12:50
 * @Function: 定义我的HashMap的数据结构（链表）
 */
public class MyEntry<K,V> implements MyMap.Entry {

    K k;
    V v;
    MyEntry<K,V> next;

    public MyEntry(K k, V v, MyEntry<K,V> next){
        this.k=k;
        this.v=v;
        this.next=next;
    }

    @Override
    public K getKey() {
        return k;
    }

    @Override
    public V getValue() {
        return v;
    }
}
