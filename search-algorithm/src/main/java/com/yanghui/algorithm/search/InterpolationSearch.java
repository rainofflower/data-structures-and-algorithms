package com.yanghui.algorithm.search;

import com.yanghui.util.PrintUtils;
import org.junit.Test;

import java.util.Arrays;
import java.util.Random;

/**
 * 插入查找
 *
 * 时间复杂度和二分查找一样，O(log2n)，实现上也和二分查找思想差不多，
 * 区别在于插入查找不再是找下标中间点折半，而是按值的比例分割。
 * @author YangHui
 */
public class InterpolationSearch {

    @Test
    public void test(){
        int num = 30;
        int[] array = new int[num];
        Random random = new Random();
        for(int i = 0; i < num ; i++){
            array[i] = random.nextInt(20);
        }
        //二分查找之前需要先排序！！
        Arrays.sort(array);
        PrintUtils.printIntArray(array);
        int key = 3;
        int index = interpolationSearch(array, key);
        if(index != -1){
            System.out.println("查找结果,index = "+index);
        }else{
            System.out.println("未找到结果");
        }
    }

    public static int interpolationSearch(int[] array, int key){
        int length = array.length;
        int low = 0;
        int high = length - 1;
        while(low <= high){
            //与二分查找唯一的区别。 mid = low + (下标长度乘以按值计算的比例)
            int mid = low + (key - array[low])/(array[high] - array[low])*(high-low);
            if(array[mid] == key){
                return mid;
            }else if(array[mid] > key){
                high = mid - 1;
            }else{
                low = mid + 1;
            }
        }
        return -1;
    }
}
