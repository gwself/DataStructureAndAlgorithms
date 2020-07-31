package com.yunus.leetcode.level2;

import com.yunus.leetcode.TreeNode;

/**
 * @author gaoyunfeng
 * @Description: 二叉树展开为链表
 * @date 2020/7/3110:21
 */
public class Flatten {

    public void flatten(TreeNode root) {
        while (root != null) {
            //左子树为 null，直接考虑下一个节点
            if (root.left != null) {
                // 找左子树最右边的节点
                TreeNode pre = root.left;
                while (pre.right != null) {
                    pre = pre.right;
                }
                //将原来的右子树接到左子树的最右边节点
                pre.right = root.right;
                // 将左子树插入到右子树的地方
                root.right = root.left;
                root.left = null;
                // 考虑下一个节点
            }
            root = root.right;
        }
    }

    private TreeNode pre = null;

    public void flatten2(TreeNode root) {
        if (root == null) {
            return;
        }
        flatten(root.right);
        flatten(root.left);
        root.right = pre;
        root.left = null;
        pre = root;
    }
}
