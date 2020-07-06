package com.yunus.leetcode.level1;

import com.yunus.leetcode.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author gaoyunfeng
 * @Description: 翻转二叉树
 * @date 2020/7/611:07
 */
public class InvertTree {

    /**
     * 递归翻转二叉树
     *
     * @param root
     * @return
     */
    public TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return null;
        }
        TreeNode left = invertTree(root.left);
        TreeNode right = invertTree(root.right);
        root.left = right;
        root.right = left;
        return root;
    }

    /**
     * 迭代 翻转
     *
     * @param root
     * @return
     */
    public TreeNode invertTree2(TreeNode root) {
        if (root == null) return null;
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode current = queue.poll();
            TreeNode temp = current.left;
            current.left = current.right;
            current.right = temp;
            if (current.left != null) {
                queue.add(current.left);
            }
            if (current.right != null) {
                queue.add(current.right);
            }
        }
        return root;
    }

}
