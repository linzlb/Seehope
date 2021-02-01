package com.linzlb.javaguide.algorithm.leetcode;

import com.linzlb.javaguide.algorithm.leetcode.ListNode;

/**
 * @Author: linzhengli
 * @Tel: 13570921913
 * @Date: 2021/1/27 17:14
 * @Function:�ϲ�2�����������
 * ����
 * ����A��B
 * A��B����A1��B1�Ƚϣ�����A1<B1,A1Ϊͷ�ڵ�
 * A2��B1�Ƚϣ�A1ָ��С��
 * ѭ������
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
