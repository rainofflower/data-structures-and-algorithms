package com.yanghui.algorithm.search;

import com.yanghui.util.PrintUtils;
import org.junit.Test;

import java.util.Arrays;
import java.util.Random;

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
//        int index = binarySearch(key, 0, num - 1, array);
        int index = binarySearch(array, key);
        if(index != -1){
            System.out.println("查找结果,index = "+index);
        }else{
            System.out.println("未找到结果");
        }
    }

    /**
     * 递归
     * @param key
     * @param low
     * @param high
     * @param array
     * @return
     */
    public static int binarySearch(int key, int low, int high,int[] array){
        int mid = (low + high) >> 1;
        if(array[mid] == key){
            return mid;
        }else if(low > high){
            //找不到
            return -1;
        }else{
            if(array[mid] < key){
                low = mid + 1;
                return binarySearch(key, low, high, array);
            }else{
                high = mid - 1;
                return binarySearch(key, low, high, array);
            }
        }
    }

    /**
     * 循环（非递归）
     * @param array
     * @param key
     * @return
     */
    public static int binarySearch(int[] array, int key){
       int length = array.length;
       int low = 0;
       int high = length - 1;
       while(low <= high){
           int mid = (low + high) >> 1;
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
