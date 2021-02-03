package com.linzlb.labuladong;

import com.linzlb.javaguide.algorithm.leetcode.ListNode;

/**
 * @Author: linzhengli
 * @Tel: 13570921913
 * @Date: 2021/2/3 14:16
 * @Function:����ָ��  �����������
 */
public class FastSlowPointer {

    //����ָ���Ӧ��1���ж������Ƿ��л�
    public static boolean hasCycle(ListNode head){
        ListNode fast, slow;
        fast = slow = head;
        while (fast!=null && slow!=null){
            fast = fast.next.next;
            slow = slow.next;
            //����л�������ָ��ͻ�����
            if (fast==slow){
                return true;
            }
        }
        return false;
    }

    //����ָ���Ӧ��2�����л�����Ļ���ʼλ��
    public static ListNode cycleAddr(ListNode head){
        ListNode fast, slow;
        fast = slow = head;
        while (fast!=null && slow!=null){
            fast = fast.next.next;
            slow = slow.next;
            //����л�������ָ��ͻ�����
            if (fast==slow){
                break;
            }
        }
        slow = head;
        while (slow!=fast){
            fast = fast.next;
            slow = slow.next;
        }
        //2��ָ���������ǻ������
        return slow;
    }

    //����ָ���Ӧ��3�����޻�������м�λ��
    public static ListNode middle(ListNode head){
        ListNode fast, slow;
        fast = slow = head;
        while (fast!=null && fast.next!=null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }
}
