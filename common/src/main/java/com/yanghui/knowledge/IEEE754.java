package com.yanghui.knowledge;

import org.junit.Test;

import java.math.BigDecimal;

/**
 * java 精度处理问题
 *
 * java中浮点数采用的IEEE754标准
 *
 * @author YangHui
 */
public class IEEE754 {

    /**
     * 基本数据类型浮点计算精度问题
     *
     */
    @Test
    public void test1(){
        //1.9
        float r1 = 2.0f - 0.1f;
        float r2 = 2.0f - 0.1f;
        //预期1.99，实际1.9899999
        float r3 = 2.1f - 0.11f;
        //1.99
        double r4 = 2.1d - 0.11d;
        //预期2，实际1.999999
        float r5 = 2.11f - 0.11f;
        //预期2，实际1.9999999999999998
        double r6 = 2.11d - 0.11d;
        //1.9
        double r7 = 2.0d - 0.1d;
        //预期1.9，实际1.8999999
        float r8 = 2.1f - 0.2f;
        //0.3
        float r9 = 0.1f + 0.2f;
        //预期0.3，实际0.30000000000000004
        double r10 = 0.1d + 0.2d;
        System.out.println("r1=" +r1 + "|r2=" + r2 + "|r3=" + r3 +
                "|r4=" + r4 + "|r5=" + r5 + "|r6=" +r6 +
                "|r7=" + r7 + "|r8=" + r8 + "|r9=" + r9 +
                "|r10=" + r10);
        //true
        System.out.println(r1 == r2);
        //预期true,实际false
        System.out.println(r4 == r3);
        //预期true,实际false
        System.out.println(r7 == r1);
        //预期true,实际false
        System.out.println(r8 == r1);
    }

    /**
     * BigDecimal精度问题
     *
     * 不推荐使用BigDecimal的BigDecimal(double)构造方法、
     * 因为参数double本身就存在丢失精度的可能性。
     * 当必须使用double类型创建BigDecimal对象的时候，可以使用Double的toString（double）将double类型转化为String，
     * 再BigDecimal（String）或者直接使用静态方法
     * BigDecimal.valueOf（double）
     * 比如以下 r4的值会等于r6
     *
     * 总结：使用new BigDecimal(String)、BigDecimal.valueOf(double)不会丢失精度
     *      使用new BigDecimal(double)、BigDecimal.valueOf(float)会丢失精度
     */
    @Test
    public void test2(){
        //1.98999990522861485
        BigDecimal r3 = BigDecimal.valueOf(2.1f).subtract(BigDecimal.valueOf(0.11f));
        //1.99
        BigDecimal r4 = BigDecimal.valueOf(2.1d).subtract(BigDecimal.valueOf(0.11d));
        //1.98999990522861480712890625
        BigDecimal r5 = new BigDecimal(2.1f).subtract(new BigDecimal(0.11f));
        //1.99
        BigDecimal r6 = new BigDecimal("2.1").subtract(new BigDecimal("0.11"));
        //2.00
        BigDecimal r7 = new BigDecimal("2.11").subtract(new BigDecimal("0.11"));
        //2.0
        BigDecimal r8 = new BigDecimal("2.1").subtract(new BigDecimal("0.1"));
        //1.99000000000000008826273045769994496367871761322021484375
        BigDecimal r9 = new BigDecimal(2.1d).subtract(new BigDecimal(0.11d));
        System.out.println("r3=" + r3 +
                "|r4=" + r4+ "|r5=" + r5 + "|r6=" +r6 +
                "|r7=" + r7 + "|r8=" + r8 + "|r9=" + r9);
        System.out.println(r4.equals(r3));
        System.out.println(r3.equals(r5));
        System.out.println(r4.equals(r5));
        System.out.println(r3.equals(r6));
        //true
        System.out.println(r4.equals(r6));
        System.out.println(r5.equals(r6));
        //false
        System.out.println(r7.equals(r8));
        //true
        System.out.println(r7.compareTo(r8) == 0);
        //false
        System.out.println(r4.compareTo(r9) == 0);
    }

}
