package com.yunus.leetcode.level2;

import com.yunus.leetcode.TreeNode;

import java.util.*;

/**
 * @author gaoyunfeng
 * @Description: 515. 在每个树行中找最大值
 * @date 2021/3/4 17:00
 */
public class LargestValues {

    Map<Integer, List<Integer>> levels = new TreeMap<>();

    /**
     * 最差的做法
     *
     * @param root 树
     * @return
     */
    public List<Integer> largestValues(TreeNode root) {
        doEveryLevelMaxValue(root, 1);
        List<Integer> result = new ArrayList<>(levels.size());
        levels.forEach((k, v) -> {
            Integer max = v.stream().max(Integer::compareTo).orElseThrow(RuntimeException::new);
            result.add(max);
        });
        return result;
    }


    private void doEveryLevelMaxValue(TreeNode root, int level) {
        if (root == null) {
            return;
        }
        List<Integer> everyLevels = levels.getOrDefault(level, new ArrayList<>());
        everyLevels.add(root.val);
        levels.put(level, everyLevels);
        doEveryLevelMaxValue(root.left, level + 1);
        doEveryLevelMaxValue(root.right, level + 1);
    }


    /**
     * BFS 广度优先
     *
     * @param root 树
     * @return
     */
    public List<Integer> largestValues2(TreeNode root) {
        List<Integer> result = new ArrayList();
        Queue<TreeNode> queue = new ArrayDeque<>();
        if (root != null) {
            queue.offer(root);
        }
        while (!queue.isEmpty()) {
            int size = queue.size();
            int max = Integer.MIN_VALUE;
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                if (max < node.val) {
                    max = node.val;
                }
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
            result.add(max);
        }
        return result;
    }

}
