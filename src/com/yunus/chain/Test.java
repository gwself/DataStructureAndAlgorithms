package com.yunus.chain;

/**
 * Created by yunus on 2017/9/14.
 */
public class Test {
    public static void main(String[] args) {
        test2();
    }

    public static void test2(){
        Link link = new Link();
        link.insert(10);
        link.insert(11);
        link.insert(12);
        link.displayAll();
    }
}
