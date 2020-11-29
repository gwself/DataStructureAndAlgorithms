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
                if (current.left != null){
                    queue.offer(current.left);
                }
                if (current.right != null){
                    queue.offer(current.right);
                }
            }
            depth++;
        }
        return depth;
    }
}
