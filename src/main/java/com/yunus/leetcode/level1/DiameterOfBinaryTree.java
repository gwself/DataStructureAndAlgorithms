package com.yunus.leetcode.level1;

import com.yunus.leetcode.TreeNode;

/**
 * @author gaoyunfeng
 * @Description: 543. 二叉树的直径
 * https://leetcode-cn.com/problems/diameter-of-binary-tree/
 * @date 2021/1/22 10:57
 */
public class DiameterOfBinaryTree {

    int ans;

    public int diameterOfBinaryTree(TreeNode root) {
        ans = 1;
        depth(root);
        return ans - 1;
    }

    public int depth(TreeNode node) {
        if (node == null) {
            // 访问到空节点了，返回0
            return 0;
        }
        // 左儿子为根的子树的深度
        int L = depth(node.left);
        // 右儿子为根的子树的深度
        int R = depth(node.right);
        // 计算d_node即L+R+1 并更新ans
        ans = Math.max(ans, L + R + 1);
        // 返回该节点为根的子树的深度
        return Math.max(L, R) + 1;
    }

}
