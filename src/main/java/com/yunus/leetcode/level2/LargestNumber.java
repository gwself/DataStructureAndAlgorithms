package com.yunus.leetcode.level2;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author gaoyunfeng
 * @Description: 179. 最大数
 * @date 2021/2/24 10:30
 */
public class LargestNumber {

    private class LargerNumberComparator implements Comparator<String> {
        @Override
        public int compare(String a, String b) {
            String order1 = a + b;
            String order2 = b + a;
            return order2.compareTo(order1);
        }
    }

    public String largestNumber(int[] nums) {
        String[] numStr = new String[nums.length];
        for (int i = 0; i < nums.length; i++) {
            numStr[i] = String.valueOf(nums[i]);
        }
        Arrays.sort(numStr, new LargerNumberComparator());
        if ("0".equals(numStr[0])) {
            return "0";
        }
        StringBuilder largestNumberStr = new StringBuilder();
        for (String numAsStr : numStr) {
            largestNumberStr.append(numAsStr);
        }

        return largestNumberStr.toString();
    }
}
