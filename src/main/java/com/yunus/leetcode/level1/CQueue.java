package com.yunus.leetcode.level1;

import java.util.Stack;

/**
 * @author gaoyunfeng
 * @Description: 两个栈实现队列功能
 * @date 2021/5/14 9:45
 */
public class CQueue {

    /**
     * 负责写入
     */
    private final Stack<Integer> write;
    /**
     * 复杂读取
     */
    private final Stack<Integer> read;

    public CQueue() {
        read = new Stack<>();
        write = new Stack<>();
    }

    public void appendTail(int value) {
        transferWrite();
        write.push(value);
    }

    public int deleteHead() {
        transferRead();
        if (read.empty()) {
            return -1;
        }
        return read.pop();
    }

    private void transferWrite() {
        // 把read 中的数据放到Write中
        while (!read.empty()) {
            write.push(read.pop());
        }
    }

    private void transferRead() {
        // 把write中的数据放到read中
        while (!write.empty()) {
            read.push(write.pop());
        }
    }
}
