package com.linzlb.labuladong.datastructure.lru;

/**
 * @Author: linzhengli
 * @Tel: 13570921913
 * @Date: 2021/2/4 13:49
 * @Function:链表的Node节点
 */
public class Node {

    //节点有key，是因为在map中可以通过key找到对应的node，并进行操作
    //最重要的是，删除node后，要删除map里面对应的节点，所以链表需要记录key
    public int key, val;
    public Node next, prev;
    public Node(int k, int v){
        this.key = k;
        this.val = v;
    }
}
