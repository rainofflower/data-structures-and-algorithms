package com.yanghui.recursion;

import org.junit.Test;

/**
 * 汉诺塔问题
 *
 * 汉诺塔(Tower of Hanoi)源于印度传说中，大梵天创造世界时造了三根金钢石柱子，其中一根柱子自底向上叠着64片黄金圆盘。
 * 大梵天命令婆罗门把圆盘从下面开始按大小顺序重新摆放在另一根柱子上。
 * 并且规定，在小圆盘上不能放大圆盘，在三根柱子之间一次只能移动一个圆盘。
 *
 * 运用分治思想，将问题细化为3个步骤:
 * 假设有A、B、C三个塔，A塔有N块盘，目标是把这些盘全部移到C塔。那么先把A塔顶部的N-1块盘移动到B塔，再把A塔剩下的大盘移到C，最后把B塔的N-1块盘移到C。
 * 每次移动多于一块盘时，则再次使用上述算法来移动。
 *
 * @author YangHui
 */
public class TowerOfHanoi {

    @Test
    public void test(){
        int n = 3;
        move(n, 'A', 'B', 'C');
    }

    /**
     * 将 n 个盘子借助 B 柱，从 A 移动到 C
     */
    private void move(int n, char a, char b, char c){
        if(n == 1){
            System.out.println(a+" -> "+c);
        }else{
            //将 n - 1 个盘子借助 c 从 a 移动到 b
            move(n - 1, a, c, b);
            //将第 n 个盘子 从 a 移动到 c
            System.out.println(a+" -> "+c);
            //将 n - 1 个盘子借助 a 从 b 移动到 c
            move(n - 1, b, a, c);
        }
    }
}
