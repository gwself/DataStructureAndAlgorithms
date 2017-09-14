package com.yunus.chain;

/**
 * Created by yunus on 2017/9/14.
 * 链表
 */
public class Link {

    // 第一个数据
    private Node first;

    // 插入
    public void insert(long value) {
        Node lin = new Node(value);
        if (first == null) {
            first = lin;
        } else {
            lin.setNext(first);
            first = lin;
        }
    }

    // 查询
    public void displayAll() {
        Node current = first;
        while(current!=null){
            System.out.println(current.getData());
            current = current.getNext();
        }
    }
}
