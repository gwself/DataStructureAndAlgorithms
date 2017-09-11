package com.yunus.array;

/**
 * Created by yunus on 2017/9/11.
 */
public class Test {
    public static void main(String[] args) {
        LongArrayUtil util = new LongArrayUtil();
        util.sortInsert(12);
        util.sortInsert(13);
        util.sortInsert(14);
        util.sortInsert(15);
        util.sortInsert(11);
        util.sortInsert(10);
        util.display();
    }
}
