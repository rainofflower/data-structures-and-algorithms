package com.yanghui.datastructure.list.linked;

import org.junit.Test;

/**
 * Josephus问题 实现算法
 *
 * n个人
 * 从第id个人开始报数，报m的人出列，到m后，重新从1开始报数
 *
 * @author YangHui
 */
public class Josephus {

    private int n = 10; //总人数
    private int m = 4;  //报数周期
    private int id = 1; //从第几个人开始报数
    /**
     * 循环单链表实现
     */
    @Test
    public void circularLinkedList(){
        CircularLinkedList<Integer> list = new CircularLinkedList<>();
        //初始化
        for(int i = 1; i<=n; i++){
            list.add(i);
        }
        CircularLinkedList.Node<Integer> current = list.head;
        for(int i = 1; i<id; i++){
            current = current.next;
        }
        int i = 1;
        for(; current.next != current; current = current.next){
            if(i == m){
                System.out.println(current.item+" 出列");
                list.remove(current.item);
                i = 1;
            }else{
                i++;
            }
        }
        System.out.println(current.item +"最后出列");
    }

    /**
     * 数学归纳法
     */
    @Test
    public void mathematicalInduction(){

    }
}
