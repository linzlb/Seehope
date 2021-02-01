package com.linzlb.javaguide.algorithm.leetcode;

import com.linzlb.javaguide.algorithm.leetcode.ListNode;

/**
 * @Author: linzhengli
 * @Tel: 13570921913
 * @Date: 2021/1/27 15:17
 * @Function:���������еĵ�k���ڵ�
 * ������
 * ��������k���ڵ���������ĵ� L-k+1 ���ڵ�
 *
 * 2���ڵ�/ָ�룬һ���ڵ�node1�ȿ�ʼ�ܣ��ܵ�k-1���ڵ��
 * ��2���ڵ�node2��ʼ�ܣ���node1���꣬node2��ָ�Ľڵ���������� L-k+1 ���ڵ�
 * ���ַ�ʽһ�α����Ϳ����ҵ���ʱ�临�Ӷ�O(n)
 */
public class BackwardsList {

    public ListNode findKthFromTail(ListNode head, int k){
        if (head==null || k<=0){
            return null;
        }
        ListNode node1 = head, node2 = head;
        int count = 0;//��¼�ڵ����
        int index = k;//��¼kֵ
        while(node1 != null){
            node1 = node1.next;
            count++;
            if(k<1){
                node2 = node2.next;
            }
            k--;
        }
        //����ڵ����С������ĵ�����k���ڵ㣬�򷵻ؿ�
        if(count<index){
            return null;
        }
        return node2;
    }
}
