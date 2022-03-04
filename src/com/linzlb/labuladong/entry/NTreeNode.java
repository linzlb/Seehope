package com.linzlb.labuladong.entry;

/**
 * @Author: linzhengli
 * @Tel: 13570921913
 * @Date: 2022/3/5 09:28
 * @Function: N叉树节点定义 ：值+子节点
 */
public class NTreeNode {
    public int val;
    public NTreeNode[] children;

    //N叉树遍历框架
    private void traverse(NTreeNode root){
        for (NTreeNode child : root.children) {
            traverse(child);
        }
    }
}
