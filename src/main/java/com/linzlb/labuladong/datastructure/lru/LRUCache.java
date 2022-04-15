package com.linzlb.labuladong.datastructure.lru;

import java.util.HashMap;

/**
 * @Author: linzhengli
 * @Tel: 13570921913
 * @Date: 2021/2/4 14:32
 * @Function:用自己实现的数据结构实现LRU算法
 */
public class LRUCache {

    //key -> Node(key,val)
    private HashMap<Integer, Node> map;
    //Node(k1,v1) <->Node(k2,v2)...  队尾是最近使用的
    private DoubleList cache;
    //最大容量
    private int cap;

    public LRUCache(int cap) {
        this.cap = cap;
        map = new HashMap<>();
        cache = new DoubleList();
    }

    public int get(int key){
        if (!map.containsKey(key)){
            return -1;
        }
        //将数据提升为最近使用的
        makeRecently(key);
        return map.get(key).val;
    }

    public void put(int key, int val){
        if (map.containsKey(key)){
            //删除旧数据
            deleteKey(key);
            //新插入的数据为最近使用的数据
            addRecently(key, val);
            return;
        }

        if (cap == cache.size()){
            removeLeastRecently();
        }
        addRecently(key, val);
    }


    //下面为常用操作
    //将某个key提升为最近使用的
    private void makeRecently(int key){
        //从链表删除再插入队尾
        Node x = map.get(key);
        cache.remove(x);
        cache.addLast(x);
    }

    //添加最近使用的元素
    private void addRecently(int key, int val){
        Node x = new Node(key, val);
        cache.addLast(x);
        map.put(key,x);
    }

    //删除某一个key
    private void deleteKey(int key){
        Node x = map.get(key);
        cache.remove(x);
        map.remove(key);
    }

    //删除最久未使用的元素
    private void removeLeastRecently(){
        //链表头部的第一个元素就是最久未使用
        Node delNode = cache.removeFirst();
        //同时记得删除map里面的指针
        int delKey = delNode.key;
        map.remove(delKey);
    }

}
