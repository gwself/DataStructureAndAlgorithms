package com.yunus.leetcode.level2;

/**
 * @author gaoyunfeng
 * @Description: 647. 回文子串
 * @date 2021/1/25 14:57
 */
public class CountSubstrings {

    /**
     * 暴力法
     *
     * @param s
     * @return
     */
    public int countSubstrings(String s) {
        int length = s.length();
        int sum = 0;
        for (int i = 0; i < length; i++) {
            for (int j = i + 1; j <= length; j++) {
                String substring = s.substring(i, j);
                if (isPalindrome(substring.toCharArray())) {
                    sum++;
                }
            }
        }
        return sum;
    }

    public boolean isPalindrome(char[] chars) {
        int left = 0;
        int right = chars.length - 1;
        while (left < right) {
            if (chars[left] != chars[right]) {
                return false;
            }
            --right;
            ++left;
        }
        return true;
    }

    public static void main(String[] args) {
        CountSubstrings countSubstrings = new CountSubstrings();
        int abc = countSubstrings.countSubstrings("abc");
        System.out.println(abc);
    }
}
