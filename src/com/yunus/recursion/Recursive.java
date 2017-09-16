package com.yunus.recursion;

/**
 * Created by yunus on 2017/9/16.
 * 递归测试
 */
public class Recursive {
    public static void main(String[] args) {
        System.out.println(test3(1));
        System.out.println(test3(2));
        System.out.println(test3(3));
        System.out.println(test3(4));


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
    // 递归 三角数
    public static int test3(int n){
        if(n == 1){
            return 1;
        }else{
            return n+test3(--n);
        }
    }

    /**
     * 三角数
     * @param n
     * @return
     */
    private static int sum(int n){
        int total = 0;
        while(n>0){
            total = total +n;
            n--;
        }
        return total;
    }
}
