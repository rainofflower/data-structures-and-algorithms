package com.yanghui.datastructure.list.stack;

import java.util.Arrays;

/**
 * 栈
 *
 * 采用单链表实现，头结点作为栈顶，压栈出栈时间复杂度为 0(1)
 * 同时空间复杂度达到最优
 *
 * @author YangHui
 */
public class Stack2<T> {

    /**
     * 栈顶
     */
    Node<T> head;

    public T push(T t){
        head = new Node<>(t, head);
        return t;
    }

    public T pop(){
        T item = head.item;
        head = head.next;
        return item;
    }

    /**
     * 节点结构
     * @param <T>
     */
    private static class Node<T>{
        T item;
        Node next;
        Node(T item, Node<T> next){
            this.item = item;
            this.next = next;
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Stack2{ top <- ");
        Node temp = head;
        for(;temp != null; temp = temp.next){
            sb.append(temp.item).append(" ");
        }
        sb.append("]bottom }");
        return sb.toString();
    }
}
