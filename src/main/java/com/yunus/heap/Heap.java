package com.yunus.heap;

/**
 * @author gaoyunfeng
 * @Description: https://time.geekbang.org/column/article/69913
 * @date 2021/3/18 9:58
 */
public class Heap {

    /**
     * 数组，从下标1开始存储数据
     */
    private final int[] a;
    /**
     * 堆可以存储的最大数据个数
     */
    private final int n;
    /**
     * 堆中已经存储的数据个数
     */
    private int count;

    /**
     * 数组中下标为 i 的节点的左子节点，就是下标为 i∗2 的节点，右子节点就是下标为 i∗2+1 的节点，父节点就是下标为 i/2的节点。
     *
     * @param capacity
     */
    public Heap(int capacity) {
        a = new int[capacity + 1];
        n = capacity;
        count = 0;
    }

    public void insert(int data) {
        // 堆满了
        if (count >= n) {
            return;
        }
        ++count;
        a[count] = data;
        int i = count;
        // 自下往上堆化
        while (i / 2 > 0 && a[i] > a[i / 2]) {
            // swap()函数作用：交换下标为i和i/2的两个元素
            swap(a, i, i / 2);
            i = i / 2;
        }
    }


    public void removeMax() {
        // 堆中没有数据
        if (count == 0) {
            return;
        }
        a[1] = a[count];
        --count;
        heapify(a, count, 1);
    }

    private void heapify(int[] a, int n, int i) {
        // 自上往下堆化
        while (true) {
            int maxPos = i;
            if (i * 2 <= n && a[i] < a[i * 2]) {
                maxPos = i * 2;
            }
            if (i * 2 + 1 <= n && a[maxPos] < a[i * 2 + 1]) {
                maxPos = i * 2 + 1;
            }
            if (maxPos == i) {
                break;
            }
            swap(a, i, maxPos);
            i = maxPos;
        }
    }


    private void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
