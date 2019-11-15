package com.yanghui.algorithm.sort;

import com.yanghui.util.PrintUtils;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.util.Arrays;
import java.util.Random;

@Slf4j
public class ArraysUse {

    @Test
    public void test(){
        int num = 10;
        int[] array = new int[num];
        Random random = new Random();
        for(int i = 0; i < num ; i++){
            array[i] = random.nextInt(10);
        }
        PrintUtils.printIntArray(array);
        System.out.println();
        Arrays.sort(array);
        PrintUtils.printIntArray(array);
        System.out.println();
    }

}
