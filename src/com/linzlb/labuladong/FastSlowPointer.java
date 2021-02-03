package com.linzlb.labuladong;

import com.linzlb.javaguide.algorithm.leetcode.ListNode;

/**
 * @Author: linzhengli
 * @Tel: 13570921913
 * @Date: 2021/2/3 14:16
 * @Function:快慢指针  解决链表问题
 */
public class FastSlowPointer {

    //快慢指针的应用1：判断链表是否有环
    public static boolean hasCycle(ListNode head){
        ListNode fast, slow;
        fast = slow = head;
        while (fast!=null && slow!=null){
            fast = fast.next.next;
            slow = slow.next;
            //如果有环，快慢指针就会相遇
            if (fast==slow){
                return true;
            }
        }
        return false;
    }

    //快慢指针的应用2：求有环链表的环起始位置
    public static ListNode cycleAddr(ListNode head){
        ListNode fast, slow;
        fast = slow = head;
        while (fast!=null && slow!=null){
            fast = fast.next.next;
            slow = slow.next;
            //如果有环，快慢指针就会相遇
            if (fast==slow){
                break;
            }
        }
        slow = head;
        while (slow!=fast){
            fast = fast.next;
            slow = slow.next;
        }
        //2个指针相遇就是环的起点
        return slow;
    }

    //快慢指针的应用3：求无环链表的中间位置
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
