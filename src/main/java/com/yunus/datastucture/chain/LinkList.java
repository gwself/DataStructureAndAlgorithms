package com.yunus.datastucture.chain;

/**
 * Created by yunus on 2017/9/14.
 * 链表
 */
public class LinkList<E> {

    // 第一个数据
    private Node first;

    private int size;

    // 插入
    public void insert(E value) {
        Node lin = new Node(value);
        if (first == null) {
            first = lin;
        } else {
            lin.setNext(first);
            first = lin;
        }
        size ++;
    }

    // 插入节点到指定位置 初始位置为0开始
    public void insert(E value, int position) {
        if (position == 0) {
            insert(value);
            size++;
        } else if (position < 0) {
            throw new IndexOutOfBoundsException();
        } else {
            Node current = first;
            for (int i = 0; i < position - 1; i++) {
                current = first.getNext();
            }
            Node node = new Node(value);
            node.setNext(current.getNext());
            current.setNext(node);
            size++;
        }
    }

    // 删除指定节点
    public void delete(int position){
        if(position <0 || position > size-1){
            throw new IndexOutOfBoundsException();
        }else{
            Node current = first;
            Node last = first;
            for(int i = 0;i<position;i++){
                last = current;
                current = current.getNext();
            }
            last.setNext(current.getNext());
            size--;
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
    // link大小
    public int size(){
        return size;
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
