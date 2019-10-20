package com.yunus.datastucture.recursion;

/**
 * @author yunus
 * @date 2017/9/16
 * 用递归来产生Fibonacci 数列
 */
public class Fibonacci {

    public static void main(String[] args) {
        System.out.println(test(1));
        System.out.println(test(2));
        System.out.println(test(3));
        System.out.println(test(4));
        System.out.println(test(5));
        System.out.println(test(6));

    }

    public static int test(int n) {
        if (n == 1 || n == 2) {
            return 1;
        } else {
            return test(n - 1) + test(n - 2);
        }
    }

}
