package com.yunus.leetcode.level1;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * @author gaoyunfeng
 * @Description: leetcode 题号：448. 找到所有数组中消失的数字
 * @description: 给定一个范围在  1 ≤ a[i] ≤ n ( n = 数组大小 ) 的 整型数组，数组中的元素一些出现了两次，另一些只出现一次。
 * @date 2020/7/239:59
 */
public class FindDisappearedNumbers {

    public static void main(String[] args) {
        FindDisappearedNumbers demo = new FindDisappearedNumbers();
        int[] arr = {4, 3, 2, 7, 8, 2, 3, 1};
        List<Integer> result = demo.findDisappearedNumbers(arr);
        result.stream().forEach(System.out::println);
    }

    /**
     * 输入:
     * [4,3,2,7,8,2,3,1]
     * 输出:
     * [5,6]
     *
     * @param nums
     * @return
     */
    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> all = IntStream.rangeClosed(1, nums.length).boxed().collect(Collectors.toList());
        for (int i = 0; i < nums.length; i++) {
            if (all.contains(nums[i])) {
                all.remove(Integer.valueOf(nums[i]));
            }
        }
        return all;
    }

}
