package com.linzlb.labuladong.datastructure.binarytree;

import com.linzlb.labuladong.entry.TreeNode;

/**
 * @Author: linzhengli
 * @Tel: 13570921913
 * @Date: 2021/2/5 09:30
 * @Function:二叉树
 */
public class BinaryTree {

    //把所有节点值加1
    void plusAllNodeVal(TreeNode root){
        if (root == null){
            return;
        }
        root.val += 1;
        plusAllNodeVal(root.left);
        plusAllNodeVal(root.right);
    }

    //判断二叉树是否相同
    boolean isSameTree(TreeNode root1, TreeNode root2){
        if (root1==null && root2==null){
            return true;
        }
        if (root1==null || root2==null){
            return false;
        }
        if (root1.val != root2.val){
            return false;
        }

        return isSameTree(root1.left, root2.left)
                && isSameTree(root1.right, root2.right);

    }

    //判断BST（二叉树）合法性，注意点，每个节点应该小于右子树所有节点，大于左子树所有节点
    boolean isValidBST(TreeNode root){
        return isValidBST(root, null, null);
    }
    boolean isValidBST(TreeNode root,TreeNode min,TreeNode max){
        if (root==null){
            return true;
        }
        if (min!=null && root.val<=min.val){
            return false;
        }
        if (max!=null && root.val>=max.val){
            return false;
        }
        return isValidBST(root.left, min, root)
                && isValidBST(root.right, root, max);
    }

    //查找一个数是否存在
    boolean isInBST(TreeNode root, int target){
        if (root == null){
            return false;
        }
        if (root.val == target){
            return true;
        }
        return isInBST(root.left, target) ||
                isInBST(root.right, target);
    }
    //上面是递归写法，没有用上BST左小右大的特性
    boolean isInBST2(TreeNode root, int target){
        if (root == null){
            return false;
        }
        if (root.val == target){
            return true;
        }
        if(root.val < target){
            //说明在左子树，不需要遍历右边了
            return isInBST(root.left, target);
        }
        if(root.val > target){
            return isInBST(root.right, target);
        }
        return false;
    }

    //在BST插入一个数
    TreeNode insertInotBST(TreeNode root, int val){
        if (root == null){
            return new TreeNode(val);
        }
        if (root.val == val){
            return root;
        }
        if (root.val < val){
            return insertInotBST(root.left, val);
        }
        if (root.val > val){
            return insertInotBST(root.right, val);
        }
        return root;
    }

    //删除BTS的一个数
    TreeNode deleteNode(TreeNode root, int key){
        if (root == null)
            return null;
        if (root.val == key){
            if (root.left == null)
                return root.right;
            if (root.right == null)
                return root.left;
            TreeNode minNode = getMin(root.right);//用右子树最左（最小）值替换
            root.val = minNode.val;
            root.right = deleteNode(root.right, minNode.val);
        }else if (root.val > key){
            root.left = deleteNode(root.left, key);
        }else if (root.val < key){
            root.left = deleteNode(root.right, key);
        }
        return root;
    }
    TreeNode getMin(TreeNode root){
        while (root.left != null)
            root = root.left;
        return root;
    }

}
