package com.yanghui.datastructure.list.sequential;

import java.util.*;

/**
 * 顺序存储的线性表 实现
 *
 * @author YangHui
 */
public class ArrayList<T> implements List<T> {

    /**
     * 顺序存储的数组
     * 缺省权限修饰符：类内部和同包下能直接访问（jdk中的ArrayList也是如此设计）
     */
    Object[] data;

    private int size;

    public ArrayList(int maxLength){
        data = new Object[maxLength];
    }


    @Override
    public boolean add(T t) {
        data[size++] = t;
        return true;
    }

    /**
     * 插入数据
     *
     * 算法复杂度 O(n)
     * 最好的情况是O(1)
     * 最坏的情况是O(n)
     * 平均 n(n+1)/2 = 1/2 n^2 + n/2 平均时间复杂度也为O(n)
     * @param index
     * @param element
     */
    @Override
    public void add(int index, T element) {
        if(index < 0 || index > size || size+1 > data.length){
            //不进行扩容
            throw new IndexOutOfBoundsException(outOfBoundsMsg(index));
        }
        //index==size(要添加到末尾)时，以下代码能正确处理
        System.arraycopy(data, index, data, index+1, size-index);
        data[index] = element;
        size++;
    }

    /**
     * 删除指定值数据
     *
     * 时间复杂度O(n)
     * @param o
     * @return
     */
    @Override
    public boolean remove(Object o) {
        if(o == null){
            for(int index = 0; index<size; index++){
                if(data[index] == null){
                    //将index+1之后的数据copy到index起，长度size-index-1的区段
                    System.arraycopy(data, index+1, data, index, size-index-1);
                    //置空最后一个元素（help GC）
                    data[--size] = null;
                    return true;
                }
            }
        }
        else{
            for(int index = 0; index<size; index++){
                if(o.equals(data[index])){
                    System.arraycopy(data, index+1, data, index, size-index-1);
                    data[--size] = null;
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * 删除指定位置数据
     *
     * 时间复杂度O(n)
     * @param index
     * @return
     */
    @Override
    public T remove(int index) {
        T old = (T) data[index];
        int numRemoved = size-index-1;
        if(numRemoved > 0){
            //移动数据
            System.arraycopy(data, index+1, data, index, numRemoved);
        }
        data[--size] = null;
        return old;
    }

    /**
     * 时间复杂度O(1)
     *
     * @param index
     * @return
     */
    @Override
    public T get(int index) {
        return (T) data[index];
    }

    /**
     * 时间复杂度O(1)
     *
     * @param index
     * @param element
     * @return
     */
    @Override
    public T set(int index, T element) {
        T old = (T) data[index];
        data[index] = element;
        return old;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public String toString() {
        return "ArrayList{" +
                "data=" + Arrays.toString(data) +
                '}';
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    private String outOfBoundsMsg(int index) {
        return "Index: "+index+", Size: "+size;
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
}
