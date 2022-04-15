package com.linzlb.javaguide.algorithm.leetcode;

/**
 * @Author: linzhengli
 * @Tel: 13570921913
 * @Date: 2021/1/27 15:29
 * @Function:delete list node
 * eg.
 * 1->2->3->4->5, n=2, result:1->2->3->5
 * refer {@link BackwardsList}
 */
public class DeleteListNode {

    public ListNode removeKthFromTail(ListNode head, int k){
//        if (head==null || k<=0){
//            return null;
//        }
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode node1 = dummy, node2 = dummy;

        while(node1 != null){
            node1 = node1.next;
            if(k<1 && node1!=null){
                node2 = node2.next;
            }
            k--;
        }
        node2.next = node2.next.next;
        return dummy.next;
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
        ListNode result = new DeleteListNode().removeKthFromTail(a, 2);
        while (result!=null){
            System.out.print(result.val+"->");
            result=result.next;
        }
    }
}
