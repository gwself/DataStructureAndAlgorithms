package com.yunus.leetcode.level1;


import com.yunus.leetcode.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 111 题 最小深度
 */
public class MinDepth {

    /**
     * bfs 算法查询二叉树最小深度
     * 当我们找到一个叶子节点时，直接返回这个叶子节点的深度。广度优先搜索的性质保证了最先搜索到的叶子节点的深度一定最小
     *
     * @param root 根节点
     */
    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        // 记录左右节点
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int depth = 1;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                // 移除
                TreeNode current = queue.poll();
                // 判断是否是叶子节点
                if (current.left == null && current.right == null) {
                    return depth;
                }
                if (current.left != null) {
                    queue.offer(current.left);
                }
                if (current.right != null) {
                    queue.offer(current.right);
                }
            }
            depth++;
        }
        return depth;
    }

    public static int minDepth2(TreeNode root) {
        if (root == null) {
            return 0;
        }

        if (root.left == null && root.right == null) {
            return 1;
        }

        int minDepth = Integer.MAX_VALUE;
        if (root.left != null) {
            minDepth = Math.min(minDepth2(root.left), minDepth);
        }
        if (root.right != null) {
            minDepth = Math.min(minDepth2(root.right), minDepth);
        }

        return minDepth + 1;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3, new TreeNode(9), new TreeNode(20, new TreeNode(15), new TreeNode(7)));
        System.out.println(minDepth2(root));
    }
}
