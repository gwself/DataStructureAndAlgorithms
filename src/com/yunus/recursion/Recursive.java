package com.yunus.recursion;

/**
 * Created by yunus on 2017/9/16.
 * 递归测试
 */
public class Recursive {
    public static void main(String[] args) {
    }
    // 基本测试
    public static void test(int i){
        if(i <100){
            System.out.println("hello world "+i);
            test(++i);
        }
    }
    // 递归执行顺序
    public static void test2(int i){
        if(i <100){
            System.out.println("hello world "+i);
            test(++i);
            System.out.println("hello JAVA "+i);
        }
    }
}
