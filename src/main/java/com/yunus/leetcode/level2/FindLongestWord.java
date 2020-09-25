package com.yunus.leetcode.level2;

import java.util.List;

/**
 * @author gaoyunfeng
 * @Description: 524. 通过删除字母匹配到字典里最长单词
 * @date 2020/9/25 14:46
 */
public class FindLongestWord {

    /**
     * 给定一个字符串和一个字符串字典，找到字典里面最长的字符串，该字符串可以通过删除给定字符串的某些字符来得到。如果答案不止一个，返回长度最长且字典顺序最小的字符串。如果答案不存在，则返回空字符串。
     * <p>
     * 示例 1:
     * <p>
     * 输入:
     * s = "abpcplea", d = ["ale","apple","monkey","plea"]
     * <p>
     * 输出:
     * "apple"
     * 示例 2:
     * <p>
     * 输入:
     * s = "abpcplea", d = ["a","b","c"]
     * <p>
     * 输出:
     * "a"
     * 说明:
     * <p>
     * 所有输入的字符串只包含小写字母。
     * 字典的大小不会超过 1000。
     * 所有输入的字符串长度不会超过 1000。
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/longest-word-in-dictionary-through-deleting
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * @param s 字符串
     * @param d 字符串字典
     * @return
     */
    public String findLongestWord(String s, List<String> d) {
        String longestWord = "";
        for (String target : d) {
            int l1 = longestWord.length(), l2 = target.length();
            if (l1 > l2 || (l1 == l2 && longestWord.compareTo(target) < 0)) {
                continue;
            }
            if (isSubstr(s, target)) {
                longestWord = target;
            }
        }
        return longestWord;
    }


    /**
     * 双指针判断 target 是否为s 的子串
     *
     * @param s      原字符串
     * @param target 目标字符串
     * @return true 是 false 不是
     */
    private boolean isSubstr(String s, String target) {
        int i = 0, j = 0;
        while (i < s.length() && j < target.length()) {
            if (s.charAt(i) == target.charAt(j)) {
                j++;
            }
            i++;
        }
        return j == target.length();
    }
}
