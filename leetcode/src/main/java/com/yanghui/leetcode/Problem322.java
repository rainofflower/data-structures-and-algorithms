package com.yanghui.leetcode;

import org.junit.Test;

public class Problem322 {

    @Test
    public void test(){
        //[1,2147483647]
        //2
        //dp(0) = 0
        //dp(n) = min(dp(n-coin) + 1)
        System.out.println(coinChange(new int[]{1,2,5}, 5));
    }

    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        for(int i = 0; i< amount+1 ; i++){
            dp[i] = amount + 1;
        }
        dp[0] = 0;
        for(int i = 0; i<dp.length;i++){
            for(int coin : coins){
                if(i - coin < 0){
                    continue;
                }
                dp[i] = Math.min(dp[i], 1 + dp[i - coin]);
                System.out.println("i = "+i+", coin = "+coin +", dp["+i+"]"+"="+dp[i]+", dp[i-coin]=dp["+(i-coin)+"]="+dp[i-coin]);
            }
        }
        return dp[amount] == amount + 1 ? -1 : dp[amount];
    }

}
