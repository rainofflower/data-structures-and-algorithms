package com.yanghui.leetcode;

import org.junit.Test;

import java.util.HashMap;

/**
 * 76. 最小覆盖子串
 */
public class Problem76 {

    @Test
    public void test(){
        System.out.println(minWindow("a", "aa"));
    }

    public String minWindow(String s, String t) {
        //滑动窗口字符计数map
        HashMap<Character, Integer> window = new HashMap<>();
        //t字符串字符计数map
        HashMap<Character, Integer> need = new HashMap<>();
        //初始化t字符串字符计数map need
        for(char c : t.toCharArray()){
            need.put(c, need.getOrDefault(c, 0) + 1);
        }
        //左右指针
        int left = 0, right = 0;
        //窗口中覆盖t中字符的数量
        int valid = 0;
        int start = 0, len = Integer.MAX_VALUE;
        while(right < s.length()){
            //r是即将进入窗口的字符
            char r = s.charAt(right);
            System.out.println("窗口指针 window["+left+","+right+"]，窗口字符串："+s.substring(left, right+1));
            //滑动窗口右指针右移
            right++;
            if(need.containsKey(r)){
                //s右指针字符包含在t字符串里
                Integer count = window.getOrDefault(r, 0);
                window.put(r,++count);
                if(window.get(r).equals(need.get(r))){
                    //字符数一样时valid+1
                    valid++;
                }
            }
            while(valid == need.size()){
                //滑动窗口覆盖t中所有字符
                if(right - left < len){
                    start = left;
                    len = right - left;
                }
                //l是即将移出窗口的字符
                char l = s.charAt(left);
                //滑动窗口左指针右移
                left++;
                if(need.containsKey(l)){
                    if(window.get(l).equals(need.get(l))){
                        //l字符数量不一致就不再覆盖t字符串了，覆盖的字符数-1
                        valid--;
                    }
                    window.put(l, window.get(l)-1);
                }
            }
        }
        return len == Integer.MAX_VALUE ? "" : s.substring(start, start + len);
    }
}
