package com.linzlb.labuladong.entry;

/**
 * @Author: linzhengli
 * @Tel: 13570921913
 * @Date: 2021/2/5 09:28
 * @Function:二叉树节点 Definition for a binary tree node.
 *      二叉树类型节点固定模板
 *      节点定义： 节点值/左节点/右节点
 *      构造方法定义：给自己节点赋值/给自己节点赋值并定义左/右节点
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


     //二叉树遍历框架
    private void traverse(TreeNode root){
        //前序遍历 ~
        traverse(root.left);
        //中序遍历 ~
        traverse(root.right);
        //后序遍历 ~
    }
}
