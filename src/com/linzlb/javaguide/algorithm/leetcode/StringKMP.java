package com.linzlb.javaguide.algorithm.leetcode;

/**
 * @Author: linzhengli
 * @Tel: 13570921913
 * @Date: 2021/1/27 10:44
 * @Function: ���ַ�����ÿ���ո��滻Ϊ %20
 */
public class StringKMP {

    //����1����API
    public static String replaceSpace(StringBuffer str) {
        return str.toString().replaceAll("\\s", "%20");
    }

    //����2�����淽������String.charAt(i)�Լ�equels�жϿո�
    public static String replaceSpace2(StringBuffer str) {
        int len = str.length();
        StringBuffer result = new StringBuffer();
        for (int i=0; i<len; i++){
            char c = str.charAt(i);
            if (String.valueOf(c).equals(" ")){
                result.append("%20");
            }else {
                result.append(c);
            }
        }
        return result.toString();
    }
}
