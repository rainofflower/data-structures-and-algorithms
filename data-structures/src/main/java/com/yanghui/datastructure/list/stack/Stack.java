package com.yanghui.datastructure.list.stack;

import java.util.AbstractList;
import java.util.Arrays;
import java.util.EmptyStackException;

/**
 * 栈
 *
 * 使用顺序存储（数组）实现
 * 数组下标0的位置表示栈底
 * size-1的位置表示栈顶
 *
 * LIFO(last in first out) 与队列的区别
 *
 * 运用：
 * 逆波兰表达式
 * 方法嵌套调用
 * 二进制转10进制，2进制转8进制/16进制
 *
 * @author YangHui
 */
public class Stack<T> extends AbstractList<T> {

    Object[] data;

    private int size;

    /**
     * 默认容量
     */
    private static final int DEFAULT_CAPATICY = 10;

    public Stack(int capacity){
        data = new Object[capacity];
    }

    /**
     * 默认容量为10
     */
    public Stack(){
        this(DEFAULT_CAPATICY);
    }

    /**
     * 入栈
     * 时间复杂度 O(1) (不发生扩容的情况下)
     * @param t
     * @return
     */
    public T push(T t){
        if(size+1 > data.length){
            //默认扩容为原来的 1.5 倍
            int newCapacity = size + (size >> 1);
            data = Arrays.copyOf(data, newCapacity);
        }
        data[size++] = t;
        return t;
    }

    /**
     * 出栈
     * 时间复杂度O(1)
     * @return
     */
    public T pop(){
        if(size == 0){
            throw new EmptyStackException();
        }
        size--;
        T item = (T) data[size];
        data[size] = null;
        return item;
    }

    @Override
    public T get(int index) {
        return null;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public String toString() {
        return "Stack{ bottom" +
                Arrays.toString(data) +
                "<- top }";
    }
}
