package com.yunus.leetcode.level2;

/**
 * @author gaoyunfeng
 * @Description:
 * @date 2021/3/10 13:57
 */
public class FindKth {

    public static void main(String[] args) {
        int[] arr = {1, 3, 5, 2, 2};
        findKth(arr, 5, 3);
    }


    /**
     * 第K大数字
     *
     * @param a 数组
     * @param n 数组长度
     * @param K 第k
     * @return
     */
    public static int findKth(int[] a, int n, int K) {
        // write code here
        return findK(a, 0, n - 1, K);
    }

    public static int partition(int[] arr, int left, int right) {
        int pivot = arr[left];

        while (left < right) {
            while (left < right && arr[right] <= pivot) {
                right--;
            }
            arr[left] = arr[right];
            while (left < right && arr[left] >= pivot) {
                left++;
            }
            arr[right] = arr[left];
        }
        arr[left] = pivot;
        return left;
    }

    public static int findK(int[] arr, int left, int right, int k) {
        if (left <= right) {
            int pivot = partition(arr, left, right);

            if (pivot == k - 1) {
                return arr[pivot];
            } else if (pivot < k - 1) {
                return findK(arr, pivot + 1, right, k);
            } else {
                return findK(arr, left, pivot - 1, k);
            }
        }
        return -1;
    }
}
