package com.yunus.leetcode.level2;

/**
 * @author gaoyunfeng
 * @Description: 91. 解码方法
 * @date 2021/3/2 13:38
 */
public class NumDecode {


    /**
     * 状态定义：dp[i]为第i个位置解码方法的总数
     *
     * @param s
     * @return
     */
    public int numDecodings(String s) {
        char[] chars = s.toCharArray();
        if (chars[0] == '0') {
            return 0;
        }
        int[] dp = new int[chars.length];
        dp[0] = 1;
        for (int i = 1; i < chars.length; i++) {
            if (chars[i] == '0') {
                //如果前一位不是1或者2,显然无法解码
                if (chars[i - 1] != '1' && chars[i - 1] != '2') {
                    return 0;
                }
                //如果前一位是1或者2
                dp[i] = i == 1 ? 1 : dp[i - 2];
            } else if (chars[i - 1] == '1' || (chars[i - 1] == '2' && chars[i] >= '1' && chars[i] <= '6')) {
                dp[i] = i == 1 ? dp[i - 1] + 1 : dp[i - 1] + dp[i - 2];
            } else {
                dp[i] = dp[i - 1];
            }
        }
        return dp[chars.length - 1];
    }

}
