package com.yunus.leetcode.level1;

import com.yunus.leetcode.TreeNode;

import java.util.ArrayList;

/**
 * @author gaoyunfeng
 * @Description: 给定一个二叉树和一个值\ sum sum，请找出所有的根节点到叶子节点的节点值之和等于\ sum sum 的路径，
 * @date 2021/3/26 9:57
 */
public class AllPathSumOfTree {


    private final ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
    private final ArrayList<Integer> temp = new ArrayList<>();

    /**
     * @param root TreeNode类
     * @param sum  int整型
     * @return int整型ArrayList<ArrayList <>>
     */
    public ArrayList<ArrayList<Integer>> pathSum(TreeNode root, int sum) {
        // write code here
        dfs(root,sum,0);
        return ans;
    }

    /**
     * @param root 树
     * @param sum  要求得和
     * @param cnt  当前得和
     */
    public void dfs(TreeNode root, int sum, int cnt) {
        if (root == null) {
            return;
        }
        // 计算当前路径和
        int val = root.val;
        cnt += val;
        temp.add(val);
        // 到了叶子节点
        if (root.left == null && root.right == null) {
            // 和相等加入temp
            if (sum == cnt) {
                ans.add(new ArrayList<>(temp));
            }
        } else {
            dfs(root.left, sum, cnt);
            dfs(root.right, sum, cnt);
        }
        // 撤销temp中已经计算过的元素
        temp.remove(temp.size() - 1);
    }
}
