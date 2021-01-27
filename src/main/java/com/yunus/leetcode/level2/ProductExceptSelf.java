package com.yunus.leetcode.level2;

import org.junit.Test;

import java.util.Arrays;

/**
 * @author gaoyunfeng
 * @Description: 238. 除自身以外数组的乘积
 * @date 2021/1/27 10:04
 */
public class ProductExceptSelf {

    /**
     * 首先暴力法O(n²)
     *
     * @param nums
     * @return
     */
    public int[] productExceptSelf2(int[] nums) {
        int[] output = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            int result = 1;
            for (int j = 0; j < nums.length; j++) {
                if (j == i) {
                    continue;
                }
                result = result * nums[j];
            }
            output[i] = result;
        }
        return output;
    }

    public int[] productExceptSelf(int[] nums) {
        int length = nums.length;

        // left 和 right 分别表示左右两侧的乘积列表
        int[] left = new int[length];
        int[] right = new int[length];

        int[] answer = new int[length];

        // left[i] 为索引 i 左侧所有元素的乘积
        // 对于索引为 '0' 的元素，因为左侧没有元素，所以 left[0] = 1
        left[0] = 1;
        for (int i = 1; i < length; i++) {
            left[i] = nums[i - 1] * left[i - 1];
        }

        // right[i] 为索引 i 右侧所有元素的乘积
        // 对于索引为 'length-1' 的元素，因为右侧没有元素，所以 right[length-1] = 1
        right[length - 1] = 1;
        for (int i = length - 2; i >= 0; i--) {
            right[i] = nums[i + 1] * right[i + 1];
        }

        // 对于索引 i，除 nums[i] 之外其余各元素的乘积就是左侧所有元素的乘积乘以右侧所有元素的乘积
        for (int i = 0; i < length; i++) {
            answer[i] = left[i] * right[i];
        }

        return answer;
    }

    @Test
    public void test() {
        int[] nums = {1, 2, 3, 4};
        int[] output = productExceptSelf2(nums);
        Arrays.stream(output).forEach(System.out::println);
    }
}
