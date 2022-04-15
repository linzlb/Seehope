package com.linzlb.javaguide.algorithm.leetcode;

/**
 * @Author: linzhengli
 * @Tel: 13570921913
 * @Date: 2021/1/27 14:40
 * @Function: Over turn list
 */
public class OverTurnList {

    //正常反转
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
    //纯递归反转链表,要画图看，不然不好理解
    public ListNode reverseList2(ListNode head){
        if (head==null || head.next==null){
            return head;
        }
        ListNode last = reverseList2(head.next);
        head.next.next = head;
        head.next = null;
        return last;
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

