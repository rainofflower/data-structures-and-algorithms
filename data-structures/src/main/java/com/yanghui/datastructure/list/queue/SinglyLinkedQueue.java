package com.yanghui.datastructure.list.queue;

import com.yanghui.datastructure.list.linked.SinglyLinkedList;

import java.util.Collection;
import java.util.Iterator;
import java.util.Queue;

/**
 * 队列（单向链表实现）
 *
 * FIFO(first in first out) 与栈的区别
 *
 * @author YangHui
 */
public class SinglyLinkedQueue<T> implements Queue<T> {

    private SinglyLinkedList<T> list;

    public SinglyLinkedQueue(){
        list = new SinglyLinkedList<>();
    }

    /**
     * 添加到队尾
     * @param t
     * @return
     */
    @Override
    public boolean offer(T t) {
        return list.add(t);
    }

    /**
     * 获取并移除队头
     * @return
     */
    @Override
    public T poll() {
        return remove();
    }

    /**
     * 获取队头，不移除
     * @return
     */
    @Override
    public T peek() {
        return list.get(0);
    }

    /**
     * 移除队头
     * @return
     */
    @Override
    public T remove() {
        return list.remove(0);
    }

    @Override
    public T element() {
        return null;
    }

    @Override
    public int size() {
        return list.size();
    }

    @Override
    public boolean isEmpty() {
        return size() == 0;
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
    public boolean add(T t) {
        return false;
    }

    @Override
    public boolean remove(Object o) {
        return false;
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
    public String toString() {
        return "SinglyLinkedQueue{" +
                "head " + list +
                " tail }";
    }
}
