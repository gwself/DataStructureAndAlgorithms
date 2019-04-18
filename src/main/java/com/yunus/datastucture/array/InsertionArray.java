package com.yunus.datastucture.array;

import java.util.Arrays;

/**
 * Created by yunus on 2017/9/11.
 * 有一个已经有序的数据序列，要求在这个已经排好的数据序列中插入一个数，但要求插入后此数据序列仍然有序，
 * 这个时候就要用到一种新的排序方法——插入排序法,插入排序的基本操作就是将一个数据插入到已经排好序的有序数据中，
 * 从而得到一个新的、个数加一的有序数据，算法适用于少量数据的排序，时间复杂度为O(n^2)。是稳定的排序方法。
 * 插入算法把要排序的数组分成两部分：第一部分包含了这个数组的所有元素，但将最后一个元素除外（让数组多一个空间才有插入的位置），
 * 而第二部分就只包含这一个元素（即待插入元素）
 */
public class InsertionArray {

    // 操作数组
    private long[] arr;
    // 记录元素个数
    private int elems;

    public InsertionArray() {
        arr = new long[10];
    }

    public InsertionArray(int max) {
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

    // 插入排序方法
    public void insertSort() {
        // 取到的值
        long select = 0L;
        for (int i = 1; i < elems; i++) {
            select = arr[i];
            int j = 0;
            for (j = i; j > 0 && arr[j - 1] >= select; j--) {
                arr[j] = arr[j-1];
            }
            arr[j] = select;
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
