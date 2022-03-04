package com.linzlb.labuladong.datastructure.lru;

/**
 * @Author: linzhengli
 * @Tel: 13570921913
 * @Date: 2021/2/4 13:51
 * @Function:用Node节点组成双向链表 {@link Node}
 * 使用双向链表是因为删除的时候需要使用到前驱，有双向链表时间复杂度就很低
 */
public class DoubleList {

    //头尾虚节点
    private Node head, tail;
    //链表元素组
    private int size;

    public DoubleList(){
        //初始化
        head = new Node(0, 0);
        tail = new Node(0, 0);
        head.next = tail;
        tail.prev = head;
        size = 0;
    }

    //在链表尾部添加节点x，时间复杂度O(1)
    public void addLast(Node x){
        x.prev = tail.prev;
        x.next = tail;
        tail.prev.next = x;
        tail.prev = x;
        size++;
    }

    //删除链表中的x节点（x一定存在）时间复杂度O(1)
    public void remove(Node x){
        x.prev.next = x.next;
        x.next.prev = x.prev;
        size--;
    }

    //删除链表第一个节点，并返回该节点，时间复杂度O(1)
    public Node removeFirst(){
        if (head.next == tail){
            return null;//只有头尾虚节点的空链表
        }
        Node first = head.next;
        remove(first);
        return first;
    }

    //返回链表长度，时间复杂度O(1)
    public int size(){
        return size;
    }
}
