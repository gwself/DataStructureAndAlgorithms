package com.yunus.leetcode.level1;

/**
 * @author gaoyunfeng
 * @Description: 剑指 Offer 42. 连续子数组的最大和
 * @date 2021/5/14 8:35
 */
public class MaxSubArray {
    public int maxSubArray(int[] nums) {
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        int max = dp[0];
        for (int i = 1; i < nums.length; i++) {
            dp[i] = Math.max(dp[i - 1] + nums[i], nums[i]);
            max = Math.max(max, dp[i]);
        }
        return max;
    }
}
