package com.yunus.foo;

/**
 * @author gaoyunfeng
 * @Description:
 * @date 2020/11/25 15:34
 */
public class Test {

    /**
     * 二分查找
     *
     * @param n int整型 数组长度
     * @param v int整型 查找值
     * @param a int整型一维数组 有序数组
     * @return int整型
     */
    public int upper_bound_(int n, int v, int[] a) {
        if (a[n - 1] < v) {
            return n + 1;
        }
        int left = 0;
        int right = n - 1;
        while (left < right) {
            int Mid = left + (right - left) / 2;
            if (a[Mid] >= v) {
                right = Mid;
            } else {
                left = Mid + 1;
            }
        }
        return left + 1;
    }

}
