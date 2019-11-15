package com.yanghui.util;

public class PrintUtils {

    public static void printIntArray(int[] a){
        int length = a.length;
        for(int i = 0; i<length; ++i){
            System.out.print(a[i]+" ");
        }
        System.out.println();
    }
}
