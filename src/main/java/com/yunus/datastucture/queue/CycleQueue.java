package com.yunus.datastucture.queue;

/**
 * Created by yunus on 2017/9/14.
 * 队列
 */
public class CycleQueue {

    // 数组
    private long[] arr;
    // 最大容量
    private int maxSize;
    // 有效元素
    private int elems;
    //队列头
    private int font;
    // 队列尾
    private int end;

    public CycleQueue(int size){
        this.maxSize = size;
        this.elems = 0;
        this.font = 0;
        this.end = -1;
        this.arr = new long[maxSize];
    }
    // 插入元素
    public void insert(long value){
        if(end == maxSize-1){
            end = -1;
        }
        this.arr[++end] = value;
        elems = (elems>=maxSize?maxSize:(elems+1));
    }
    // 移除元素
    public long remove(){
        long tmp = arr[font++];
        if(font == maxSize){
            font = 0;
        }
        elems = (elems<0?0:(elems-1));
        return tmp;
    }
    // 是否为空
    public boolean isEmpty(){
        return (elems == 0);
    }
    // 是否满了
    public boolean isFull(){
        return (elems == this.maxSize);
    }
    // 有效元素数
    public int size(){
        return this.elems;
    }

}
