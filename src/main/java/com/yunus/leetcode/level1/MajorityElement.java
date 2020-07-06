package com.yunus.leetcode.level1;


import java.util.HashMap;
import java.util.Map;

/**
 * 多数元素
 *
 * @author gaoyunfeng
 */
public class MajorityElement {

    public int majorityElement(int[] nums) {

        Integer element = null;
        Integer maxCount = 0;

        Map<Integer, Integer> container = new HashMap<Integer, Integer>(nums.length);
        for (int i = 0; i < nums.length; i++) {
            Integer key = nums[i];
            Integer count = 1;
            if (container.containsKey(key)) {
                count = container.get(key);
                container.put(key, ++count);
            } else {
                container.put(key, 1);
            }
            if (count > nums.length / 2 && maxCount < count) {
                element = key;
                maxCount = count;
            }
        }
        return element == null ? -1 : element;
    }
}
