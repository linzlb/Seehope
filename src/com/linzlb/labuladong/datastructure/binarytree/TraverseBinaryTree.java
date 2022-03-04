package com.linzlb.labuladong.datastructure.binarytree;

import com.linzlb.labuladong.entry.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @Author: linzhengli
 * @Tel: 13570921913
 * @Date: 2021/2/5 10:34
 * @Function:遍历二叉树
 */
public class TraverseBinaryTree {

    String SEP = "  ";//分隔符
    String NULL = "#";
    StringBuffer sb = new StringBuffer();

    //前序框架  根 左 右
    void traverse_pre(TreeNode root){
        if (root == null){
            return;
        }
        //前序遍历
        System.out.print(root.val);
        traverse_pre(root.left);
        traverse_pre(root.right);
    }
    //后序框架  左 右 根
    void traverse_last(TreeNode root){
        if (root == null){
            return;
        }
        traverse_last(root.left);
        traverse_last(root.right);
        //后序遍历
        System.out.print(root.val);
    }
    //中序框架  左 右 根
    void traverse_mid(TreeNode root){
        if (root == null){
            return;
        }
        traverse_mid(root.left);
        //中序遍历
        System.out.print(root.val);
        traverse_mid(root.right);

    }
    //层级遍历框架
    void traverse_tier(TreeNode root){
        if (root == null){
            return;
        }
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        while (!q.isEmpty()){
            TreeNode cur = q.poll();
            System.out.println(root.val);
            if (cur.left != null){
                q.offer(cur.left);
            }
            if (cur.right != null){
                q.offer(cur.right);
            }
        }
    }


    //将二叉树遍历（序列化）为字符串
    void serialize2Str(TreeNode root){
        if (root == null){
            sb.append(NULL).append(SEP);//代表空指针
            return;
        }
        //前序遍历  根 左 右
        //System.out.print(root.val);
        sb.append(root.val).append(SEP);
        serialize2Str(root.left);
        serialize2Str(root.right);
    }

    //将字符串反序列化为二叉树
    TreeNode deserialize2Tree(String data){
        LinkedList<String> nodes = new LinkedList<>();
        for (String s:data.split(SEP)) {
            nodes.addLast(s);
        }
        return deserialize(nodes);
    }
    TreeNode deserialize(LinkedList<String> nodes){
        if (nodes.isEmpty()){
            return null;
        }
        //字符串最左就是根
        String first = nodes.removeFirst();
        if (first.equals(NULL)){
            return null;
        }
        TreeNode root = new TreeNode(Integer.parseInt(first));
        root.left = deserialize(nodes);
        root.right = deserialize(nodes);
        return root;
    }


    //git原理之二叉树最近公共祖先
    TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q){
        if (root == null){
            return null;
        }
        if (root==p || root==q){
            return root;
        }
        TreeNode left = lowestCommonAncestor(root.left, p , q);
        TreeNode right = lowestCommonAncestor(root.right, p , q);
        if (left!=null && right!=null){
            return root;
        }
        if (left==null && right==null){
            return null;
        }
        return left == null ? right : left;
    }
}
