package com.yunus.array;

import java.util.Arrays;

/**
 * 排序算法
 *
 * @author gaoyunfeng
 */
public class ArraySort {
    /**
     * 插入排序
     *
     * @param arr
     */
    public static void insertSort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int current = arr[i];
            int index = i;
            for (int j = i - 1; j >= 0; j--) {
                if (current < arr[j]) {
                    arr[j + 1] = arr[j];
                } else {
                    break;
                }
                index = j;
            }
            arr[index] = current;
        }
    }

    /**
     * 冒泡排序
     *
     * @param arr 原数组
     */
    public static void bubSort(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length - i - 1; j++) {
                if (arr[j + 1] < arr[j]) {
                    int temp = arr[j + 1];
                    arr[j + 1] = arr[j];
                    arr[j] = temp;
                }
            }
        }
    }

    /**
     * 选择排序
     *
     * @param arr 数组
     */
    public static void selectSort(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] > arr[j]) {
                    int tmp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = tmp;
                }
            }
        }
    }


    /**
     * 快速排序
     *
     * @param arr   数组
     * @param start 开始位置
     * @param end   结束位置
     * @return
     */
    public static int[] quickSort(int[] arr, int start, int end) {
        int pivot = arr[start];
        int i = start;
        int j = end;
        while (i < j) {
            while ((i < j) && (arr[j] > pivot)) {
                j--;
            }
            while ((i < j) && (arr[i] < pivot)) {
                i++;
            }
            if ((arr[i] == arr[j]) && (i < j)) {
                i++;
            } else {
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        if (i - 1 > start) {
            arr = quickSort(arr, start, i - 1);
        }
        if (j + 1 < end) {
            arr = quickSort(arr, j + 1, end);
        }
        return (arr);
    }

    /**
     * 合并排序
     *
     * @param to_sort
     * @return
     */
    public static int[] merge_sort(int[] to_sort) {
        if (to_sort == null) {
            return new int[0];
        }
        // 如果分解到只剩一个数，返回该数
        if (to_sort.length == 1) {
            return to_sort;
        }
        // 将数组分解成左右两半
        int mid = to_sort.length / 2;
        int[] left = Arrays.copyOfRange(to_sort, 0, mid);
        int[] right = Arrays.copyOfRange(to_sort, mid, to_sort.length);
        // 嵌套调用，对两半分别进行排序
        left = merge_sort(left);
        right = merge_sort(right);
        // 合并排序后的两半
        int[] merged = merge(left, right);
        return merged;
    }

    public static int[] merge(int[] a, int[] b) {
        if (a == null) a = new int[0];
        if (b == null) b = new int[0];
        int[] merged_one = new int[a.length + b.length];
        int mi = 0, ai = 0, bi = 0;
        // 轮流从两个数组中取出较小的值，放入合并后的数组中
        while (ai < a.length && bi < b.length) {
            if (a[ai] <= b[bi]) {
                merged_one[mi] = a[ai];
                ai++;
            } else {
                merged_one[mi] = b[bi];
                bi++;
            }
            mi++;
        }
        // 将某个数组内剩余的数字放入合并后的数组中
        if (ai < a.length) {
            for (int i = ai; i < a.length; i++) {
                merged_one[mi] = a[i];
                mi++;
            }
        } else {
            for (int i = bi; i < b.length; i++) {
                merged_one[mi] = b[i];
                mi++;
            }
        }
        return merged_one;
    }
}