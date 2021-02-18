package com.yunus.leetcode.level2;

import com.yunus.leetcode.TreeNode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author gaoyunfeng
 * @Description: 652. 寻找重复的子树
 * @date 2021/2/18 14:54
 */
public class FindDuplicateSubtrees {


    public TreeNode buildTree() {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.right.left = new TreeNode(2);
        root.right.left.left = new TreeNode(4);
        root.right.right = new TreeNode(4);
        return root;
    }


    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        Map<String, Integer> count = new HashMap<>();
        List<TreeNode> ans = new ArrayList<>();
        collect(root, ans, count);
        return ans;
    }

    public String collect(TreeNode root, List<TreeNode> res, Map<String, Integer> count) {
        if (root == null) {
            return "#";
        }
        String left = collect(root.left, res, count);
        String right = collect(root.right, res, count);
        String temp = left + "," + right + "," + root.val;
        int times = count.getOrDefault(temp, 0);
        if (times == 1) {
            res.add(root);
        }
        count.put(temp, times + 1);
        return temp;
    }

    public static void main(String[] args) {
        FindDuplicateSubtrees findDuplicateSubtrees = new FindDuplicateSubtrees();
        TreeNode root = findDuplicateSubtrees.buildTree();
        findDuplicateSubtrees.findDuplicateSubtrees(root);
    }
}
