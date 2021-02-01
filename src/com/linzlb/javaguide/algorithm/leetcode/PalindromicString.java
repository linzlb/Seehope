package com.linzlb.javaguide.algorithm.leetcode;

import java.util.HashSet;

/**
 * @Author: linzhengli
 * @Tel: 13570921913
 * @Date: 2021/1/27 11:11
 * @Function:
 * ���Ĵ� ��һ������������һ�����ַ���
 * ���Թ��ɻ��Ĵ���2�������
 *  aabb  aabcc
 */
public class PalindromicString {
    private static int index,len;

    //�����ַ�����������Թ������������Ĵ�����
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

    //��֤�Ƿ���Ĵ�,ֻ�������ֺ�Ӣ��
    public static boolean isPalindrome(String s){
        if (s==null || s.length()==0){
            return true;
        }
        int head = 0;
        int tail = s.length()-1;
        while (head<tail){
            //��ͷ��β���м�Ƚ�
            if(!Character.isLetterOrDigit(s.charAt(head))){
                //˵���ַ�������ĸ��������
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

    //����һ���ַ������ҵ��ַ�������Ļ����Ӵ�
    public static String longestPalindromeSubString(String s){
        if (s == null || s.length()<2){
            return s;
        }
        for (int i=0;i<s.length();i++){
            palindromeHelper(s,i,i);//��������������
            palindromeHelper(s,i,i+1);//ż������������
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
