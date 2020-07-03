package com.yanghui.knowledge;

import com.yanghui.util.PrintUtils;
import org.junit.Test;

import java.util.Arrays;

/**
 *
 * @author yanghui
 * @date 2020-07-03
 **/
public class Copy {

    int[] nums1 = {1,2,3,0,0,0};
    int[] nums2 = {2,5,6};
    int m = 3,n = 3;

    @Test
    public void test1(){
        PrintUtils.printIntArray(nums1);
        /**
         * src:被copy的数组
         * srcPos:被copy数组起始下标
         * dest:copy到的目标数组
         * destPos:copy到目标数组开始下标
         * length:被copy数组元素数；srcPos起,srcPos+length-1结束,若srcPos+length-1超出srcPos,将会抛出java.lang.ArrayIndexOutOfBoundsException
         */
        System.arraycopy(nums2,0,nums1,3,3);
        PrintUtils.printIntArray(nums1);
    }

    @Test
    public void test2(){
        PrintUtils.printIntArray(nums1);
        merge(nums1,m,nums2,n);
        PrintUtils.printIntArray(nums1);
    }

    public void merge(int[] nums1, int m, int[] nums2, int n) {
        System.arraycopy(nums2, 0, nums1, m, n);
        Arrays.sort(nums1);
    }

}
