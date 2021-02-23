package com.yunus.leetcode.level1;

import java.util.HashSet;
import java.util.Set;

/**
 * @author gaoyunfeng
 * @Description: 268. 丢失的数字
 * @date 2021/2/23 15:17
 */
public class MissingNumber {

    public int missingNumber(int[] nums) {
        Set<Integer> numSet = new HashSet<Integer>();
        for (int num : nums) {
            numSet.add(num);
        }

        int expectedNumCount = nums.length + 1;
        for (int number = 0; number < expectedNumCount; number++) {
            if (!numSet.contains(number)) {
                return number;
            }
        }
        return -1;
    }
}
