package com.yanghui.leetcode;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

/**
 * @author YangHui
 */
public class Problem524 {

    @Test
    public void test(){
        String s = "wordgoodgoodgoodbestword";
        List<String> d = Arrays.asList(new String[]{"word","good","best","good"});
        String expected = "best";
        Assert.assertEquals(expected,findLongestWord(s,d));
    }

    public String findLongestWord(String s, List<String> d) {
        String result = "";
        int sLength = s.length();
        if(d == null || d.size() == 0 || sLength == 0){
            return result;
        }
        for(String item : d){
            int a = 0, b = 0;
            int length = item.length();
            while((b < length) && (a < sLength)){
                if(s.charAt(a) == item.charAt(b)){
                    b++;
                }
                a++;
            }
            if(b == length){
                int oldLength = result.length();
                if(length > oldLength || (length == oldLength && item.compareTo(result) < 0)){
                    result = item;
                }
            }
        }
        return result;
    }
}
