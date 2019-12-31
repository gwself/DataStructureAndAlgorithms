package com.yunus.array;

/**
 * 二分查找
 *
 * @author gaoyunfeng
 */
public class BinarySearch {

    public static void main(String[] args) {
        int[] arr = {1, 3, 7, 100, 999};
        int index = binarySearch(arr, 3);
        System.out.println(index);
    }

    /**
     * 二分查找
     *
     * @param arr 已排序的数组
     * @param key 查找的key
     * @return
     */
    public static int binarySearch(int[] arr, int key) {
        int left = 0;
        int right = arr.length - 1;
        int middle;
        while (left <= right) {
            middle = left + (right - left) / 2;
            if (arr[middle] == key) {
                return middle;
            }
            if (arr[middle] > key) {
                right = middle - 1;
            } else {
                left = middle + 1;
            }
        }
        return -1;
    }

    /**
     * 递归实现
     *
     * @param array 数组
     * @param key   查找值
     * @param low   低位
     * @param high  高位
     * @return
     */
    public static int binarySearch2(int[] array, int key, int low, int high) {
        if (low <= high) {
            int mid = low + (high - low) / 2;
            if (key == array[mid]) {
                return mid + 1;
            } else if (key > array[mid]) {
                return binarySearch2(array, key, mid + 1, high);
            } else {
                return binarySearch2(array, key, low, mid - 1);
            }
        }
        return -1;
    }
}
