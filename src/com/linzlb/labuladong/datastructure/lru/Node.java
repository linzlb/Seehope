package com.linzlb.labuladong.datastructure.lru;

/**
 * @Author: linzhengli
 * @Tel: 13570921913
 * @Date: 2021/2/4 13:49
 * @Function:�����Node�ڵ�
 */
public class Node {

    //�ڵ���key������Ϊ��map�п���ͨ��key�ҵ���Ӧ��node�������в���
    //����Ҫ���ǣ�ɾ��node��Ҫɾ��map�����Ӧ�Ľڵ㣬����������Ҫ��¼key
    public int key, val;
    public Node next, prev;
    public Node(int k, int v){
        this.key = k;
        this.val = v;
    }
}
