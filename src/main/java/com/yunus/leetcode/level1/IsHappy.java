package com.yunus.leetcode.level1;

import java.util.ArrayList;
import java.util.List;

/**
 * @author gaoyunfeng
 * @Description: 202. 快乐数
 * @date 2021/2/23 14:32
 */
public class IsHappy {


    public boolean isHappy(int n) {
        // 已经计算过的
        List<Integer> handled = new ArrayList<>();
        while (true) {
            try {
                // 获取n每个位置上的数字的平方和
                int sum = sum(n);
                if (handled.contains(sum)) {
                    return false;
                }
                if (sum == 1) {
                    return true;
                }
                n = sum;
                handled.add(sum);
            } catch (Exception e) {
                return false;
            }
        }
    }

    public int sum(int n) {
        int sum = 0;
        while (n > 0) {
            sum += (n % 10) * (n % 10);
            n = n / 10;
        }
        return sum;
    }

}
