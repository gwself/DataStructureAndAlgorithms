package com.yunus.datastucture.queue;

/**
 * @author yunus
 * @date 2017/9/14
 * 优先队列
 */
public class PriorityQueue {
    /**
     * 数组
     */
    private long[] arr;
    /**
     * 最大容量
     */
    private int maxSize;
    /**
     * 有效元素
     */
    private int elems;

    public PriorityQueue(int size) {
        this.maxSize = size;
        this.elems = 0;
        this.arr = new long[maxSize];
    }

    /**
     * 插入元素
     *
     * @param value
     */
    public void insert(long value) {
        // 找到插入点
        int i;
        for (i = 0; i < elems; i++) {
            if (arr[i] > value) {
                break;
            }
        }
        // 从第i下标开始整体向后移动
        for (int j = elems; j > i; j--) {
            arr[elems] = arr[elems - 1];
        }
        arr[i] = value;
        elems++;
    }

    /**
     * 移除元素
     */
    public long remove() {
        long tmp = arr[elems - 1];
        elems--;
        return tmp;
    }

    /**
     * 是否为空
     */
    public boolean isEmpty() {
        return (elems == 0);
    }

    /**
     * 是否满了
     */
    public boolean isFull() {
        return (elems == this.maxSize);
    }

    /**
     * 有效元素数
     */
    public int size() {
        return this.elems;
    }
}
