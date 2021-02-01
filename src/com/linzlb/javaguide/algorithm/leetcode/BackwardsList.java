package com.linzlb.javaguide.algorithm.leetcode;

import com.linzlb.javaguide.algorithm.leetcode.ListNode;

/**
 * @Author: linzhengli
 * @Tel: 13570921913
 * @Date: 2021/1/27 15:17
 * @Function:倒数链表中的第k个节点
 * 分析：
 * 链表倒数第k个节点就是正数的第 L-k+1 个节点
 *
 * 2个节点/指针，一个节点node1先开始跑，跑到k-1个节点后，
 * 第2个节点node2开始跑，当node1跑完，node2所指的节点就是正数的 L-k+1 个节点
 * 这种方式一次遍历就可以找到，时间复杂度O(n)
 */
public class BackwardsList {

    public ListNode findKthFromTail(ListNode head, int k){
        if (head==null || k<=0){
            return null;
        }
        ListNode node1 = head, node2 = head;
        int count = 0;//记录节点个数
        int index = k;//记录k值
        while(node1 != null){
            node1 = node1.next;
            count++;
            if(k<1){
                node2 = node2.next;
            }
            k--;
        }
        //如果节点个数小于所求的倒数第k个节点，则返回空
        if(count<index){
            return null;
        }
        return node2;
    }
}
