package com.yanghui.datastructure.list.linked;

import org.junit.Test;

/**
 * @author YangHui
 */
public class CircularLinkedListTest {

    @Test
    public void test1(){
        int size = 2;
        CircularLinkedList<Integer> linkedList = new CircularLinkedList<>();
        for(int i = 0; i<size; i++){
            linkedList.add(i);
        }
        System.out.println(linkedList+" ,size="+linkedList.size());
        linkedList.add(2, 9);
        System.out.println(linkedList+" ,size="+linkedList.size());
        linkedList.add(0, 9);
        System.out.println(linkedList+" ,size="+linkedList.size());
        Integer remove = linkedList.remove(3);
        System.out.println("remove:"+remove+" ,"+linkedList+" ,size="+linkedList.size());
        linkedList.add(2, 6);
        System.out.println(linkedList+" ,size="+linkedList.size());
        linkedList.remove((Object) 1);
        System.out.println(linkedList+" ,size="+linkedList.size());
    }
}
