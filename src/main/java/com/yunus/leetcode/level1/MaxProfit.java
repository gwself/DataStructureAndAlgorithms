package com.yunus.leetcode.level1;

/**
 * @author gaoyunfeng
 * @Description: 买卖股票的最佳时机
 * @date 2021/1/21 16:17
 */
public class MaxProfit {

    /**
     * 121.买卖股票的最佳时机
     *
     * @param prices
     * @return
     */
    public int maxProfit(int[] prices) {
        int minprice = Integer.MAX_VALUE;
        int maxprofit = 0;
        for (int i = 0; i < prices.length; i++) {
            if (prices[i] < minprice) {
                minprice = prices[i];
            }
            if (prices[i] - minprice > maxprofit) {
                maxprofit = prices[i] - minprice;
            }
        }
        return maxprofit;
    }

    /**
     * 122. 买卖股票的最佳时机 II
     *
     * @param prices
     * @return
     */
    public int maxProfit2(int[] prices) {
        int n = prices.length;
        int[][] dp = new int[n][2];
        dp[0][0] = 0;
        dp[0][1] = -prices[0];
        for (int i = 1; i < n; ++i) {
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i]);
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] - prices[i]);
        }
        return dp[n - 1][0];
    }


    public static void main(String[] args) {
        int[] prices = {7, 1, 5, 3, 6, 4};
        MaxProfit maxProfit = new MaxProfit();
        int i = maxProfit.maxProfit(prices);
        System.out.println(i);
    }

}
