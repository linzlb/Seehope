package com.linzlb.javaguide.algorithm.leetcode;

/**
 * @Author: linzhengli
 * @Tel: 13570921913
 * @Date: 2021/1/27 14:22
 * @Function:�������
 * ����2���ǿ���������ʾ2���Ǹ�������λ����������ʽ�洢��ÿ���ڵ����������
 * eg.
 * 342+465=807
 * 2->4->3  + 5->6->4  =  7->0->8
 *
 * ��ͷ�ڵ���в���ʱ�����Ǵ����ƽڵ�dummy��ʹ��dummy->next��ʾ������ͷ�ڵ㣬���⴦��ͷ�ڵ�Ϊnull�ı߽�����
 */
public class AddTwoNum {

    public ListNode add(ListNode l1, ListNode l2){
        ListNode dummyHead = new ListNode(0);
        ListNode p=l1, q=l2, curr=dummyHead;
        int carry=0;//��ʾ��λ
        while (p!=null || q!=null){
            int x = (p!=null)?p.val:0;
            int y = (q!=null)?q.val:0;
            int sum = carry+x+y;
            carry=sum/10;
            //�½ڵ��ֵΪsum%10
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

