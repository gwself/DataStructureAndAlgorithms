package com.yunus.leetcode.level1;

/**
 * @author gaoyunfeng
 * @Description: 旋转数组
 * @date 2020/9/14 15:44
 */
public class RotateArray {

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7};
        int k = 3;
        rotate(arr, k);
    }

    public static void rotate(int[] nums, int k) {
        int[] a = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            a[(i + k) % nums.length] = nums[i];
        }
        for (int i = 0; i < nums.length; i++) {
            nums[i] = a[i];
        }
    }

    public static void rotate2(int[] nums, int k) {
        for (int i = 0; i < k; i++) {
            offsetOne(nums);
        }
    }

    public static void offsetOne(int[] arr) {
        int last = arr[arr.length - 1];
        for (int i = arr.length - 1; i > 0; i--) {
            arr[i] = arr[i - 1];
        }
        arr[0] = last;
    }

}
