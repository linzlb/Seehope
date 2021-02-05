package com.linzlb.javaguide.algorithm.leetcode;

/**
 * @Author: linzhengli
 * @Tel: 13570921913
 * @Date: 2021/2/5 14:26
 * @Function:k个一组反转链表 leetcode难度hard
 * 输入一个单链表和一个数k，以k个节点为一组反转，如果最后一组不足k个节点，保持原来顺序
 */
public class ReverseKGroup {

    //反转区间[a,b)的元素，左闭右开
    ListNode reverse(ListNode a, ListNode b){
        ListNode pre, cur, next;
        pre = null; cur = a; next = a;
        while (cur!=b){
            next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }

    ListNode reverseK(ListNode head, int k){
        if (head==null){
            return null;
        }
        ListNode a, b;
        a = b = head;
        for(int i=0; i<k; i++){
            //不足k个不反转  base case
            if (b==null){
                return head;
            }
            b = b.next;
        }
        ListNode newHead = reverse(a, b);
        a.next = reverseK(b, k);
        return newHead;
    }
}
