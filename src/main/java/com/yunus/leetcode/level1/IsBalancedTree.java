package com.yunus.leetcode.level1;

import com.yunus.leetcode.TreeNode;

/**
 * @author gaoyunfeng
 * @Description: 是否为平衡二叉树
 * 输入一棵二叉树，判断该二叉树是否是平衡二叉树。
 * 在这里，我们只需要考虑其平衡性，不需要考虑其是不是排序二叉树
 * 平衡二叉树（Balanced Binary Tree），具有以下性质：它是一棵空树或它的左右两个子树的高度差的绝对值不超过1，并且左右两个子树都是一棵平衡二叉树。
 * @date 2021/3/26 9:31
 */
public class IsBalancedTree {

    public boolean isBalancedTree(TreeNode root) {
        if (root == null) {
            return true;
        }
        if (Math.abs(TreeDepth(root.left) - TreeDepth(root.right)) > 1) {
            return false;
        }
        return isBalancedTree(root.left) && isBalancedTree(root.right);
    }

    public int TreeDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        if (root.left == null && root.right == null) {
            return 1;
        }
        return 1 + Math.max(TreeDepth(root.left), TreeDepth(root.right));
    }
}
