package com.yanghui.leetcode;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * @author YangHui
 */
public class Problem242 {

    @Test
    public void test(){
        System.out.println(isAnagram1("annsc","scnan"));
    }

    public boolean isAnagram1(String s, String t) {
        if(s.length() != t.length()){
            return false;
        }
        int[] a = new int[26];
        for(int i = 0; i<s.length(); i++){
            a[s.charAt(i) - 'a']++;
            a[t.charAt(i) - 'a']--;
        }
        for(int count : a){
            if(count != 0){
                return false;
            }
        }
        return true;
    }


    public boolean isAnagram2(String s, String t) {
        Map<Character, Integer> map = new HashMap<>();
        char[] sChars = s.toCharArray();
        char[] tChars = t.toCharArray();
        int sLength = sChars.length;
        int tLength = tChars.length;
        if(sLength != tLength){
            return false;
        }
        for(int i = 0; i<sLength; i++){
            Integer count = map.get(sChars[i]);
            if(count == null){
                count = 0;
            }
            map.put(sChars[i], ++count);
        }
        for(int i = 0; i<tLength; i++){
            Integer count = map.get(tChars[i]);
            if(count == null){
                count = 0;
            }
            map.put(tChars[i],--count);
        }
        for(Integer i : map.values()){
            if(i != 0){
                return false;
            }
        }
        return true;
    }
}
