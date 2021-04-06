package com.linzlb.labuladong.coreroutine;

/**
 * @Author: linzhengli
 * @Tel: 13570921913
 * @Date: 2021/4/6 09:50
 * @Function: leetcode 124. 二叉树中的最大路径和
路径 被定义为一条从树中任意节点出发，沿父节点-子节点连接，达到任意节点的序列。
同一个节点在一条路径序列中 至多出现一次 。该路径 至少包含一个 节点，且不一定经过根节点。
路径和 是路径中各节点值的总和。
给你一个二叉树的根节点 root ，返回其 最大路径和 。
链接：https://leetcode-cn.com/problems/binary-tree-maximum-path-sum
 */
public class BinaryTreeMaxSide {

    int maxSum = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        maxGain(root);
        return maxSum;
    }

    /**
     * 空节点的最大贡献值等于 0。
     非空节点的最大贡献值等于节点值与其子节点中的最大贡献值之和（对于叶节点而言，最大贡献值等于节点值）。
     * @param root
     * @return
     */
    public int maxGain(TreeNode root) {
        if(root == null){
            return 0;
        }
        // 递归计算左右子节点的最大贡献值
        // 只有在最大贡献值大于 0 时，才会选取对应子节点
        int leftGain = Math.max(maxGain(root.left), 0);
        int rightGain = Math.max(maxGain(root.right), 0);

        //后序遍历

        // 节点的最大路径和取决于该节点的值与该节点的左右子节点的最大贡献值
        int priceNewpath = root.val + leftGain + rightGain;

        // 更新答案
        maxSum = Math.max(maxSum, priceNewpath);

        // 返回节点的最大贡献值
        return root.val + Math.max(leftGain, rightGain);
    }

    /* 测试
      -10
      / \
     9 [20]
       /  \
     [15] [7]
     */
    public static void main(String[] args) {
        BinaryTreeMaxSide bts = new BinaryTreeMaxSide();

        TreeNode l1 = new TreeNode(9);
        TreeNode r1l2 = new TreeNode(15);
        TreeNode r1r2 = new TreeNode(7);
        TreeNode r1 = new TreeNode(20, r1l2, r1r2);
        TreeNode root = new TreeNode(-10, l1, r1);

        System.out.print(bts.maxPathSum(root));
    }
}
