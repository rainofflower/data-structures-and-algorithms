package com.yanghui.leetcode;

import org.junit.Test;

public class Problem322 {

    @Test
    public void test(){
        //[1,2147483647]
        //2
        //dp(0) = 0
        //dp(n) = min(dp(n-coin) + 1)
        System.out.println(coinChange(new int[]{4,2,5}, 3));
        System.out.println(coinChange2(new int[]{4,2,5}, 3));
        System.out.println(coinChange3(new int[]{4,2,5}, 3));
    }

    /**
     * 动态规划解法
     * @param coins
     * @param amount
     * @return
     */
    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        for(int i = 0; i< dp.length ; i++){
            //此处没使用Integer.MAX_VALUE是防止1 + dp[i - coin] 超出int最大值，变成负数，导致Math.min取小的时候值为负数，实际应该为大于int最大值+1的数
            dp[i] = amount + 1;
        }
        dp[0] = 0;
        for(int i = 0; i<dp.length;i++){
            for(int coin : coins){
                if(i - coin < 0){
                    continue;
                }
                dp[i] = Math.min(dp[i], 1 + dp[i - coin]);
//                System.out.println("i = "+i+", coin = "+coin +", dp["+i+"]"+"="+dp[i]+", dp[i-coin]=dp["+(i-coin)+"]="+dp[i-coin]);
            }
        }
        return dp[amount] == amount + 1 ? -1 : dp[amount];
    }

    /**
     * 递归解法（穷举暴力解法）时间复杂度 O(k*k^n) k:零钱币值数；n:要凑的钱 。 k^n为子问题数（节点数），k倍是每个节点for循环的复杂度
     * @param coins
     * @param amount
     * @return
     */
    public int coinChange2(int[] coins, int amount) {
        return traverse2(coins, amount);
    }

    private int traverse2(int[] coins, int amount){
        if(amount == 0) return 0;
        if(amount < 0) return -1;
        int res = Integer.MAX_VALUE;
        for(int coin : coins){
            int subValue = traverse2(coins, amount - coin);
            if(subValue == -1){
                continue;
            }
            res = Math.min(res, subValue + 1);
        }
        return res == Integer.MAX_VALUE ? -1 : res;
    }


    /**
     * 带备忘录的递归解法 时间复杂度 O(n*k) 子问题数
     * @param coins
     * @param amount
     * @return
     */
    public int coinChange3(int[] coins, int amount) {
        int[] memo = new int[amount+1];
        for(int i = 0; i<memo.length; i++){
            memo[i] = Integer.MAX_VALUE;
        }
        return traverse3(coins, amount, memo);
    }

    private int traverse3(int[] coins, int amount, int[] memo){
        if(amount == 0) return 0;
        if(amount < 0) return -1;
        if(memo[amount] != Integer.MAX_VALUE){
            return memo[amount];
        }
        for(int coin : coins){
            int subValue = traverse3(coins, amount - coin, memo);
            if(subValue == -1){
                continue;
            }
            memo[amount] = Math.min(memo[amount], subValue + 1);
            System.out.println("amount = "+amount+", coin = "+coin+",memo["+amount+"]="+memo[amount]);
        }
        return memo[amount] == Integer.MAX_VALUE ? -1 : memo[amount];
    }

}
