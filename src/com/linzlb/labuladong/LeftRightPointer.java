package com.linzlb.labuladong;

import java.util.function.LongFunction;

/**
 * @Author: linzhengli
 * @Tel: 13570921913
 * @Date: 2021/2/3 14:38
 * @Function:左右指针  解决数组问题
 */
public class LeftRightPointer {

    //左右指针的应用1：二分搜索

    /**
     搜索区间两端闭，while条件带等号，mid必须加减一
     */
    public static int binarySearch(int[] nums, int target){
        //初始化左右指针
        int left = 0;
        int right = nums.length - 1;
        while (left<=right){//while条件带等号～
//            int mid = (left+right)/2;
            int mid = left+(right-left)/2;//优化，因为上面的写法可能导致溢出～
            if (nums[mid] == target){
                return mid;
            }else if (nums[mid] < target){
                left = mid+1;
            }else if (nums[mid] > target){
                right = mid-1;
            }
        }
        return -1;
    }
    //如果寻找左右边界问题，在上面的解法上加上越界检查
    public static int leftBound(int[] nums, int target){
        //初始化左右指针
        int left = 0;
        int right = nums.length - 1;
        while (left<=right){//while条件带等号～
//            int mid = (left+right)/2;
            int mid = left+(right-left)/2;//优化，因为上面的写法可能导致溢出～
            if (nums[mid] == target){
                right = mid-1;
            }else if (nums[mid] < target){
                left = mid+1;
            }else if (nums[mid] > target){
                right = mid-1;
            }
        }
        //检查left越界的情况
        if (left>=nums.length || nums[left]!=target){
            return -1;
        }
        return left;
    }

    //左右指针的应用2:两数之和，有序数组凑数问题，数组有序就应该想到左右指针
    //写法和应用1差不多，这里略

    //左右指针的应用3:反转数组
    public static void reverse(int[] nums){
        int left = 0;
        int right = nums.length - 1;
        while (left<=right){
            //交换nums[left]和nums[right]
            int temp = nums[left];
            nums[left] = nums[right];
            nums[right] = temp;
            left++;
            right--;
        }
    }
}
