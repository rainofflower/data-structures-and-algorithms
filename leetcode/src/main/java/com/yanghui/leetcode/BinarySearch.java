package com.yanghui.leetcode;

import com.yanghui.leetcode.util.PrintUtils;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Random;
import java.util.stream.Collectors;

/**
 * 二分查找算法（折半查找）
 * 时间复杂度 O(log2n)
 * 分治思想：将一个大的问题分成许多小的模块，一一解决
 *
 * 二分查找每次排除掉一半的不适合值，所以对于n个元素的情况：
 *
 * 一次二分剩下：n/2
 * 两次二分剩下：n/2/2 = n/4
 * …
 * m次二分剩下：n/(2^m)
 *
 * 在最坏情况下是在排除到只剩下最后一个值之后得到结果，即
 *
 * n/(2^m)=1
 *
 * 所以由上式可得 ： 2^m=n
 *
 * 进而可求出时间复杂度为： log2(n)
 *
 * @author YangHui
 */
public class BinarySearch {

    @Test
    public void test(){
        int num = 20;
        int[] array = new int[num];
        Random random = new Random();
        for(int i = 0; i < num ; i++){
            array[i] = random.nextInt(10);
        }
        Arrays.sort(array);
        PrintUtils.printIntArray(array);
        System.out.println(binarySearch(array, 5));

        System.out.println(left_bound(array, 5));

        System.out.println(right_bound(array, 5));
    }

    /**
     * 二分查找目标位置
     */
   public int binarySearch(int[] nums, int target){
        int left = 0;
        //length-1，可以访问右边界
        int right = nums.length - 1;
        //搜索区间 两边都是闭区间，决定条件是 <=
        while(left <= right){
            int mid = left + (right - left) / 2;
            if(nums[mid] == target){
                return mid;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else if (nums[mid] > target) {
                right = mid - 1;
            }
        }
        return -1;
   }

    /**
     * 寻找左侧边界的二分查找
     */
    public int left_bound(int[] nums, int target){
        int left = 0;
        //length-1，可以访问右边界
        int right = nums.length - 1;
        //搜索区间 两边都是闭区间，决定条件是 <=
        while(left <= right){
            int mid = left + (right - left) / 2;
            if(nums[mid] == target){
                //锁定左侧边界，右侧边界左移
                right = mid -1;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else if (nums[mid] > target) {
                right = mid - 1;
            }
        }
        //上方while循环退出条件是left = right + 1 , 故需要判断left是否存在数组最右边越界
        if(left > nums.length || nums[left] != target){
            return -1;
        }
        return left;
    }

    /**
     * 寻找右侧边界的二分查找
     * @param nums
     * @param target
     * @return
     */
    public int right_bound(int[] nums, int target){
        int left = 0;
        int right = nums.length - 1;
        while(left <= right){
            int mid = left + (right - left) / 2;
            if(nums[mid] == target){
                //锁定右侧边界，左侧边界右移
                left = mid + 1;
            } else if (nums[mid] > target) {
                right = mid -1;
            } else if(nums[mid] < target){
                left = mid + 1;
            }
        }
        //上方while循环退出条件是left = right + 1 (right = left - 1), 故需要判断right是否存在数组最左边越界
        if(right < 0 || nums[right] != target){
            return -1;
        }
        return right;
    }

}
