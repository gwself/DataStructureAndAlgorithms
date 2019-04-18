package com.yunus.datastucture.stack;

/**
 * Created by yunus on 2017/9/14.
 */
public class Test {
    public static void main(String[] args) {
        // mystack 测试
        testMyStack();
        testReverse();
    }
    // 测试栈
    public static void testMyStack() {
        LongStack stack = new LongStack(10);
        stack.push(10);
        stack.push(20);
        stack.push(30);
        stack.push(40);
        stack.push(-10);
        stack.push(-20);
        while (!stack.isEmpty()) {
            System.out.println(stack.pop());
        }
    }
    // 字符串反转
    public static void testReverse(){
        ReversalStr str = new ReversalStr("hello");
        System.out.println(str.doReserve());
    }
}
