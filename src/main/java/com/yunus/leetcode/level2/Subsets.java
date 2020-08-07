package com.yunus.leetcode.level2;

import java.util.ArrayList;
import java.util.List;

/**
 * @author gaoyunfeng
 * @Description: 子集---78题
 * 给定一组不含重复元素的整数数组 nums，返回该数组所有可能的子集（幂集）。
 * @date 2020/8/715:49
 */
public class Subsets {

    /**
     * 子集
     *
     * @param nums 不重复原数组
     * @return
     */
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> output = new ArrayList();
        output.add(new ArrayList<Integer>());

        for (int num : nums) {
            List<List<Integer>> newSubsets = new ArrayList();
            for (List<Integer> curr : output) {
                newSubsets.add(new ArrayList<Integer>(curr) {{
                    add(num);
                }});
            }
            for (List<Integer> curr : newSubsets) {
                output.add(curr);
            }
        }
        return output;
    }
}
