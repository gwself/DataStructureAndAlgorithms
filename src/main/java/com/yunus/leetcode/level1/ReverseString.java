package com.yunus.leetcode.level1;

/**
 * @author gaoyunfeng
 * @Description: 344. 反转字符串
 * @date 2021/1/29 14:05
 */
public class ReverseString {

    public void reverseString(char[] s) {
        int left = 0, right = s.length-1;
        while (left < right) {
            // 交换
            char temp = s[left];
            s[left] = s[right];
            s[right] = temp;
            left++;
            right--;
        }
    }
}
