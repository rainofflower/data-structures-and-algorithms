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
}
