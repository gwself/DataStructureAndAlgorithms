package com.yunus.leetcode.level1;

import java.util.HashMap;
import java.util.Map;

/**
 * @author gaoyunfeng
 * @Description: 136. 只出现一次的数字
 * @date 2021/2/3 10:47
 * @see https://leetcode-cn.com/problems/single-number/
 */
public class SingleNumber {

    public static void main(String[] args) {
        SingleNumber singleNumber = new SingleNumber();
        int[] arr = {1, 2, 3, 1, 2};
        int i = singleNumber.singleNumber(arr);
        System.out.println(i);
    }

    public int singleNumber(int[] nums) {
        Map<Integer, Integer> hash = new HashMap<>(nums.length);
        for (int i = 0; i < nums.length; i++) {
            Integer oldCount = hash.getOrDefault(nums[i], 0);
            hash.put(nums[i], oldCount + 1);
        }
        for (Map.Entry<Integer, Integer> keyValue : hash.entrySet()) {
            int key = keyValue.getKey();
            int value = keyValue.getValue();
            if (value == 1) {
                return key;
            }
        }
        return -1;
    }

}