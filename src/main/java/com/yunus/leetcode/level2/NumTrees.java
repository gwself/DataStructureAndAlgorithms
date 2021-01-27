package com.yunus.leetcode.level2;

/**
 * @author gaoyunfeng
 * @Description: 96. 不同的二叉搜索树
 * @date 2021/1/27 11:00
 */
public class NumTrees {

    /**
     * 动态规划 dp[]
     *
     * @param n
     * @return
     */
    public int numTrees(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;

        for (int i = 2; i <= n; ++i) {
            for (int j = 1; j <= i; ++j) {
                dp[i] += dp[j - 1] * dp[i - j];
            }
        }
        return dp[n];
    }
}
