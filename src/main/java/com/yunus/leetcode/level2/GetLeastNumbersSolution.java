package com.yunus.leetcode.level2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * @author gaoyunfeng
 * @Description: https://www.nowcoder.com/practice/6a296eb82cf844ca8539b57c23e6e9bf?tpId=190&tqId=35976&rp=1&ru=%2Factivity%2Foj&qru=%2Fta%2Fjob-code-high-rd%2Fquestion-ranking&tab=answerKey
 * @date 2021/3/10 9:36
 */
public class GetLeastNumbersSolution {


    /**
     * 排序法
     *
     * @param input 输入数组
     * @param k     前k个数
     * @return 结果
     */
    public ArrayList<Integer> getLeastNumber(int[] input, int k) {
        ArrayList<Integer> ans = new ArrayList<>();
        Arrays.sort(input);
        for (int i = 0; i < k; i++) {
            ans.add(input[i]);
        }
        return ans;
    }

    public ArrayList<Integer> getLeastNumber2(int[] input, int k) {
        ArrayList<Integer> ans = new ArrayList<>();
        if (k == 0){
            return ans;
        }
        PriorityQueue<Integer> queue = new PriorityQueue<>((e1, e2) -> e2 - e1);
        for (int i = 0; i < k; i++) {
            queue.offer(input[i]);
        }
        for (int i = k; i < input.length; i++) {
            if (queue.peek() > input[i]) {
                queue.poll();
                queue.offer(input[i]);
            }
        }
        while (!queue.isEmpty()) {
            ans.add(queue.poll());
        }
        return ans;
    }


}
