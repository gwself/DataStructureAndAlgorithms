package com.yunus.leetcode.level1;

/**
 * @author gaoyunfeng
 * @Description: 验证回文字符串
 * 可以删除一个字符，判断是否能构成回文字符串。
 * @date 2020/9/17 13:37
 */
public class ValidPalindrome {

    /**
     * 双指针解法
     *
     * @param s 待验证字符串
     * @return true false
     */
    public boolean validPalindrome(String s) {
        for (int i = 0, j = s.length() - 1; i < j; i++, j--) {
            if (s.charAt(i) != s.charAt(j)) {
                return isPalindrome(s, i, j - 1) || isPalindrome(s, i + 1, j);
            }
        }
        return true;
    }


    /**
     * 判断是否为回文字符串
     *
     * @param s 待验证字符串
     * @param i 开始位置
     * @param j 结束位置
     * @return true false
     */
    private boolean isPalindrome(String s, int i, int j) {
        while (i < j) {
            if (s.charAt(i++) != s.charAt(j--)) {
                return false;
            }
        }
        return true;
    }
}
