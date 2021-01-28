package com.yunus.leetcode.level2;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author gaoyunfeng
 * @Description: 数组可能的全排列
 * @date 2020/8/119:57
 */
public class Permute {

    public static void main(String[] args) {
        Permute permute = new Permute();
        int[] arr = {1, 2, 3};
        List<List<Integer>> list = permute.permute2(arr);
        list.stream().forEach(System.out::print);
    }


    public List<List<Integer>> permute2(int[] nums) {
        // 首先是特判
        int len = nums.length;
        // 使用一个动态数组保存所有可能的全排列
        List<List<Integer>> res = new ArrayList<>();

        if (len == 0) {
            return res;
        }

        boolean[] used = new boolean[len];
        List<Integer> path = new ArrayList<>();

        dfs(nums, len, 0, path, used, res);
        return res;
    }

    private void dfs(int[] nums, int len, int depth,
                     List<Integer> path, boolean[] used,
                     List<List<Integer>> res) {
        if (depth == len) {
            res.add(new ArrayList<>(path));
            return;
        }

        for (int i = 0; i < len; i++) {
            if (!used[i]) {
                path.add(nums[i]);
                used[i] = true;

                dfs(nums, len, depth + 1, path, used, res);
                // 注意：这里是状态重置，是从深层结点回到浅层结点的过程，代码在形式上和递归之前是对称的
                used[i] = false;
                path.remove(path.size() - 1);
            }
        }
    }

    List<List<Integer>> res = new LinkedList<>();

    /**
     * 回溯算法解决
     * 主函数，输入一组不重复的数字，返回它们的全排列
     */
    private List<List<Integer>> permute3(int[] nums) {
        // 记录「路径」
        LinkedList<Integer> track = new LinkedList<>();
        backtrack(nums, track);
        return res;
    }

    /**
     * 路径：记录在 track 中
     *
     * @param nums  选择列表：nums 中不存在于 track 的那些元素
     * @param track 结束条件：nums 中的元素全都在 track 中出现
     */
    private void backtrack(int[] nums, LinkedList<Integer> track) {
        // 触发结束条件
        if (track.size() == nums.length) {
            res.add(new LinkedList(track));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            // 排除不合法的选择
            if (track.contains(nums[i]))
                continue;
            // 做选择
            track.add(nums[i]);
            // 进入下一层决策树
            backtrack(nums, track);
            // 取消选择
            track.removeLast();
        }
    }
}