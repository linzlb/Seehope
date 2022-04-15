package com.linzlb.javaguide.algorithm.leetcode;

import java.util.HashSet;

/**
 * @Author: linzhengli
 * @Tel: 13570921913
 * @Date: 2021/1/27 11:11
 * @Function:
 * 回文串 是一个正读反读都一样的字符串
 * 可以构成回文串的2个情况：
 *  aabb  aabcc
 */
public class PalindromicString {
    private static int index,len;

    //输入字符串，计算可以构造出来的最长回文串长度
    public static int longestPalindrome(String s){

        if (s==null || s.length()==0){
            return 0;
        }
        HashSet<Character> hashSet = new HashSet<>();
        char[] chars = s.toCharArray();
        int count = 0;
        for (int i=0; i<chars.length; i++){
            if(!hashSet.contains(chars[i])){
                hashSet.add(chars[i]);
            }else {
                hashSet.remove(chars[i]);
                count++;
            }
        }
        return hashSet.isEmpty()?count*2:count*2+1;
    }

    //验证是否回文串,只考虑数字和英文
    public static boolean isPalindrome(String s){
        if (s==null || s.length()==0){
            return true;
        }
        int head = 0;
        int tail = s.length()-1;
        while (head<tail){
            //从头和尾往中间比较
            if(!Character.isLetterOrDigit(s.charAt(head))){
                //说明字符不是字母或者数组
                head++;
            }else if(!Character.isLetterOrDigit(s.charAt(tail))){
                tail--;
            }else {
                if (Character.toLowerCase(s.charAt(head)) !=
                        Character.toLowerCase(s.charAt(tail))){
                    return false;
                }
                head++;
                tail--;
            }
        }
        return true;
    }

    //给定一个字符串，找到字符串中最长的回文子串
    public static String longestPalindromeSubString(String s){
        if (s == null || s.length()<2){
            return s;
        }
        for (int i=0;i<s.length();i++){
            palindromeHelper(s,i,i);//奇数，往两边找
            palindromeHelper(s,i,i+1);//偶数，往两边找
        }
        return s.substring(index,index+len);
    }
    public static void palindromeHelper(String s,int left,int right){
        while (left>=0 && right<s.length() && s.charAt(left)==s.charAt(right)){
            left--;
            right++;
        }
        if (len<right-left-1){
            index=left+1;
            len=right-left-1;
        }
    }

}