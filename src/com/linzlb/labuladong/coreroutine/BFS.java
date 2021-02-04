package com.linzlb.labuladong.coreroutine;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

/**
 * @Author: linzhengli
 * @Tel: 13570921913
 * @Date: 2021/2/3 10:49
 * @Function:BFS 广度优先搜索
 */
public class BFS {

    //计算二叉树的最小高度
    //起点就是root节点，终点是离root最近的叶子节点（两个子节点都是null）
    //depth每增加一次，队列所有节点向前迈一步，保证了一旦找到终点，走的步数就是最少的，
    // 所以不需要遍历完整棵树，但是每次队列都要加载一层的节点，空间复杂度O(N)
    //如果是DFS算法，就是递归堆栈，最坏情况也是树的高度，空间复杂度O(logN)
    public static int minDepth(TreeNode root){
        if (root == null){
            return 0;
        }

        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);//向队列add新项

        //root自身就是1层，将depth初始化为1
        int depth = 1;
        while (!q.isEmpty()){
            int sz = q.size();
            //将当前队列中都所有节点向四周扩散
            for (int i=0; i<sz; i++) {
                TreeNode cur = q.poll();
                //判断是否到终点
                if (cur.left==null && cur.right==null){
                    return depth;
                }
                //将cur相邻节点加入队列
                if (cur.left!=null){
                    q.offer(cur.left);
                }
                if (cur.right!=null){
                    q.offer(cur.right);
                }
            }
            //在这里增加步数
            depth++;
        }
        return depth;
    }


    /**
    打开转盘锁：
     你有一个带4个滚轮的转盘锁，每个拨盘都是0-9十个数字，每个拨盘可以上下旋转
     例如0转到9，9转到0，每次旋转只能旋转一下
     拨盘4个轮初始都是0，用字符串"0000"表示，
     现在给你一个输入列表deadends和一个字符串target，其中target代表可以打开密码锁的数字
     deadends中包含一组"死亡数字"，你要避免拨出其中任何一个密码
     请计算从初始状态0000拨出target的最少次数，如果没法拨出，返回-1
     */
    //比如从0000开始，转一次，有
    //1000，9000，0100，0900，0010，0090，0001，0009 8种密码
    //再用上面八种密码为基础，再转，穷举所有可能
    //所以可以抽象成一幅图，每个节点有8个相邻节点，求最短距离
    //其他优化：
    //1.deads和visited集合都是不合法的集合，可以合并
    //2.双向BFS，从起点和终点同时开始扩散，两边有交集的时候停止
    public static int openLock(String[] deadends, String target){
        //记录需要跳过的死亡密码
        Set<String> deads = new HashSet<>();
        for (String s:deadends) {
            deads.add(s);
        }

        //记录以及穷举过的密码，防止走回头路
        Set<String> visited = new HashSet<>();

        Queue<String> q = new LinkedList<>();

        //从起点开始启动广度优先搜索
        int step = 0;
        q.offer("0000");
        visited.add("0000");

        while (!q.isEmpty()){
            int sz = q.size();
            //将当前队列中的所有节点向周围扩散
            for (int i=0; i<sz; i++){
                String cur = q.poll();

                //判断密码是否合法，是否到达终点
                if (deads.contains(cur)){
                    continue;
                }
                if (cur.equals(target)){
                    return step;
                }

                //将节点的未遍历相邻节点加入队列
                for (int j=0; j<4; j++){
                    String up = plusOne(cur, j);
                    if (!visited.contains(up)){
                        q.offer(up);
                        visited.add(up);
                    }
                    String down = minusOne(cur, j);
                    if (!visited.contains(down)){
                        q.offer(down);
                        visited.add(down);
                    }
                }
            }
            //在这里加步数
            step++;
        }
        //穷举完没找到密码，就是找不到了
        return -1;
    }
    //将s[j]向上拨动一次
    private static String plusOne(String s, int j){
        char[] ch = s.toCharArray();
        if (ch[j]=='9'){
            ch[j] = '0';
        } else {
            ch[j] += 1;
        }
        return new String(ch);
    }
    //将s[j]向下拨动一次
    private static String minusOne(String s, int j){
        char[] ch = s.toCharArray();
        if (ch[j]=='0') {
            ch[j] = '9';
        } else {
            ch[j] -= 1;
        }
        return new String(ch);
    }

}
class TreeNode{
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x){
        val=x;
    }
}