package com.yunus.leetcode.level1;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author gaoyunfeng
 * @Description: 350：两个数组交集
 * @date 2021/1/18 15:44
 */
public class Intersect {

    /**
     * 两个数组交集
     *
     * @param nums1 数组1
     * @param nums2 数组2
     * @return 交集后的数组
     */
    public int[] intersect(int[] nums1, int[] nums2) {
        if (nums1.length > nums2.length) {
            return intersect(nums2, nums1);
        }
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums1) {
            int count = map.getOrDefault(num, 0) + 1;
            map.put(num, count);
        }
        int[] intersection = new int[nums1.length];
        int index = 0;
        for (int num : nums2) {
            int count = map.getOrDefault(num, 0);
            if (count > 0) {
                intersection[index++] = num;
                count--;
                if (count > 0) {
                    map.put(num, count);
                } else {
                    map.remove(num);
                }
            }
        }
        return Arrays.copyOfRange(intersection, 0, index);
    }
}
