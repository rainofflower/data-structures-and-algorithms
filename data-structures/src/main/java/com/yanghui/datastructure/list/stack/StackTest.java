package com.yanghui.datastructure.list.stack;

import org.junit.Test;

/**
 * @author YangHui
 */
public class StackTest {

    @Test
    public void test1(){
        int num = 12;
        Stack<Integer> stack = new Stack<>();
        for(int i=1; i<=num; i++){
            stack.push(i);
        }
        System.out.println(stack);
        Integer pop = stack.pop();
        System.out.println(pop+" 出栈");
        System.out.println(stack);
        stack.push(num+1);
        System.out.println(stack);
        Integer pop2 = stack.pop();
        System.out.println(pop2+" 出栈");
        System.out.println(stack);
    }

    @Test
    public void test2(){
        int num = 12;
        long l = 2;
        Stack2<Integer> stack = new Stack2<>();
        for(int i=1; i<=num; i++){
            stack.push(i);
        }
        System.out.println(stack);
        Integer pop = stack.pop();
        System.out.println(pop+" 出栈");
        System.out.println(stack);
        stack.push(num+1);
        System.out.println(stack);
        Integer pop2 = stack.pop();
        System.out.println(pop2+" 出栈");
        System.out.println(stack);
    }

}
