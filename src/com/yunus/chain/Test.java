package com.yunus.chain;

/**
 * Created by yunus on 2017/9/14.
 */
public class Test {
    public static void main(String[] args) {
        test2();
    }
    public static void test1(){
        Node link1 = new Node(1);
        Node link2 = new Node(2);
        Node link3 = new Node(3);
        Node link4 = new Node(4);
        link1.setNext(link2);
        link2.setNext(link3);
        link3.setNext(link4);

    }

    public static void test2(){
        Link link = new Link();
        link.insert(10);
        link.insert(11);
        link.insert(12);
        link.displayAll();
    }
}
