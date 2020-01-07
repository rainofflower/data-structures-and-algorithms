package com.yanghui.recursion;

import org.junit.Test;

/**
 * 斐波那契数列（黄金分割数列、兔子数列）
 *
 * F(1)=1
 * F(2)=1
 * F(n)=F(n-1)+F(n-2) (n>=3)
 *
 * @author YangHui
 */
public class FibonacciSequence {

    @Test
    public void test(){
        int n = 40;
        for(int i=1; i<=n; i++){
            System.out.print(cal(i)+" ");
        }
    }

    private int cal(int i){
        int r;
        switch (i) {
            case 1:
                //返回
                r = 1;
                break;
            case 2:
                //返回
                r = 1;
                break;
            default:
                //递归
                r = cal(i-1) + cal(i-2);
                break;
        }
        return r;
    }

}
