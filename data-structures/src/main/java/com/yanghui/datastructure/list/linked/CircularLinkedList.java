package com.yanghui.datastructure.list.linked;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

/**
 * 循环单链表
 *
 * 将单链表 表中最后一个结点指针指向链表的表头结点，整个链表形成一个环，
 * 从表中任一结点出发都可找到表中其他的结点。
 * @author YangHui
 */
public class CircularLinkedList<T> implements List<T> {

    Node<T> head;

    private int size;

    /**
     * 添加一个元素（末尾）
     * 时间复杂度O(n)
     * @param t
     * @return
     */
    @Override
    public boolean add(T t) {
        linkTail(t);
        return true;
    }

    private void linkHead(T t){
        Node<T> tail = tailNode();
        //新增的节点
        final Node<T> node = new Node<>(t, head);
        head = node;
        if(tail != null){
            //尾结点更换头结点
            tail.next = head;
        }
        size++;
    }

    private void linkTail(T t){
        Node<T> tail = tailNode();
        //新增的节点
        final Node<T> node = new Node<>(t, head);
        if(tail != null){
            tail.next = node;
        }else{
            head = node;
            node.next = head;
        }
        size++;
    }

    /**
     * @param h head 不能为空
     * @return head.item
     */
    private T unlinkHead(Node<T> h){
        Node<T> tail = tailNode();
        T item = h.item;
        head = h.next;
        tail.next = head;
        size--;
        return item;
    }


    private Node<T> tailNode(){
        Node<T> tail = head;
        if(head != null){
            while(tail.next != head){
                tail = tail.next;
            }
        }
        return tail;
    }


    @Override
    public T remove(int index) {
        if(index < 0 || index > size-1){
            throw new IndexOutOfBoundsException(outOfBoundsMsg(index));
        }
        if(head == null){
            return null;
        }
        if(index == 0){
            T item = head.item;
            unlinkHead(head);
            return item;
        }else{
            int i = 1;
            for(Node<T> node = head; node.next != head; node = node.next){
                if(index == i){
                    Node<T> c = node.next;
                    T item = c.item;
                    node.next = node.next.next;
                    size--;
                    return item;
                }
                i++;
            }
        }
        return null;
    }

    @Override
    public boolean remove(Object o) {
        if(head != null){
            if(o == null){
                if(head.item == null){
                    unlinkHead(head);
                    return true;
                }else{
                    for(Node<T> c = head; c != head; c = c.next){
                        if(c.next.item == null){
                            c.next = c.next.next;
                            size--;
                            return true;
                        }
                    }
                }
            }else{
                if(o.equals(head.item)){
                    unlinkHead(head);
                    return true;
                }else{
                    for(Node<T> c = head; c.next != head; c = c.next){
                        if(o.equals(c.next.item)){
                            c.next = c.next.next;
                            size--;
                            return true;
                        }
                    }
                }
            }
        }
        return false;
    }

    @Override
    public T get(int index) {
        return null;
    }

    @Override
    public T set(int index, T element) {
        return null;
    }

    /**
     * 在指定位置新增元素
     * 时间复杂度 O(n)
     * @param index
     * @param element
     */
    @Override
    public void add(int index, T element) {
        if(head == null || index > size || index < 0){
            throw new IndexOutOfBoundsException(outOfBoundsMsg(index));
        }
        if(index == 0){
            linkHead(element);
        }else if(index == size) {
            //最后一个
            linkTail(element);
        } else{
            //中间插入，需要遍历单链表
            Node<T> succ;   //前驱
            int i = 1;
            for(succ = head; succ.next != head; succ = succ.next){
                if(i == index){
                    Node<T> node = new Node<>(element, succ.next);
                    succ.next = node;
                    size++;
                    return;
                }
                i++;
            }
        }
    }

    private String outOfBoundsMsg(int index) {
        return "Index: "+index+", Size: "+size;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public boolean contains(Object o) {
        return false;
    }

    @Override
    public Iterator<T> iterator() {
        return null;
    }

    @Override
    public Object[] toArray() {
        return new Object[0];
    }

    @Override
    public <T1> T1[] toArray(T1[] a) {
        return null;
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        return false;
    }

    @Override
    public boolean addAll(Collection<? extends T> c) {
        return false;
    }

    @Override
    public boolean addAll(int index, Collection<? extends T> c) {
        return false;
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        return false;
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        return false;
    }

    @Override
    public void clear() {

    }

    @Override
    public int indexOf(Object o) {
        return 0;
    }

    @Override
    public int lastIndexOf(Object o) {
        return 0;
    }

    @Override
    public ListIterator<T> listIterator() {
        return null;
    }

    @Override
    public ListIterator<T> listIterator(int index) {
        return null;
    }

    @Override
    public List<T> subList(int fromIndex, int toIndex) {
        return null;
    }

    /**
     * 节点结构
     * @param <T>
     */
    static class Node<T>{
        T item;
        Node next;
        Node(T item, Node<T> next){
            this.item = item;
            this.next = next;
        }
    }

    @Override
    public String toString() {
        if(head == null){
            return "CircularLinkedList{}";
        }else{
            StringBuilder sb = new StringBuilder();
            sb.append("CircularLinkedList{ ");
            Node<T> current = head;
            sb.append(current.item);
            while(current.next != head){
                current = current.next;
                sb.append(", ").append(current.item);
            }
            sb.append("}");
            return sb.toString();
        }

    }
}
