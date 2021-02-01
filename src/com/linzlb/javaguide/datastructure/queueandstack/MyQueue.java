package com.linzlb.javaguide.datastructure.queueandstack;

import java.util.Stack;

/**
 * @Author: linzhengli
 * @Tel: 13570921913
 * @Date: 2021/1/27 19:06
 * @Function:用2个栈实现1个队列，完成队列的push和pop操作
 */
public class MyQueue {
    Stack<Integer> s1 = new Stack<>();
    Stack<Integer> s2 = new Stack<>();

    public void push(int node){
        s1.push(node);
    }

    public int pop(){
        //如果两个队列都为空则抛出异常，说明用户没有push进任何元素
        if(s1.empty() && s2.empty()){
            throw new RuntimeException("Queue is empty.");
        }
        //如果s2不为空直接对s2进行pop操作
        if (s2.empty()){
            while (!s1.empty()){
                s2.push(s1.pop());
            }
        }
        return s2.pop();
    }
}
