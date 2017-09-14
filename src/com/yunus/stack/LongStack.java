package com.yunus.stack;

/**
 * Created by yunus on 2017/9/14.
 * 栈 数据结构 实现
 */
public class LongStack {

    private int maxSize; // 栈容量

    private long [] arr;  // 用数组来作为容器

    private int top;  // 可以看作一个指针

    // 初始化栈
    public LongStack(int size){
        this.maxSize = size;
        this.arr = new long[maxSize];
        this.top = -1;
    }

    // 压入数据
    public void push(long value){
        arr[++top] = value;
    }

    // 弹出数据
    public long pop(){
        return arr[top--];
    }

    // 访问栈顶数据
    public long peek(){
        return arr[top];
    }

    // 栈是否为空
    public boolean isEmpty(){
        return (top == -1);
    }

    // 栈是否满了
    public boolean isFull(){
        return (top == maxSize-1);
    }

}
