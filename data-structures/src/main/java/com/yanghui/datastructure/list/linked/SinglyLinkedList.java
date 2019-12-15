package com.yanghui.datastructure.list.linked;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

/**
 * 单(向)链表
 *
 * 属性中只有一个节点head，通过node中的next单向链接
 * @author YangHui
 */
public class SinglyLinkedList<T> implements List<T> {

    Node<T> head;

    private int size;

    /**
     * 添加元素（末尾）
     *
     * 时间复杂度O(n) : 主要是因为单链表需要从头遍历找到尾结点，然后将新元素与尾结点链接起来
     * 单链表比起顺序链表，优势在于头结点的插入和删除，单链表头结点插入和删除时间复杂度为O(1)
     * @param t
     * @return
     */
    @Override
    public boolean add(T t) {
        final Node<T> node = new Node<>(t, null);
        if(head == null){
            head = node;
        }else{
            Node<T> tail = head;
            while(tail.next != null){
                tail = tail.next;
            }
            tail.next = node;
        }
        size++;
        return true;
    }

    /**
     * 移除指定值的节点
     *
     * 时间复杂度O(n)
     * @param o
     * @return
     */
    @Override
    public boolean remove(Object o) {
        if(head != null){
            Node<T> c = head;
            if(o == null){
                if(c.item == null){
                    head = null;
                    size--;
                    return true;
                }
                do{
                    if(c.next.item == null){
                        c.next = c.next.next;
                        size--;
                        return true;
                    }
                    c = c.next;
                } while (c.next != null);
            }
            else{
                if(o.equals(c.item)){
                    head = null;
                    size--;
                    return true;
                }
                do{
                    if(o.equals(c.next.item)){
                        c.next = c.next.next;
                        size--;
                        return true;
                    }
                    c = c.next;
                } while (c.next != null);
            }
        }
        return false;
    }

    /**
     * 获取指定位置元素
     *
     * 时间复杂度O(n)
     * @param index
     * @return
     */
    @Override
    public T get(int index) {
        if(head == null){
            return null;
        }
        int c = 0;
        for(Node<T> n = head; n != null; n = n.next){
            if(c == index) {
                return n.item;
            }
            c++;
        }
        return null;
    }

    @Override
    public T remove(int index) {
        if(index < 0 || index > size-1){
            throw new IndexOutOfBoundsException(outOfBoundsMsg(index));
        }
        if(head != null){
            if(index == 0){
                T item = head.item;
                head.item = null;
                head = head.next;
                size--;
                return item;
            }else{
                Node<T> c = head;
                int i = 1;
                do{
                    if(i == index){
                        T item = (T) c.next.item;
                        c.next = c.next.next;
                        size--;
                        return item;
                    }
                    i++;
                    c = c.next;
                }while(c != null);
            }
        }
        return null;
    }

    private String outOfBoundsMsg(int index) {
        return "Index: "+index+", Size: "+size;
    }

    @Override
    public T set(int index, T element) {
        return null;
    }

    @Override
    public void add(int index, T element) {

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
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
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
        if(head == null){
            return "SinglyLinkedList{}";
        }else{
            StringBuilder sb = new StringBuilder();
            sb.append("SinglyLinkedList{ ");
            Node<T> current = head;
            sb.append(current.item);
            while(current.next != null){
                current = current.next;
                sb.append(", ").append(current.item);
            }
            sb.append("}");
            return sb.toString();
        }
    }
}
