package com.yanghui.datastructure.list.linked;

import org.junit.Test;

/**
 * @author YangHui
 */
public class SinglyLinkedListTest {

    @Test
    public void test1(){
        int size = 10;
        SinglyLinkedList<Integer> linkedList = new SinglyLinkedList<>();
        for(int i=1; i<=size; i++){
            linkedList.add(i);
        }
        System.out.println(linkedList+" ,size="+linkedList.size());
        System.out.println(linkedList.get(3));
        linkedList.remove((Object)3);
        System.out.println(linkedList+" ,size="+linkedList.size());
        System.out.println(linkedList.remove(0));
        System.out.println(linkedList+" ,size="+linkedList.size());
        System.out.println(linkedList.remove(4));
        System.out.println(linkedList+" ,size="+linkedList.size());
        System.out.println(linkedList.remove(6));
        System.out.println(linkedList+" ,size="+linkedList.size());
        linkedList.add(12);
        System.out.println(linkedList+" ,size="+linkedList.size());
    }
}
