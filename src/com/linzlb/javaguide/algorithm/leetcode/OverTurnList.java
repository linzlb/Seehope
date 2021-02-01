package com.linzlb.javaguide.algorithm.leetcode;

/**
 * @Author: linzhengli
 * @Tel: 13570921913
 * @Date: 2021/1/27 14:40
 * @Function: Over turn list
 */
public class OverTurnList {

    public ListNode reverseList(ListNode head){
        ListNode next = null;
        ListNode pre = null;
        while (head!=null){

            next = head.next;
            head.next = pre;
            pre = head;
            head = next;
        }
        return pre;
    }

    public static void main(String[] args) {
        ListNode a = new ListNode(1);
        ListNode b = new ListNode(2);
        ListNode c = new ListNode(3);
        ListNode d = new ListNode(4);
        ListNode e = new ListNode(5);
        a.next = b;
        b.next = c;
        c.next = d;
        d.next = e;
        new OverTurnList().reverseList(a);
        while (e!=null){
            System.out.print(e.val+"->");
            e=e.next;
        }
    }
}

