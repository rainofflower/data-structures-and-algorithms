package com.yanghui.string.matching;

import org.junit.Test;

/**
 *  KMP算法
 *  借助next数组，发生不匹配时，让模式串（子串）回溯到尽量往后的位置，而不是bf算法中的将主串回溯到 i-j+1的位置，子串从头开始
 * @author YangHui
 */
public class KMP {

    @Test
    public void test(){
        char[] s = {'a','b','a','c','b','e','a','c'};
        char[] t = {'b'};
        int r = kmp(s, t, 1);
        System.out.println(r);
    }

    /**
     *
     * @param s 主串
     * @param t 子串
     * @param pos 从什么位置开始匹配（1开始）
     * @return 第一次匹配上的位置
     */
    int kmp(char[] s, char[] t, int pos){
        int i = pos - 1;
        int j = 0;
        int[] next = new int[t.length];
        getNext(t, next);
        while(i <= s.length-1 && j <= t.length-1){
            if(s[i] == t[j]){
                j++;
            }else{
                j = next[j];
            }
            i++;
        }
        if(j >= t.length){
            return i - t.length;
        }else{
            return -1;
        }
    }

    /**
     * 获取next数组
     * @param t 模式串（子串）
     * @param next 初始化后的next数组
     */
    void getNext(char[] t, int[] next){
        next[0] = 0; //第1个永远是0
        int length = t.length;
        int i = 1; //后缀下标
        int j = 0; //前缀下标
        while(i <= length-1){
            if(j == 0){
                next[i] = 0;
                i++;
                j++;
            }
            else if(t[i] == t[j]){
                //前后缀相等，都往后移一位
                i++;
                j++;
                if(t[i] != t[j]){
                    //后移移位之后不相等，next数组i下标位置设置为j
                    next[i] = j;
                }else{
                    //否则等于前缀后一位的值
                    next[i] = next[j];
                }
            }else{
                //前后缀不相等，前缀回到next数据j下标的值
                j = next[j];
            }
        }
    }

}
