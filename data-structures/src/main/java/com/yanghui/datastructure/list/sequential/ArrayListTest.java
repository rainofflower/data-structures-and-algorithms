package com.yanghui.datastructure.list.sequential;

import org.junit.Test;

import java.util.List;

/**
 * @author YangHui
 */
public class ArrayListTest {

    @Test
    public void test1(){
        int size = 10;
        ArrayList<Integer> list = new ArrayList<>(size);
        for(int i=0; i<size/2; i++){
            list.add(i);
        }
        System.out.println("初始化："+list.toString());
        list.add(5, 7);
        System.out.println(list.toString());
        list.remove(2);
        System.out.println(list.toString()+" size = "+list.size());
    }
}
