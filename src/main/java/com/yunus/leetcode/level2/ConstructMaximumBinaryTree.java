package com.yunus.leetcode.level2;

import com.yunus.leetcode.TreeNode;

/**
 * @author gaoyunfeng
 * @Description: 654. 最大二叉树
 * @date 2021/2/18 14:29
 */
public class ConstructMaximumBinaryTree {

    public TreeNode constructMaximumBinaryTree(int[] nums) {
        return build(nums, 0, nums.length - 1);
    }

    /**
     * 将 nums[lo..hi] 构造成符合条件的树，返回根节点
     *
     * @param nums
     * @param lo   开始位置 0
     * @param hi   初始开始位置 nums.length-1
     */
    TreeNode build(int[] nums, int lo, int hi) {
        if (lo > hi) {
            return null;
        }
        // 找到数组中的最大值和对应的索引
        int index = -1, maxVal = Integer.MIN_VALUE;
        for (int i = lo; i <= hi; i++) {
            if (maxVal < nums[i]) {
                index = i;
                maxVal = nums[i];
            }
        }
        TreeNode root = new TreeNode(maxVal);
        root.left = build(nums, lo, index - 1);
        root.right = build(nums, index + 1, hi);
        return root;
    }

}
