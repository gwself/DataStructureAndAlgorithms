package com.yunus.foo;

import com.yunus.leetcode.ListNode;

/**
 * @author gaoyunfeng
 * @Description:
 * @date 2020/11/25 15:34
 */
public class Test {

    public static void main(String[] args) throws InterruptedException {

    }

    /**
     * @param head ListNode类
     * @param n    int整型
     * @return ListNode类
     */
    public ListNode removeNthFromEnd(ListNode head, int n) {
        // write code here
        if (head == null) {
            return null;
        }
        ListNode p = head;
        ListNode q = head;
        ListNode pre = null;
        while (n > 0) {
            if (p != null) {
                p = p.next;
            } else {
                return null;
            }
            n--;
        }
        if (p == null) {
            return head.next;
        }
        while (p != null) {
            p = p.next;
            pre = q;
            q = q.next;
            if (p == null) {
                pre.next = q.next;
            }

        }
        return head;
    }

}
