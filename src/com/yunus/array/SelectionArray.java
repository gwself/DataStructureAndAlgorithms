package com.yunus.array;

import java.util.Arrays;

/**
 * Created by yunus on 2017/9/11.
 */
public class SelectionArray {

    // 操作数组
    private long[] arr;
    // 记录元素个数
    private int elems;

    public SelectionArray() {
        arr = new long[10];
    }

    public SelectionArray(int max) {
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

    // 选择排序方法
    public void selectSort() {
        int min = 0;
        long temp = 0L;
        for (int i = 0; i < elems - 1; i++) {
            min = i;
            for (int j = i + 1; j < elems; j++) {
                if (arr[j] < arr[min]) {
                    min = j;
                }
            }
            temp = arr[i];
            arr[i] = arr[min];
            arr[min] = temp;
        }
    }

    // 显示
    public void display() {
        for (int i = 0; i < elems; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

}
