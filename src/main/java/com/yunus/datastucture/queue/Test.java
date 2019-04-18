package com.yunus.datastucture.queue;

/**
 * Created by yunus on 2017/9/14.
 */
public class Test {
    public static void main(String[] args) {
        test2();
    }
    public static void test1(){
        Queue queue = new Queue(5);
        queue.insert(1);
        queue.insert(2);
        System.out.println(queue.isFull());
        queue.insert(3);
        queue.insert(4);
        queue.insert(23);
        while (!queue.isEmpty()){
            System.out.println(queue.remove());
        }
        // 这种队列remove后不能重复利用
    }
    // 循环队列
    public static void test2(){
        CycleQueue queue = new CycleQueue(5);
        queue.insert(1);
        queue.insert(2);
        queue.insert(3);
        queue.insert(4);
        queue.insert(23);
        //System.out.println(queue.isFull());
        queue.insert(100);
        System.out.println(queue.size());
        while (!queue.isEmpty()){
            System.out.println(queue.remove());
        }
        //queue.insert(111);
        //System.out.println(queue.isFull());
        /*while (!queue.isEmpty()){
            System.out.println(queue.remove());
        }*/
    }
}
