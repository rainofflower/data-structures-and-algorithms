package com.yanghui.datastructure.list.linked;

import org.junit.Test;

/**
 * 拉丁方阵问题
 *
 * 一个N*N的矩阵，任何一个元素在同一行或同一列都只出现一次
 *
 * @author YangHui
 */
public class Latin {

    private int n = 6;

    /**
     * 循环链表实现
     */
    @Test
    public void show(){
        CircularLinkedList<Integer> list = new CircularLinkedList<>();
        for(int i = 1; i<=n; i++){
            list.add(i);
        }
        //外层循环，控制行
        for(int i = 1; i<=n; i++){
            //外层循环，每次从头搜索第一个元素的位置
            CircularLinkedList.Node<Integer> node = list.head;
            int c = 1;
            while(c < i){
                c++;
                node = node.next;
            }
            //内层循环，控制列
            for(int j = 1; j<=n; j++){
                //从上面找到的该行第一个元素的位置开始往后打印循环链表的值
                System.out.print(node.item+" ");
                node = node.next;
            }
            System.out.println();
        }
    }
}
