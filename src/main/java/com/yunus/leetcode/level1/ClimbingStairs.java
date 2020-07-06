package com.yunus.leetcode.level1;

/**
 * 爬楼梯
 */
class ClimbingStairs {

    /**
     * 暴力计算
     *
     * @param n 楼梯总数
     * @return
     */
    public int climbStairs(int n) {
        return climb_Stairs(0, n);
    }

    public int climb_Stairs(int i, int n) {
        if (i > n) {
            return 0;
        }
        if (i == n) {
            return 1;
        }
        return climb_Stairs(i + 1, n) + climb_Stairs(i + 2, n);
    }

    /**
     * 动态规划
     * 第 i 阶可以由以下两种方法得到：
     * 在第 (i-1)阶后向上爬一阶。
     * 在第 (i-2)阶后向上爬 2 阶。
     * 所以到达第 i 阶的方法总数就是到第 (i−1) 阶和第 (i−2) 阶的方法数之和。
     * 令dp[i] 表示能到达第 i 阶的方法总数：
     * dp[i]=dp[i-1]+dp[i-2]
     *
     * @param n 台阶数
     * @return
     */
    public int climbStairs2(int n) {
        if (n == 1) {
            return 1;
        }
        int[] dp = new int[n + 1];
        dp[1] = 1;
        dp[2] = 2;
        for (int i = 3; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }

}