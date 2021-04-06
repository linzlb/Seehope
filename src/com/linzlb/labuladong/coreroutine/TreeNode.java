package com.linzlb.labuladong.coreroutine;

/**
 * @Author: linzhengli
 * @Tel: 13570921913
 * @Date: 2021/2/5 09:28
 * @Function:二叉树节点 Definition for a binary tree node.
 */
public class TreeNode{
    public int val;
    public TreeNode left;
    public TreeNode right;
    public TreeNode(int x){
        val=x;
    }
    public TreeNode(int val, TreeNode left, TreeNode right) {
         this.val = val;
         this.left = left;
         this.right = right;
     }
}
