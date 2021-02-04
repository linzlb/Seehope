package com.linzlb.labuladong.coreroutine;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author: linzhengli
 * @Tel: 13570921913
 * @Date: 2021/2/4 09:27
 * @Function:滑动窗口算法
 *  求最小覆盖字串
 */
public class SlidingWindow {

    public static String minWindow(String s, String t){
        if (s == null || t == null || t.equals("")) {
            return "";
        }
        // 字符需要出现的次数
        Map<Character, Integer> needs = new HashMap<Character, Integer>();
        // 滑动窗口中字符出现的次数
        Map<Character, Integer> window = new HashMap<Character, Integer>();
        for(char ch:t.toCharArray()){
            needs.put(ch, needs.getOrDefault(ch, 0)+1);
        }
        int[] minRange = {Integer.MAX_VALUE, 0, 0};
        int left = 0, right = 0, count = 0;
        while(right < s.length()){
            char ch = s.charAt(right);
            // 如果需要此字符
            if(needs.containsKey(ch)){
                window.put(ch, window.getOrDefault(ch, 0)+1);
                // 如果需求的量被满足了，count++
                if(window.get(ch).compareTo(needs.get(ch)) == 0){
                    count++;
                }
            }
            // 缩小左区域范围
            while(count == needs.size()){
                char c = s.charAt(left);
                if(window.containsKey(c)){
                    window.put(c, window.get(c)-1);
                    if(window.get(c).compareTo(needs.get(c)) < 0){
                        // 此时除去了这个 left处的字符，刚好不满足条件，
                        // 说明此处 left和right是最小的范围
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
