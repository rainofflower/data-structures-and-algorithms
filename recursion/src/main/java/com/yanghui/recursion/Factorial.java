package com.yanghui.recursion;

import org.junit.Test;

/**
 * 计算阶乘 n!
 *
 * 1! = 1
 * n! = n*(n-1)!
 *
 * @author YangHui
 */
public class Factorial {

    @Test
    public void test1(){
        int n = 5;
        System.out.println(factorial(n));
    }

    private int factorial(int i){
        if(i == 1){
            return 1;
        }else{
            return i * factorial(i-1);
        }
    }
}
