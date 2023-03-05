package com.yanghui.leetcode;

import org.junit.Test;

public class Problem518 {

    @Test
    public void test(){
        //[1,2,5]
        //5
        //dp(0) = 1
        //dp(n) = sum(dp(n-coin)) n >= coin
        System.out.println(change(5, new int[]{1,2,5}));
    }

    public int change(int amount, int[] coins) {
        long[] dp = new long[amount+1];
        dp[0] = 1;
        for(int coin : coins){
            for(int i = coin; i<=amount; i++){
                System.out.println("===");
                System.out.println("coin = "+coin);
                System.out.println("i = "+i+", coin = "+coin +", dp["+i+"]"+"="+dp[i]);
                dp[i] += dp[i - coin];
                System.out.println("i = "+i+", coin = "+coin +", dp["+i+"]"+"="+dp[i]+", dp[i-coin]=dp["+(i-coin)+"]="+dp[i-coin]);
            }
        }
        return (int)dp[amount];
    }
}
