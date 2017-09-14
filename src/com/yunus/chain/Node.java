package com.yunus.chain;

/**
 * Created by yunus on 2017/9/14.
 * 链节点
 */
public class Node {
    // 数据域
    private Long data;
    // 指针域
    private Node next;

    public Node(long data) {
        this.data = data;
    }

    public Long getData() {
        return data;
    }

    public void setData(Long data) {
        this.data = data;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }
}
