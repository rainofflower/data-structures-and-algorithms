package com.yanghui.algorithm.sort;

import com.yanghui.util.PrintUtils;
import org.junit.Assert;
import org.junit.Test;

/**
 * 冒泡排序
 * 时间复杂度 O(n²)
 * 空间复杂度 O(1)
 * @author YangHui
 */
public class BubbleSort {

    @Test
    public void test(){
        int[] nums = new int[]{2,9,-4,5,0,7,8};
        PrintUtils.printIntArray(nums);
        sortArray(nums);
        PrintUtils.printIntArray(nums);
    }

    /**
     * 优化版，如果某一趟冒泡没有发生交换，退出外层循环
     * @param nums
     */
    public int[] sortArray(int[] nums) {
        int length = nums.length;
        for(int i = 0; i<length-1;i++){
            boolean flag = true;
            for(int j = 0; j<length-i-1;j++){
                if(nums[j] > nums[j+1]){
                    int temp = nums[j];
                    nums[j] = nums[j+1];
                    nums[j+1] = temp;
                    flag = false;
                }
            }
            if(flag){
                break;
            }
        }
        return nums;
    }
}
