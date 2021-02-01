package com.linzlb.javaguide.algorithm.leetcode;

import java.util.Arrays;

/**
 * @Author: linzhengli
 * @Tel: 13570921913
 * @Date: 2021/1/27 10:55
 * @Function:���������ǰ׺��û�оͷ���""
 * ˼·������Array.sortΪ���������ٽ������һ��Ԫ�غ����һ��Ԫ�رȽ�
 */
public class FindLongestPublicPrefix {

    public static String find(String[] strs){
        //1.����쳣�����Ϸ��ķ���""
        if(!check(strs)){
            return "";
        }

        int len = strs.length;
        StringBuffer result = new StringBuffer();
        Arrays.sort(strs);
        int start = strs[0].length();
        int end = strs[len-1].length();
        int num = Math.min(start,end);
        for (int i=0;i<num;i++){
            if (strs[0].charAt(i) == strs[len-1].charAt(i)){
                result.append(strs[0].charAt(i));
            }else {
                break;
            }
        }
        return result.toString();
    }

    //��������Ƿ�Ϸ�
    public static boolean check(String[] strs){
        boolean flag = false;
        if(strs != null){
            for (int i=0; i<strs.length; i++) {
                if (strs[i] != null && strs[i].length() != 0){
                    flag = true;
                }else {
                    flag = false;
                    break;
                }
            }
        }
        return flag;
    }

    public static void main(String[] args) {
        String[] strs = {"client","car","cat"};
        System.out.print(find(strs));
    }
}
