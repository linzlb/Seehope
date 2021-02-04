package com.linzlb.labuladong.datastructure.lru;

/**
 * @Author: linzhengli
 * @Tel: 13570921913
 * @Date: 2021/2/4 13:51
 * @Function:��Node�ڵ����˫������ {@link Node}
 * ʹ��˫����������Ϊɾ����ʱ����Ҫʹ�õ�ǰ������˫������ʱ�临�ӶȾͺܵ�
 */
public class DoubleList {

    //ͷβ��ڵ�
    private Node head, tail;
    //����Ԫ����
    private int size;

    public DoubleList(){
        //��ʼ��
        head = new Node(0, 0);
        tail = new Node(0, 0);
        head.next = tail;
        tail.prev = head;
        size = 0;
    }

    //������β����ӽڵ�x��ʱ�临�Ӷ�O(1)
    public void addLast(Node x){
        x.prev = tail.prev;
        x.next = tail;
        tail.prev.next = x;
        tail.prev = x;
        size++;
    }

    //ɾ�������е�x�ڵ㣨xһ�����ڣ�ʱ�临�Ӷ�O(1)
    public void remove(Node x){
        x.prev.next = x.next;
        x.next.prev = x.prev;
        size--;
    }

    //ɾ�������һ���ڵ㣬�����ظýڵ㣬ʱ�临�Ӷ�O(1)
    public Node removeFirst(){
        if (head.next == tail){
            return null;//ֻ��ͷβ��ڵ�Ŀ�����
        }
        Node first = head.next;
        remove(first);
        return first;
    }

    //���������ȣ�ʱ�临�Ӷ�O(1)
    public int size(){
        return size;
    }
}
