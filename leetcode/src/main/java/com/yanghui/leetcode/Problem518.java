package com.yanghui.leetcode;

import org.junit.Test;

public class Problem518 {

    @Test
    public void test(){
        //[1,2,5]
        //5
        //dp(0) = 1
        //dp(n) = sum(dp(n-coin)) n >= coin

        /**
         * dp(5)
         * 5 = 5
         * 5 = 2+2+1
         * 5 = 2+1+1+1
         * 5 = 1+1+1+1+1
         * 共4种组合
         *
         * dp(4)    -1
         * 4 = 2+2      +1
         * 4 = 2+1+1    +1
         * 4 = 1+1+1+1  +1
         * 共3种组合
         *
         * dp(3)    -2
         * 3 = 2+1      +2
         * 3 = 1+1+1    +2
         * 共2种组合
         *
         * dp(0)    -5
         * 0            +5
         * 共1种组合
         *
         */
        System.out.println(change(5, new int[]{1,2,5}));
    }

    public int change(int amount, int[] coins) {
        long[] dp = new long[amount+1];
        dp[0] = 1;
        for(int coin : coins){
            for(int i = coin; i<=amount; i++){
                System.out.println("coin = "+coin+", i="+i);
                System.out.println("1----dp["+i+"]"+"="+dp[i]+", dp["+(i-coin)+"]="+dp[i-coin]);
                dp[i] += dp[i - coin];
                System.out.println("2----dp["+i+"]"+"=dp["+i+"]+dp["+i+"-"+coin+"]=dp["+i+"]+dp["+(i-coin)+"]="+dp[i]);
                System.out.println("===");
            }
        }
        return (int)dp[amount];
    }

    public int change2(int amount, int[] coins) {
        return 0;
    }
}
