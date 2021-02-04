package com.linzlb.labuladong.coreroutine;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author: linzhengli
 * @Tel: 13570921913
 * @Date: 2021/2/4 09:27
 * @Function:���������㷨
 *  ����С�����ִ�
 */
public class SlidingWindow {

    public static String minWindow(String s, String t){
        if (s == null || t == null || t.equals("")) {
            return "";
        }
        // �ַ���Ҫ���ֵĴ���
        Map<Character, Integer> needs = new HashMap<Character, Integer>();
        // �����������ַ����ֵĴ���
        Map<Character, Integer> window = new HashMap<Character, Integer>();
        for(char ch:t.toCharArray()){
            needs.put(ch, needs.getOrDefault(ch, 0)+1);
        }
        int[] minRange = {Integer.MAX_VALUE, 0, 0};
        int left = 0, right = 0, count = 0;
        while(right < s.length()){
            char ch = s.charAt(right);
            // �����Ҫ���ַ�
            if(needs.containsKey(ch)){
                window.put(ch, window.getOrDefault(ch, 0)+1);
                // �����������������ˣ�count++
                if(window.get(ch).compareTo(needs.get(ch)) == 0){
                    count++;
                }
            }
            // ��С������Χ
            while(count == needs.size()){
                char c = s.charAt(left);
                if(window.containsKey(c)){
                    window.put(c, window.get(c)-1);
                    if(window.get(c).compareTo(needs.get(c)) < 0){
                        // ��ʱ��ȥ����� left�����ַ����պò�����������
                        // ˵���˴� left��right����С�ķ�Χ
                        if(right - left < minRange[0]){
                            minRange[1] = left;
                            minRange[2] = right;
                            minRange[0] = right - left;
                        }
                        count--;
                    }
                }
                left++;
            }
            right++;
        }
        if (minRange[0] == Integer.MAX_VALUE) {
            return "";
        }
        return s.substring(minRange[1], minRange[2] + 1);
    }
}
