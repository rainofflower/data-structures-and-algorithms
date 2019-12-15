package com.yanghui.datastructure.list.linked;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

/**
 * 双向链表
 *
 * @author YangHui
 */
public class DoublyLinkedList<T> implements List<T> {

    Node<T> head;

    Node<T> tail;

    private int size;

    /**
     * 尾部插入数据
     * 时间复杂度 O(1)
     * @param t
     * @return
     */
    @Override
    public boolean add(T t) {
        if(head == null){
            Node node = new Node(t, null, null);
            head = node;
            tail = node;
            head.next = tail;
            tail.prev = head;
            size++;
        }else{
            Node node = new Node(t, tail, null);
            tail.next = node;
            tail = node;
            size++;
        }
        return true;
    }

    /**
     * 移除某个值
     * 时间复杂度 O(n)
     * @param o
     * @return
     */
    @Override
    public boolean remove(Object o) {
        if(head != null){
            if(o == null){
                for(Node c = head; c != null; c = c.next){
                    if(c.item == null && c != head && c != tail){
                        c.prev.next = c.next;
                        c.next.prev = c.prev;
                        size--;
                        return true;
                    }else if(c.item == null && c == head){
                        head = head.next;
                        head.prev = null;
                        size--;
                        return true;
                    }else if(c.item == null && c == tail){
                        tail = tail.prev;
                        tail.next = null;
                        size--;
                        return true;
                    }
                }
            }else{
                for(Node c = head; c != null; c = c.next){
                    if(o.equals(c.item) && c != head && c != tail){
                        c.prev.next = c.next;
                        c.next.prev = c.prev;
                        size--;
                        return true;
                    }else if(o.equals(c.item) && c == head){
                        head = head.next;
                        head.prev = null;
                        size--;
                        return true;
                    }else if(o.equals(c.item) && c == tail){
                        tail = tail.prev;
                        tail.next = null;
                        size--;
                        return true;
                    }
                }
            }
        }
        return false;
    }

    @Override
    public T get(int index) {
        if(index < 0 || index > size-1){
            throw new IndexOutOfBoundsException(outOfBoundsMsg(index));
        }
        if(head != null){
            //index小于总数的一半,靠近head
            if(index < (size >> 1)){
                int i = 0;
                for(Node<T> c = head; c != null; c = c.next){
                    if(i++ == index){
                        return c.item;
                    }
                }
            }else{
                int i = size-1;
                for(Node<T> c = tail; c != null; c = c.prev){
                    if(i-- == index){
                        return c.item;
                    }
                }
            }
        }
        return null;
    }

    @Override
    public T set(int index, T element) {
        return null;
    }

    /**
     * 在指定位置插入数据
     * 时间复杂度 O(n)
     * @param index
     * @param element
     */
    @Override
    public void add(int index, T element) {
        if(index < 0 || index > size-1){
            throw new IndexOutOfBoundsException(outOfBoundsMsg(index));
        }
        if(head != null){
            if(index < (size >> 1)){
                int i = 0;
                for(Node<T> c = head; c != null; c = c.next){
                    if(i++ == index){
                        if(index == 0){
                            Node node = new Node(element, null, head);
                            //下两步顺序不能反，后面的分支也是一样
                            head.prev = node;
                            head = node;
                            size++;
                        }else if(index == size-1){
                            Node node = new Node(element, tail.prev, tail);
                            tail.prev.next = node;
                            tail.prev = node;
                            size++;
                        }else{
                            Node node = new Node(element, c.prev, c);
                            c.prev.next = node;
                            c.prev = node;
                            size++;
                        }
                    }
                }
            }else{
                int i = size-1;
                for(Node<T> c = tail; c != null; c = c.prev){
                    if(i-- == index){
                        if(index == 0){
                            Node node = new Node(element, null, head);
                            head.prev = node;
                            head = node;
                            size++;
                        }else if(index == size-1){
                            Node node = new Node(element, tail.prev, tail);
                            tail.prev.next = node;
                            tail.prev = node;
                            size++;
                        }else{
                            Node node = new Node(element, c.prev, c);
                            c.prev.next = node;
                            c.prev = node;
                            size++;
                        }
                    }
                }
            }
        }
    }

    @Override
    public T remove(int index) {
        return null;
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
     * 结构
     * @param <T>
     */
    static class Node<T>{
        T item;
        Node<T> prev;
        Node<T> next;
        Node(T item, Node<T> prev, Node<T> next){
            this.item = item;
            this.prev = prev;
            this.next = next;
        }
    }

    @Override
    public String toString() {
        if(head == null){
            return "DoublyLinkedList{}";
        }else{
            StringBuilder sb = new StringBuilder();
            sb.append("DoublyLinkedList{ ");
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
