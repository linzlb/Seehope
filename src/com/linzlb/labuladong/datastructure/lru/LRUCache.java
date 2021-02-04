package com.linzlb.labuladong.datastructure.lru;

import java.util.HashMap;

/**
 * @Author: linzhengli
 * @Tel: 13570921913
 * @Date: 2021/2/4 14:32
 * @Function:���Լ�ʵ�ֵ����ݽṹʵ��LRU�㷨
 */
public class LRUCache {

    //key -> Node(key,val)
    private HashMap<Integer, Node> map;
    //Node(k1,v1) <->Node(k2,v2)...  ��β�����ʹ�õ�
    private DoubleList cache;
    //�������
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
        //����������Ϊ���ʹ�õ�
        makeRecently(key);
        return map.get(key).val;
    }

    public void put(int key, int val){
        if (map.containsKey(key)){
            //ɾ��������
            deleteKey(key);
            //�²��������Ϊ���ʹ�õ�����
            addRecently(key, val);
            return;
        }

        if (cap == cache.size()){
            removeLeastRecently();
        }
        addRecently(key, val);
    }


    //����Ϊ���ò���
    //��ĳ��key����Ϊ���ʹ�õ�
    private void makeRecently(int key){
        //������ɾ���ٲ����β
        Node x = map.get(key);
        cache.remove(x);
        cache.addLast(x);
    }

    //������ʹ�õ�Ԫ��
    private void addRecently(int key, int val){
        Node x = new Node(key, val);
        cache.addLast(x);
        map.put(key,x);
    }

    //ɾ��ĳһ��key
    private void deleteKey(int key){
        Node x = map.get(key);
        cache.remove(x);
        map.remove(key);
    }

    //ɾ�����δʹ�õ�Ԫ��
    private void removeLeastRecently(){
        //����ͷ���ĵ�һ��Ԫ�ؾ������δʹ��
        Node delNode = cache.removeFirst();
        //ͬʱ�ǵ�ɾ��map�����ָ��
        int delKey = delNode.key;
        map.remove(delKey);
    }

}
