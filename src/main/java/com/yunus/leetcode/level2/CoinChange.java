package com.yunus.leetcode.level2;

import java.util.Arrays;

/**
 * @author gaoyunfeng
 * @Description: 322. 零钱兑换  动态规划 dp  备忘录
 * https://github.com/labuladong/fucking-algorithm/blob/master/%E5%8A%A8%E6%80%81%E8%A7%84%E5%88%92%E7%B3%BB%E5%88%97/%E5%8A%A8%E6%80%81%E8%A7%84%E5%88%92%E8%AF%A6%E8%A7%A3%E8%BF%9B%E9%98%B6.md
 * @date 2020/10/10 14:55
 */
public class CoinChange {

    public static void main(String[] args) {
        CoinChange coinChange = new CoinChange();
        int[] coins = {1,2,5};
        int dp = coinChange.dp(coins, 11);
        System.out.println(dp);
    }

    /**
     * 暴力法
     *
     * @return
     */
    public int dp(int[] coins, int amount) {
        if (amount < 0) {
            return -1;
        }
        if (amount == 0) {
            return 0;
        }
        // 求最小值，所以初始化为正无穷
        int res = Integer.MAX_VALUE;
        for (int i = 0; i < coins.length; i++) {
            int subProblem = dp(coins, amount - coins[i]);
            if (subProblem == -1) {
                continue;
            }
            res = Math.min(res, subProblem + 1);
        }
        return res == Integer.MAX_VALUE ? -1 : res;
    }

    public int coinChange(int[] coins, int amount) {
        if (amount < 1) {
            return 0;
        }
        return coinChange(coins, amount, new int[amount]);
    }

    /**
     * 自上而下
     *
     * @param coins
     * @param rem
     * @param dp    dp 存储
     * @return
     */
    private int coinChange(int[] coins, int rem, int[] dp) {
        if (rem < 0) {
            return -1;
        }
        if (rem == 0) {
            return 0;
        }
        if (dp[rem - 1] != 0) {
            return dp[rem - 1];
        }
        int min = Integer.MAX_VALUE;
        for (int coin : coins) {
            int res = coinChange(coins, rem - coin, dp);
            if (res >= 0 && res < min) {
                min = 1 + res;
            }
        }
        dp[rem - 1] = (min == Integer.MAX_VALUE) ? -1 : min;
        return dp[rem - 1];
    }

    /**
     * 动态规划：自下而上
     *
     * @param coins
     * @param amount
     * @return
     */
    public int coinChange2(int[] coins, int amount) {
        int max = amount + 1;
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, max);
        dp[0] = 0;
        for (int i = 1; i <= amount; i++) {
            for (int j = 0; j < coins.length; j++) {
                if (coins[j] <= i) {
                    dp[i] = Math.min(dp[i], dp[i - coins[j]] + 1);
                }
            }
        }
        return dp[amount] > amount ? -1 : dp[amount];
    }

}
