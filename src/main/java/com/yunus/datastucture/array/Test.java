package com.yunus.datastucture.array;

/**
 * Created by yunus on 2017/9/11.
 */
public class Test {
    public static void main(String[] args) {
        InsertionArray util = new InsertionArray();
        util.insert(12);
        util.insert(13);
        util.insert(14);
        util.insert(15);
        util.insert(11);
        util.insert(10);
        util.display();
        util.insertSort();
        util.display();
        
    }
}
