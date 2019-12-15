package com.yanghui.datastructure.list.linked;

import org.junit.Test;

/**
 * 魔术师发牌问题
 *
 * 魔术师手中有A、2、3……J、Q、K十三张黑桃扑克牌。
 * 在表演魔术前，魔术师已经将他们按照一定的顺序叠放好（有花色的一面朝下）。
 * 魔术表演过程为：一开始，魔术师数1，然后把最上面的那张牌翻过来，是黑桃A；然后将其放到桌面上；
 * 第二次,魔术师数1、2；将第一张牌放到这些牌的最下面，将第二张牌翻转过来，正好是黑桃2；
 * 第三次，魔术师数1、2、3；将第1、2张牌依次放到这些牌的最下面，将第三张牌翻过来正好是黑桃3；……直到将所有的牌都翻出来为止。
 *
 * 求牌的顺序
 *
 * @author YangHui
 */
public class Magician {

    private int n = 13;

    /**
     * 循环链表实现
     */
    @Test
    public void sort(){
        CircularLinkedList<Integer> list = new CircularLinkedList<>();
        for(int i = 1; i<=n; i++){
            list.add(0);
        }
        CircularLinkedList.Node<Integer> c = list.head;
        //第一张牌是1
        c.item = 1;
        //第二张牌是2
        int need = 2;
        for(;;){
            //数牌
            for(int b = 1; b<=need;){
                //下一张
                c = c.next;
                if(c.item == 0){
                    //如果是未设置的牌，计数加1(模拟放到牌底去了)，如果牌已经设置过了，跳过
                    b++;
                }
            }
            //在适当的位置设置正确的牌
            c.item = need;
            //下一轮要设置的牌
            need++;
            if(need > 13){
                //全部设置完，退出
                break;
            }
        }
        System.out.println("牌的顺序："+list);
        //模拟表演过程
        System.out.println("见证奇迹的时候到了：");
        for(int a = 1; a<= n; a++){
            for(int b = 1; b<a; b++){
                Integer head = list.remove(0);
                list.add(head);
            }
            System.out.println(list.remove(0));
        }
    }

}
