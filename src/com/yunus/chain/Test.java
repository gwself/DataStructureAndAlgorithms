package com.yunus.chain;

/**
 * Created by yunus on 2017/9/14.
 */
public class Test {
    public static void main(String[] args) {
        test3();
    }

    // 插入指定位置的节点
    public static void test1(){
        Link link = new Link();
        link.insert(10);
        link.insert(11);
        link.insert(12);
        link.insert(5555,0);
        link.displayAll();
    }

    // 链表测试
    public static void test2(){
        Link link = new Link();
        link.insert(10);
        link.insert(11);
        link.insert(12);
        link.displayAll();
    }

    // 测试删除指定节点
    public static void test3(){
        Link link = new Link();
        link.insert(10);
        link.insert(11);
        link.insert(12);
        System.out.println(link.size());
        link.displayAll();
        System.out.println("----------------------");
        link.delete(3);
        link.displayAll();
        System.out.println(link.size());
    }
}
