package com.linzlb.labuladong.datastructure;

import java.util.LinkedHashMap;

/**
 * @Author: linzhengli
 * @Tel: 13570921913
 * @Date: 2021/2/4 15:00
 * @Function:用LinkHashMap实现LRU
 */
public class LRUbyLinkedHashMap {

    int cap;//最大容量
    LinkedHashMap<Integer, Integer> cache = new LinkedHashMap<>();

    public LRUbyLinkedHashMap(int cap) {
        this.cap = cap;
    }

    private void makeRecently(int key){
        int val = cache.get(key);
        //删除key，重新插入队尾
        cache.remove(key);
        cache.put(key, val);
    }

    public int get(int key){
        if (!cache.containsKey(key)){
            return -1;
        }
        //将key变为最近使用
        makeRecently(key);
        return cache.get(key);
    }

    public void put(int key, int val){
        if (cache.containsKey(key)){
            cache.put(key, val);
            makeRecently(key);
            return;
        }
        if (cache.size() >= this.cap){
            //链表头部是最久未使用的key
            int oldKey = cache.keySet().iterator().next();
            cache.remove(oldKey);
        }
        cache.put(key, val);
    }
}
