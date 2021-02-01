package com.linzlb.javaguide.datastructure.queueandstack;

import java.util.Stack;

/**
 * @Author: linzhengli
 * @Tel: 13570921913
 * @Date: 2021/1/27 19:13
 * @Function:栈对压入和弹出
 * 输入2个整数序列，第一个为栈的压入顺序，判断第二个是否为该栈第弹出顺序
 * 思路：
 * 借用一个辅助的栈，遍历压栈顺序。
 */
public class MyStack {

    public boolean isPopOrder(int[] pushA, int[] popA){
        if (pushA.length==0 || popA.length==0){
            return false;
        }
        Stack<Integer> s = new Stack<>();
        //用于标识弹出序列的位置
        int popIndex = 0;
        for(int i=0; i<pushA.length; i++){
            s.push(pushA[i]);
            //如果栈不为空，且栈顶元素等于弹出序列
            while (!s.empty() && s.peek()==popA[popIndex]){
                //出栈
                s.pop();
                //弹出序列向后1位
                popIndex++;
            }
        }
        return s.empty();
    }
}
