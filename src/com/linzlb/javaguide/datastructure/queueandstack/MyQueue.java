package com.linzlb.javaguide.datastructure.queueandstack;

import java.util.Stack;

/**
 * @Author: linzhengli
 * @Tel: 13570921913
 * @Date: 2021/1/27 19:06
 * @Function:��2��ջʵ��1�����У���ɶ��е�push��pop����
 */
public class MyQueue {
    Stack<Integer> s1 = new Stack<>();
    Stack<Integer> s2 = new Stack<>();

    public void push(int node){
        s1.push(node);
    }

    public int pop(){
        //����������ж�Ϊ�����׳��쳣��˵���û�û��push���κ�Ԫ��
        if(s1.empty() && s2.empty()){
            throw new RuntimeException("Queue is empty.");
        }
        //���s2��Ϊ��ֱ�Ӷ�s2����pop����
        if (s2.empty()){
            while (!s1.empty()){
                s2.push(s1.pop());
            }
        }
        return s2.pop();
    }
}
