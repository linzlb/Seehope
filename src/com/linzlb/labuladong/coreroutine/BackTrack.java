package com.linzlb.labuladong.coreroutine;

import java.util.LinkedList;
import java.util.List;

/**
 * @Author: linzhengli
 * @Tel: 13570921913
 * @Date: 2021/2/2 14:52
 * @Function:全排列问题 = n！ 回溯算法，完全是暴力穷举
 * 实际上就是决策树的遍历问题
 */
public class BackTrack {

    public static List<List<Integer>> res = new LinkedList<>();

    public static void main(String[] args) {
        permute(new int[]{1,2,3});
        for (List<Integer> list:res) {
            for (Integer i:list){
                System.out.print(i+" ");
            }
            System.out.println();
        }
    }

    //主函数，输入一组不重复的数字，返回他们的全排列
    public static List<List<Integer>> permute(int[] nums){
        //记录路径
        LinkedList<Integer> track = new LinkedList<>();
        backtrack(nums, track);
        return res;
    }

    //路径：记录主track中
    //选择列表：nums中不存在track中的元素
    //结束条件：nums元素都在track中出现
    public static void backtrack(int[] nums, LinkedList<Integer> track){
        //触发条件结束
        if (track.size() == nums.length){
            res.add(new LinkedList(track));
            return;
        }
        for (int i=0; i<nums.length; i++){
            //排除不合法选择
            if (track.contains(nums[i])){
                continue;
            }
            //做选择
            track.add(nums[i]);
            //进入下一层决策树
            backtrack(nums, track);
            //取消选择
            track.removeLast();
        }
    }
}
