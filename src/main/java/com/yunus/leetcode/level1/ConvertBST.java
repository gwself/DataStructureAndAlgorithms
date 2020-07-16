package com.yunus.leetcode.level1;

import com.yunus.leetcode.TreeNode;

import java.util.Stack;

/**
 * @author gaoyunfeng
 * @Description: 二叉搜索树转换为累加树
 * @date 2020/7/1610:18
 */
public class ConvertBST {
    private int sum = 0;

    public TreeNode convertBST(TreeNode root) {
        if (root != null) {
            convertBST(root.right);
            sum += root.val;
            root.val = sum;
            convertBST(root.left);
        }
        return root;
    }

    public TreeNode convertBST2(TreeNode root) {
        int sum = 0;
        TreeNode node = root;
        Stack<TreeNode> stack = new Stack<TreeNode>();

        while (!stack.isEmpty() || node != null) {
            // 压入所有的右节点
            while (node != null) {
                stack.add(node);
                node = node.right;
            }

            node = stack.pop();
            sum += node.val;
            node.val = sum;
            // 压入所有的左节点
            node = node.left;
        }
        return root;
    }
}
