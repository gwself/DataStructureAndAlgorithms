package com.yunus.datastucture.queue;

/**
 * @author gaoyunfeng
 * 队列
 */
public class Queue {

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
    /**
     * 队列头
     */
    private int font;
    /**
     * 队列尾
     */
    private int end;

    public Queue(int size) {
        this.maxSize = size;
        this.elems = 0;
        this.font = 0;
        this.end = -1;
        this.arr = new long[maxSize];
    }

    /**
     * 插入元素
     */
    public void insert(long value) {
        this.arr[++end] = value;
        elems++;
    }

    /**
     * 移除元素
     */
    public long remove() {
        elems--;
        return arr[font++];
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
        return (end == this.maxSize - 1);
    }

    /**
     * 有效元素数
     */
    public int size() {
        return this.elems;
    }

}
