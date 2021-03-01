package com.yunus.leetcode.level1;

import com.yunus.leetcode.TreeNode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author gaoyunfeng
 * @Description: 获取二叉树每层 最大值
 * @date 2021/3/1 12:09
 */
public class EveryLevelMaxValue {

    static Map<Integer, List<Integer>> map = new HashMap<>();

    public static void main(String[] args) {
        TreeNode left = new TreeNode(5, new TreeNode(9), null);
        TreeNode right = new TreeNode(3, new TreeNode(4), new TreeNode(7));
        TreeNode root = new TreeNode(2, left, right);
        everyLevelMaxValue(root);
    }

    public static void everyLevelMaxValue(TreeNode root) {
        getEveryLevel(root, 1);
        map.forEach((key, value) -> System.out.println("第" + key + "层最大值：" + value.stream().max(Integer::compareTo).get()));
    }

    public static void getEveryLevel(TreeNode root, int high) {
        if (root == null) {
            return;
        }
        List<Integer> levels = map.getOrDefault(high, new ArrayList<>());
        levels.add(root.val);
        map.put(high, levels);
        getEveryLevel(root.left, high + 1);
        getEveryLevel(root.right, high + 1);
    }

}
