package com.yunus.leetcode.level1;

/**
 * @author gaoyunfeng
 * @Description: 剑指 Offer 62. 圆圈中最后剩下的数字
 * @date 2021/5/20 11:03
 */
public class LastRemaining {

    public int lastRemaining(int n, int m) {
        int f = 0;
        for (int i = 2; i != n + 1; ++i) {
            f = (m + f) % i;
        }
        return f;
    }
}
