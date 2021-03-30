package com.yunus.leetcode.level1;

import com.yunus.leetcode.TreeNode;

/**
 * @author gaoyunfeng
 * @Description: 剑指 Offer 54. 二叉搜索树的第k大节点
 * @date 2021/3/30 14:26
 */
public class KthLargest {

    int res, k;

    public int kthLargest(TreeNode root, int k) {
        this.k = k;
        dfs(root);
        return res;
    }

    /**
     * 中序遍历
     *
     * @param root
     */
    void dfs(TreeNode root) {
        if (root == null) {
            return;
        }
        dfs(root.right);
        if (k == 0) {
            return;
        }
        if (--k == 0) {
            res = root.val;
        }
        dfs(root.left);
    }
}
