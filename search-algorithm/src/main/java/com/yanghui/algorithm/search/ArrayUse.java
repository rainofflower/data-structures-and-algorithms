package com.yanghui.algorithm.search;

import com.yanghui.util.PrintUtils;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.util.Arrays;
import java.util.Random;

@Slf4j
public class ArrayUse {

    @Test
    public void test(){
        int num = 10;
        int[] array = new int[num];
        Random random = new Random();
        for(int i = 0; i < num ; i++){
            array[i] = random.nextInt(100);
        }
        Arrays.fill(array, 3, 4, 50);
        PrintUtils.printIntArray(array);
        //二分查找之前需要先排序
        Arrays.sort(array);
        PrintUtils.printIntArray(array);
        //二分查找
        int index = Arrays.binarySearch(array, 50);
        log.info("查找 50 处在下标 {} 位置处",index);
    }
}
