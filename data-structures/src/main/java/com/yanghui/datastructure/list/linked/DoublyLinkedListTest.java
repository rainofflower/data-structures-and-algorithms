package com.yanghui.datastructure.list.linked;

import org.junit.Test;

/**
 * @author YangHui
 */
public class DoublyLinkedListTest {

    @Test
    public void test1(){
        DoublyLinkedList<Integer> list = new DoublyLinkedList<>();
        for(int i = 1; i<= 10; i++){
            list.add(i);
        }
        System.out.println(list+" ,size="+list.size());
        System.out.println(list.get(3));
        System.out.println(list.remove((Object)3));
        System.out.println(list+" ,size="+list.size());
        System.out.println(list.remove((Object)1));
        System.out.println(list+" ,size="+list.size());
        System.out.println(list.remove((Object)10));
        System.out.println(list+" ,size="+list.size());
        list.add(11);
        System.out.println(list+" ,size="+list.size());
        System.out.println(list.get(0));
        System.out.println(list.get(4));
        System.out.println(list.get(7));
        list.add(0, 20);
        System.out.println(list+" ,size="+list.size());
        list.add(3, 20);
        System.out.println(list+" ,size="+list.size());
        list.add(9, 20);
        System.out.println(list+" ,size="+list.size());

    }
}
