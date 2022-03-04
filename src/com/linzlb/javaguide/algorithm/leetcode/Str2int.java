package com.linzlb.javaguide.algorithm.leetcode;

/**
 * @Author: linzhengli
 * @Tel: 13570921913
 * @Date: 2021/1/27 14:13
 * @Function:将字符串转为整数，不使用api
 */
public class Str2int {

    public static int str2int(String str){
        if (str==null || str.length()==0){
            return 0;
        }
        char[] chars = str.toCharArray();
        //判断符号
        int flag = 0;
        if (chars[0] == '+'){
            flag = 1;
        }else if (chars[0] == '-'){
            flag = 2;
        }
        int start = flag>0?1:0;
        int result = 0;
        for (int i=start; i<chars.length; i++){
            if (Character.isDigit(chars[i])){
                int temp = chars[i]-'0';
                result = result*10+temp;
            }else {
                return 0;//存在非数字
            }
        }
        return flag==2?-result:result;
    }
}