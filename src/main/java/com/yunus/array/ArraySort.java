package com.yunus.array;

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
}
