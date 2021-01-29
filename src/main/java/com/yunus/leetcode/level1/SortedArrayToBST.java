package com.yunus.leetcode.level1;

import com.yunus.leetcode.TreeNode;

/**
 * @author gaoyunfeng
 * @Description: 108. 将有序数组转换为二叉搜索树
 * @date 2021/1/29 13:45
 */
public class SortedArrayToBST {


    public TreeNode sortedArrayToBST(int[] nums) {
        return helper(nums, 0, nums.length - 1);
    }

    public TreeNode helper(int[] nums, int left, int right) {
        if (left > right) {
            return null;
        }
        int mid = (left + right) / 2;
        TreeNode root = new TreeNode(nums[mid]);
        TreeNode leftTree = helper(nums, left, mid - 1);
        root.left = leftTree;
        TreeNode rightTree = helper(nums, mid + 1, right);
        root.right = rightTree;
        return root;
    }

}
