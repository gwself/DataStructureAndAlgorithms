package com.yunus.leetcode;

/**
 * 67题
 * 给定两个二进制字符串，返回他们的和（用二进制表示）。
 * 输入为非空字符串且只包含数字 1 和 0。
 *
 * @author gaoyunfeng
 */
class AddBinary {

    public String addBinary(String a, String b) {

        StringBuilder sum = new StringBuilder();
        int i = a.length() - 1;
        int j = b.length() - 1;
        int c = 0;
        while (i >= 0 || j >= 0 || c == 1) {
            c += (i >= 0 ? a.charAt(i--) - '0' : 0);
            c += (j >= 0 ? b.charAt(j--) - '0' : 0);
            sum.insert(0, c % 2);
            c >>= 1;
        }
        return sum.toString();
    }

}