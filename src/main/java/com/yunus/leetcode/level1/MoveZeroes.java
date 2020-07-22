package com.yunus.leetcode.level1;

/**
 * @author gaoyunfeng
 * @Description: 给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
 * @Description 必须在原数组上操作，不能拷贝额外的数组。
 * @Description 尽量减少操作次数。
 * @date 2020/7/2213:52
 */
public class MoveZeroes {

    public static void main(String[] args) {
        MoveZeroes moveZeroes = new MoveZeroes();
        int[] arr = {0, 1, 0, 3, 12};
        int[] arr2 = {0, 0, 1};
        moveZeroes.moveZeroes(arr2);
    }


    /**
     * 输入: [0,1,0,3,12]
     * 输出: [1,3,12,0,0]
     * 输入: [0,0,1]
     * 输出: [1,0,0]
     *
     * @param nums
     */
    public void moveZeroes(int[] nums) {
        int idx = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0){
                nums[idx++] = nums[i];
            }
        }
        for (int i = idx; i < nums.length; i++) {
            nums[i] = 0;
        }
        // 打印数组
        for (int i = 0; i < nums.length; i++) {
            System.out.print(nums[i] + " ");
        }
    }

}
