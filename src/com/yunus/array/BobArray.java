package com.yunus.array;

import java.util.Arrays;

/**
 * 它重复地走访过要排序的数列，一次比较两个元素，如果他们的顺序错误就把他们交换过来。
 * 走访数列的工作是重复地进行直到没有再需要交换，也就是说该数列已经排序完成。
 */
public class BobArray {

    // 操作数组
    private long[] arr;
    // 记录元素个数
    private int elems;

    public BobArray() {
        arr = new long[10];
    }

    public BobArray(int max) {
        arr = new long[max];
    }

    // 插入
    public void insert(long value) {
        // 扩容
        expansion();
        arr[elems++] = value;
    }

    // 简单扩容
    private void expansion() {
        if (elems == arr.length) {
            arr = Arrays.copyOf(arr, (3 * arr.length) / 2);
        }
    }

    // 冒泡排序方法
    public void bubleSort() {
        long temp = 0l;
        for (int i = 0; i < elems - 1; i++) {
            for (int j = 0; j < elems - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }

    // 显示
    public void display() {
        for (int i = 0; i < elems; i++) {
            System.out.print(arr[i]+" ");
        }
        System.out.println();
    }

}
