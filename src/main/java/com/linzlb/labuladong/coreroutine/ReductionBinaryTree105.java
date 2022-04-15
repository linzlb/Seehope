package com.linzlb.labuladong.coreroutine;

import com.linzlb.labuladong.entry.TreeNode;

/**
 * @Author: linzhengli
 * @Tel: 13570921913
 * @Date: 2022/3/4 09:50
 * @Function: leetcode 105 通过前序和中序遍历还原二叉树
 */
public class ReductionBinaryTree105 {

    /**
     * @param preorder 前序顺序
     * @param inorder 中序顺序
     * @return
     */
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return build(preorder, inorder, 0, 0, inorder.length-1);
    }

    /**
     *
     * @param pre 前序顺序
     * @param in 中序顺序
     * @param preStart 前序排列中根节点位置
     * @param inStart 开始的下标
     * @param inEnd 结束的下标
     * @return
     */
    public TreeNode build(int[] pre, int[] in, int preStart, int inStart, int inEnd) {
        if (preStart > pre.length - 1 || inStart > inEnd)
            return null;
        //前序排列获取根节点
        TreeNode root = new TreeNode(pre[preStart]);
        int index = 0;//记录根节点的位置
        for (int i = inStart; i <= inEnd; i++) {
            //通过中序排列判断根节点位置
            if (root.val == in[i]) {
                index = i;
                break;
            }
        }
        //构建左右子树
        root.left = build(pre, in, preStart + 1, inStart, index - 1);//找出左子树的各个位置
        root.right = build(pre, in, preStart + index - inStart + 1, index + 1, inEnd);//找出右子树的各个位置
        return root;
    }



    /* 测试
      3
      / \
     9 [20]
       /  \
     [15] [7]
     */
    public static void main(String[] args) {
        ReductionBinaryTree105 bts = new ReductionBinaryTree105();
        int[] preorder = new int[]{3,9,20,15,7};
        int[] inorder = new int[]{9,3,15,20,7};
        TreeNode tree = bts.buildTree(preorder, inorder);
    }
}
