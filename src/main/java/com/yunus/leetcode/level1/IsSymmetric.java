package com.yunus.leetcode.level1;

import com.yunus.leetcode.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author gaoyunfeng
 * @Description: 101. 对称二叉树
 * https://leetcode-cn.com/problems/symmetric-tree/
 * @date 2021/1/22 10:26
 */
public class IsSymmetric {


    public boolean isSymmetric(TreeNode root) {
        return check(root, root);
    }

    /**
     * 递归
     *
     * @param p
     * @param q
     * @return
     */
    public boolean check(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        }
        if (p == null || q == null) {
            return false;
        }
        return p.val == q.val && check(p.left, q.right) && check(p.right, q.left);
    }

    /**
     * 迭代
     *
     * @param u
     * @param v
     * @return
     */
    public boolean check2(TreeNode u, TreeNode v) {
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(u);
        q.offer(v);
        while (!q.isEmpty()) {
            u = q.poll();
            v = q.poll();
            if (u == null && v == null) {
                continue;
            }
            if ((u == null || v == null) || (u.val != v.val)) {
                return false;
            }

            q.offer(u.left);
            q.offer(v.right);

            q.offer(u.right);
            q.offer(v.left);
        }
        return true;
    }


}
