package com.yunus.leetcode.level1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author gaoyunfeng
 * @Description:406. 根据身高重建队列
 * https://leetcode-cn.com/problems/queue-reconstruction-by-height/
 * <p>
 * [[7,0],[4,4],[7,1],[5,0],[6,1],[5,2]]
 * 按身高排序后
 * [[4,4],[5,0],[5,2],[6,1],[7,0],[7,1]]
 * @date 2021/1/25 14:21
 */
public class ReconstructQueue {

    public static void main(String[] args) {
        int[][] people = {{6, 0}, {5, 0}, {4, 0}, {3, 2}, {2, 2}, {1, 4}};
        ReconstructQueue reconstructQueue = new ReconstructQueue();
        int[][] result = reconstructQueue.reconstructQueue(people);
        for (int[] ints : result) {
            System.out.println(ints[0] + "-" + ints[1]);
        }
    }

    public int[][] reconstructQueue(int[][] people) {
        Arrays.sort(people, (person1, person2) -> {
            if (person1[0] != person2[0]) {
                return person2[0] - person1[0];
            } else {
                return person1[1] - person2[1];
            }
        });
        List<int[]> ans = new ArrayList<>();
        for (int[] person : people) {
            ans.add(person[1], person);
        }
        return ans.toArray(new int[ans.size()][]);
    }
}
