package com.linzlb.labuladong.coreroutine;

import java.util.LinkedList;
import java.util.List;

/**
 * @Author: linzhengli
 * @Tel: 13570921913
 * @Date: 2021/2/2 14:52
 * @Function:ȫ�������� = n�� �����㷨����ȫ�Ǳ������
 * ʵ���Ͼ��Ǿ������ı�������
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

    //������������һ�鲻�ظ������֣��������ǵ�ȫ����
    public static List<List<Integer>> permute(int[] nums){
        //��¼·��
        LinkedList<Integer> track = new LinkedList<>();
        backtrack(nums, track);
        return res;
    }

    //·������¼��track��
    //ѡ���б�nums�в�����track�е�Ԫ��
    //����������numsԪ�ض���track�г���
    public static void backtrack(int[] nums, LinkedList<Integer> track){
        //������������
        if (track.size() == nums.length){
            res.add(new LinkedList(track));
            return;
        }
        for (int i=0; i<nums.length; i++){
            //�ų����Ϸ�ѡ��
            if (track.contains(nums[i])){
                continue;
            }
            //��ѡ��
            track.add(nums[i]);
            //������һ�������
            backtrack(nums, track);
            //ȡ��ѡ��
            track.removeLast();
        }
    }
}
