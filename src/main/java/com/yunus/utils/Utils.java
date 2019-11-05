package com.yunus.utils;


public class Utils {

    /**
     * 打印链表
     *
     * @param chain 链表
     */
    public static void display(ListNode chain) {
        StringBuffer sb = new StringBuffer();
        while (chain != null) {
            sb.append(chain.val);
            sb.append("->");
            chain = chain.next;
        }
        String chainStr = sb.toString();
        System.out.println(chainStr.substring(0, chainStr.lastIndexOf("->")));
    }

    /**
     * 获取一个链表
     *
     * @return
     */
    public static ListNode getChain() {
        ListNode chain = new ListNode(1);
        ListNode two = new ListNode(2);
        chain.next = two;
        ListNode three = new ListNode(3);
        two.next = three;
        ListNode four = new ListNode(4);
        three.next = four;
        return chain;
    }

    /**
     * 获取一个循环链表
     *
     * @return
     */
    public static ListNode getCycleChain() {
        ListNode cycleChain = new ListNode(1);
        ListNode two = new ListNode(2);
        cycleChain.next = two;
        ListNode three = new ListNode(3);
        two.next = three;
        ListNode four = new ListNode(4);
        three.next = four;
        four.next = two;
        return cycleChain;
    }

}
