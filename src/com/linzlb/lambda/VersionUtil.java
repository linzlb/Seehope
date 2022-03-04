package com.linzlb.lambda;

/**
 * 类的详细说明
 *
 * @author 哈尔（李泽贤 haer.li@tuya.com)
 * @since 2021/7/29 11:59 上午/v1
 */
public class VersionUtil {

    /**
     * 比较版本号
     *
     * @param version1 版本1
     * @param version2 版本2
     * @return version1 = version2 返回0 当大于返回1 当小于返回-1
     */
    public static int compareVersion(String version1, String version2) {
        String[] nums1 = version1.split("\\.");
        String[] nums2 = version2.split("\\.");
        int n1 = nums1.length, n2 = nums2.length;

        // compare versions
        int i1, i2;
        for (int i = 0; i < Math.max(n1, n2); ++i) {
            i1 = i < n1 ? Integer.parseInt(nums1[i]) : 0;
            i2 = i < n2 ? Integer.parseInt(nums2[i]) : 0;
            if (i1 != i2) {
                return i1 > i2 ? 1 : -1;
            }
        }
        // the versions are equal
        return 0;
    }

    /**
     * 比较升级策略优先级
     * @param s1 策略1
     * @param s2 策略2
     * @return s1优先返回1，s2优先返回-1
     */
    public static int compareStrategy(Integer s1, Integer s2){
        if (s1 == 3)
            return 1;
        if (s2 == 3)
            return -1;
        return 0;
    }

    public static void main(String[] args) {
        //System.out.println(compareVersion("1.2.1", "1.3.1"));
        System.out.println(compareStrategy(1, 1));
    }
}
