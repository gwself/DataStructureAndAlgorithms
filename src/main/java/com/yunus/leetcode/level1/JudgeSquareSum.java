package com.yunus.leetcode.level1;

/**
 * @author gaoyunfeng
 * @Description: 两数平方和  633
 * 例如： input 5
 * 1*1 + 2*2 = 5
 * @date 2020/9/16 13:44
 */
public class JudgeSquareSum {

    /**
     * 双指针解发
     *
     * @param c input
     * @return false true
     */
    public boolean judgeSquareSum(int c) {
        if (c < 0) {
            return false;
        }
        int i = 0, j = (int) Math.sqrt(c);
        while (i <= j) {
            int powSum = i * i + j * j;
            if (powSum == c) {
                return true;
            } else if (powSum > c) {
                j--;
            } else {
                i++;
            }
        }
        return false;
    }
}
