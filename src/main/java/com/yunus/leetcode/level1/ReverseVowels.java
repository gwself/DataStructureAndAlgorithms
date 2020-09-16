package com.yunus.leetcode.level1;

import java.util.Arrays;
import java.util.HashSet;

/**
 * @author gaoyunfeng
 * @Description: 反转字符串中的元音字符  345
 * @date 2020/9/16 14:01
 */
public class ReverseVowels {

    private final static HashSet<Character> VOWELS = new HashSet<>(
            Arrays.asList('a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U'));

    /**
     * 双指针解法
     *
     * @param s target string
     * @return String 反转后的字符串
     */
    public String reverseVowels(String s) {
        if (s == null) {
            return null;
        }
        // 双指针 i 从左边   j 从右边
        int i = 0, j = s.length() - 1;
        char[] result = new char[s.length()];
        while (i <= j) {
            char left = s.charAt(i);
            char right = s.charAt(j);
            if (!VOWELS.contains(left)) {
                result[i++] = left;
            } else if (!VOWELS.contains(right)) {
                result[j++] = right;
            } else {
                result[i++] = right;
                result[j++] = left;
            }
        }
        return String.valueOf(result);
    }
}
