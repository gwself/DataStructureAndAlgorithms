package com.yunus.other;

import java.util.ArrayList;

/**
 * 有四种不同面额的货币，当奖金是n 时，有多少种货币组成方式组成奖金n
 *
 * @author gaoyunfeng
 */
public class Recursion {

    /**
     * 四种面额的纸币
     */
    public static long[] rewards = {1, 2, 5, 10};

    /**
     * @param totalReward 奖赏总金额，
     * @param result      保存当前的解
     * @Description: 使用函数的递归（嵌套）调用，找出所有可能的奖赏组合
     */
    public static void get(long totalReward, ArrayList<Long> result) {
        // 当 totalReward = 0 时，证明它是满足条件的解，结束嵌套调用，输出解
        if (totalReward == 0) {
            System.out.println(result);
            return;
        } else if (totalReward < 0) {
            // 当 totalReward < 0 时，证明它不是满足条件的解，不输出
            return;
        } else {
            for (int i = 0; i < rewards.length; i++) {
                ArrayList<Long> newResult = (ArrayList<Long>) (result.clone());
                newResult.add(rewards[i]);
                // 剩下的
                get(totalReward - rewards[i], newResult);
            }
        }
    }
}