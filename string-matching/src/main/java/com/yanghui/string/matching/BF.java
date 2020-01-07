package com.yanghui.string.matching;

import org.junit.Test;

/**
 * bf算法
 * @author YangHui
 */
public class BF {

    @Test
    public void test(){
        char[] s = {'a','b','a','c'};
        char[] t = {'a','c'};
        int r = bf(s, t, 1);
        System.out.println(r);
    }

    int bf(char[] s, char[] t, int pos){
        int i = pos - 1;
        int j = 0;
        while(i <= s.length-1 && j <= t.length-1){
            if(s[i] == t[j]){
                i++;
                j++;
            }else{
                i = i - j + 1; // 主串回溯
                j = 0;  //子串从头开始
            }
        }
        if(j >= t.length-1){
            return i - t.length;
        }else{
            return 0;
        }
    }

}
