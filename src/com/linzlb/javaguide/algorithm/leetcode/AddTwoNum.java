package com.linzlb.javaguide.algorithm.leetcode;

/**
 * @Author: linzhengli
 * @Tel: 13570921913
 * @Date: 2021/1/27 14:22
 * @Function:两数相加
 * 给定2个非空链表来表示2个非负整数，位数按照逆序方式存储，每个节点代表单个数字
 * eg.
 * 342+465=807
 * 2->4->3  + 5->6->4  =  7->0->8
 *
 * 对头节点进行操作时，考虑创建哑节点dummy，使用dummy->next表示真正的头节点，避免处理头节点为null的边界问题
 */
public class AddTwoNum {

    public ListNode add(ListNode l1, ListNode l2){
        ListNode dummyHead = new ListNode(0);
        ListNode p=l1, q=l2, curr=dummyHead;
        int carry=0;//表示进位
        while (p!=null || q!=null){
            int x = (p!=null)?p.val:0;
            int y = (q!=null)?q.val:0;
            int sum = carry+x+y;
            carry=sum/10;
            //新节点的值为sum%10
            curr.next=new ListNode(sum%10);
            curr = curr.next;
            if (p!=null)
                p=p.next;
            if (q!=null)
                q=q.next;
        }
        if (carry>0){
            curr.next = new ListNode(carry);
        }
        return dummyHead.next;
    }
}