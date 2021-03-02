package com.yunus.leetcode.level1;

import java.util.HashMap;
import java.util.Map;

/**
 * @author gaoyunfeng
 * @Description: 1. 两数之和
 * @date 2021/3/2 10:47
 */
public class TwoSum {

    public static int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> remains = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (remains.containsKey(nums[i])) {
                Integer index = remains.get(nums[i]);
                return new int[]{index, i};
            }
            int remain = target - nums[i];
            remains.put(remain, i);
        }
        return new int[0];
    }
}
