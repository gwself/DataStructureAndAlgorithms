package com.yunus.chain;

/**
 * Created by yunus on 2017/9/14.
 * 链表
 */
public class Link<E> {

    // 第一个数据
    private Node first;

    // 插入
    public void insert(E value) {
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
        while (current != null) {
            System.out.println(current.getData());
            current = current.getNext();
        }
    }

    static class Node<E> {
        // 数据域
        private E data;
        // 指针域
        private Node next;

        public Node(E data) {
            this.data = data;
        }

        public E getData() {
            return data;
        }

        public void setData(E data) {
            this.data = data;
        }

        public Node getNext() {
            return next;
        }

        public void setNext(Node next) {
            this.next = next;
        }
    }

}
