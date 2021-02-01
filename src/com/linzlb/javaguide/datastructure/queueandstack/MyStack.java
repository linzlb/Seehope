package com.linzlb.javaguide.datastructure.queueandstack;

import java.util.Stack;

/**
 * @Author: linzhengli
 * @Tel: 13570921913
 * @Date: 2021/1/27 19:13
 * @Function:ջ��ѹ��͵���
 * ����2���������У���һ��Ϊջ��ѹ��˳���жϵڶ����Ƿ�Ϊ��ջ�ڵ���˳��
 * ˼·��
 * ����һ��������ջ������ѹջ˳��
 */
public class MyStack {

    public boolean isPopOrder(int[] pushA, int[] popA){
        if (pushA.length==0 || popA.length==0){
            return false;
        }
        Stack<Integer> s = new Stack<>();
        //���ڱ�ʶ�������е�λ��
        int popIndex = 0;
        for(int i=0; i<pushA.length; i++){
            s.push(pushA[i]);
            //���ջ��Ϊ�գ���ջ��Ԫ�ص��ڵ�������
            while (!s.empty() && s.peek()==popA[popIndex]){
                //��ջ
                s.pop();
                //�����������1λ
                popIndex++;
            }
        }
        return s.empty();
    }
}
