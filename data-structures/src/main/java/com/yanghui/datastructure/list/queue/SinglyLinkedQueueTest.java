package com.yanghui.datastructure.list.queue;

import org.junit.Test;

/**
 * @author YangHui
 */
public class SinglyLinkedQueueTest {

    @Test
    public void test1(){
        int n = 5;
        SinglyLinkedQueue<Integer> queue = new SinglyLinkedQueue<>();
        for(int i = 1; i<=n; i++){
            queue.offer(i);
        }
        System.out.println(queue);
        System.out.println(queue.peek());
        System.out.println(queue.remove());
        System.out.println(queue);
        queue.offer(6);
        System.out.println(queue);
        System.out.println(queue.remove());
        System.out.println(queue.remove());
        queue.offer(9);
        System.out.println(queue);

    }
}
