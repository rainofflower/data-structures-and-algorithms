package com.yanghui.leetcode.util;

import java.util.Collection;
import java.util.Iterator;

public class PrintUtils {

    public static <E> String toString(Collection<E> collection) {
        Iterator<E> it = collection.iterator();
        if (! it.hasNext())
            return "[]";

        StringBuilder sb = new StringBuilder();
        sb.append('[');
        for (;;) {
            E e = it.next();
            sb.append(e);
            if (! it.hasNext())
                return sb.append(']').toString();
            sb.append(',').append(' ');
        }
    }

    public static <E> void print(Collection<E> collection) {
        System.out.println(toString(collection));
    }

    public static void printIntArray(int[] a){
        int length = a.length;
        for(int i = 0; i<length; ++i){
            System.out.print(a[i]+" ");
        }
        System.out.println();
    }
}
