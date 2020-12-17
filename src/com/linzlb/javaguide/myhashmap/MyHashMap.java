package com.linzlb.javaguide.myhashmap;

/**
 * @Author: linzhengli
 * @Tel: 13570921913
 * @Date: 2020/6/7 12:57
 * @Function: HashMap手写实现，简化版
 *            重点：1.put，get
 *                 2.hash
 *                 3.get中链表的时候递归查找
 */
public class MyHashMap<K,V>  implements MyMap<K,V> {

    //初始化长度
    private static int defaultLength = 1<<4;//16
    //达到3/4容量开始扩容
    private static double defaultLoader = 0.75;
    //hashmap的基础数据结构：数组，数组中为链表
    private MyEntry<K,V>[] table;
    //hashmap长度
    private int size = 0;

    //构造方法，初始化我的hashmap
    public MyHashMap(int length, double loader) {
        defaultLength = length;
        defaultLoader = loader;
        table = new MyEntry[defaultLength];
    }
    public MyHashMap() {
        this(defaultLength,defaultLoader);
    }

    @Override
    public V put(K k, V v) {
        size++;//插入时，先给hashmap加上一个长度
        int index = hash(k);//按照key获取hash值，用于确定放在map的哪个下标
        MyEntry<K,V> entry = table[index];//定位到table对index下标，尝试获取节点
        if (entry == null){
            table[index] = newEntry(k,v,null);//如果该下标下没有数据，就新增一个链表
        }else {
            table[index] = newEntry(k,v,entry);//如果有节点数据，那么将新数据放值第一个
        }
        return table[index].getValue();//返回table中index下标的第一个数据的Value
    }

    @Override
    public V get(K k) {
        int index = hash(k);//按照key获取hash值，用于确定放在map的哪个下标
        if (table[index]==null){
            return null;
        }
        return find(k,table[index]);
    }

    /**
     * 后移后递归查找数据
     * @param k
     * @param entry
     * @return
     */
    private V find(K k,MyEntry<K,V> entry){
        if (k==entry.getKey() || k.equals(entry.getKey())){
            if (entry.next != null) {
                System.out.println("老的value1="+entry.next.getValue());
            }
            return entry.getValue();
        }else {
            if (entry.next != null){
                System.out.println("老的value2="+entry.next.getValue());
                return find(k, entry.next);
            }
        }
        return null;
    }

    @Override
    public int size() {
        return size;
    }

    /**
     * 获取hash值，其他hash算法都可以；
     * 这里使用K的hash值，并对K的长度取模来模拟hash算法，对值取正；
     * @param k
     * @return
     */
    public int hash(K k){
        int m = defaultLength;
        int i = k.hashCode()%m;
        return i >= 0 ? i : -i;
    }

    /**
     * 链表增长时候的操作
     * @param k
     * @param v
     * @param next
     * @return
     */
    public MyEntry<K,V> newEntry(K k,V v,MyEntry<K,V> next){
        return new MyEntry<>(k,v,next);
    }
}
