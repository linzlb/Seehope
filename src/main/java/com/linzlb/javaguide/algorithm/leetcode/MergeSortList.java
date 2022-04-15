package com.linzlb.javaguide.algorithm.leetcode;

import com.linzlb.javaguide.algorithm.leetcode.ListNode;

/**
 * @Author: linzhengli
 * @Tel: 13570921913
 * @Date: 2021/1/27 17:14
 * @Function:合并2个排序的链表
 * 分析
 * 链表A和B
 * A和B有序，A1和B1比较，假设A1<B1,A1为头节点
 * A2和B1比较，A1指向小的
 * 循环往复
 */
public class MergeSortList {

    public ListNode merge(ListNode l1, ListNode l2){
        if (l1 == null){
            return l2;
        }
        if (l2 == null){
            return l1;
        }
        if (l1.val <= l2.val){
            l1.next = merge(l1.next,l2);
            return l1;
        }else {
            l2.next = merge(l1,l2.next);
            return l2;
        }
    }
}