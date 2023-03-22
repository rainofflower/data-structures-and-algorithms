package com.yanghui.leetcode;

import com.yanghui.leetcode.util.PrintUtils;
import org.junit.Test;

import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class Problem752 {

    @Test
    public void test(){
        //4个拨轮的转盘锁，数字范围0-9
        //初始值为 0000,拨到target
        String s = "0000";
        String[] deadends = {"8887","8889","9888","7888","8988","8788","8878","8898"};
        String target = "8888";
        System.out.println(bfs(s,deadends,target));
    }

    public int bfs(String s, String[] deadends, String target){
        Set<String> visited = new HashSet<>();
        Set<String> deads = new HashSet<>();
        for(String d : deadends){
            deads.add(d);
        }
        Queue<String> queue = new LinkedList<>();
        queue.offer(s);
        visited.add(s);
        int step = 0;
        while(!queue.isEmpty()){
            System.out.println(PrintUtils.toString(queue));
            int size = queue.size();
            for(int i = 0; i<size; i++){
                String curr = queue.poll();
                System.out.println(curr);
                if(deads.contains(curr)){
                    continue;
                }
                if(target.equals(curr)){
                    return step;
                }
                for(int k = 0; k<s.length(); k++){
                    String plus = plusOne(curr, k);
                    if(!visited.contains(plus)){
                        queue.offer(plus);
                        visited.add(plus);
                    }
                    String sub = subOne(curr, k);
                    if(!visited.contains(sub)){
                        queue.offer(sub);
                        visited.add(sub);
                    }
                }
            }
            step++;
        }
        return -1;
    }

    public int doubleBfs(String s, String[] deadends, String target){
        Set<String> visited = new HashSet<>();
        Set<String> deads = new HashSet<>();
        for(String d : deadends){
            deads.add(d);
        }
        Queue<String> queue = new LinkedList<>();
        queue.offer(s);
        visited.add(s);
        int step = 0;
        int step2 = 0;
        while(!queue.isEmpty()){
            System.out.println(PrintUtils.toString(queue));
            int size = queue.size();
            for(int i = 0; i<size; i++){
                String curr = queue.poll();
                System.out.println(curr);
                if(deads.contains(curr)){
                    continue;
                }
                if(target.equals(curr)){
                    return step;
                }
                for(int k = 0; k<s.length(); k++){
                    String plus = plusOne(curr, k);
                    if(!visited.contains(plus)){
                        queue.offer(plus);
                        visited.add(plus);
                    }
                    String sub = subOne(curr, k);
                    if(!visited.contains(sub)){
                        queue.offer(sub);
                        visited.add(sub);
                    }
                }
            }
            step++;
        }
        return -1;
    }

    private String plusOne(String s, int i){
        char[] chars = s.toCharArray();
        if(chars[i] == '9'){
            chars[i] = '0';
        }else{
            chars[i] += 1;
        }
        return new String(chars);
    }

    private String subOne(String s, int i){
        char[] chars = s.toCharArray();
        if(chars[i] == '0'){
            chars[i] = '9';
        }else{
            chars[i] -= 1;
        }
        return new String(chars);
    }


}
