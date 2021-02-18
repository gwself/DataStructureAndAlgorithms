package com.yunus.leetcode.level1;

import com.yunus.leetcode.ListNode;

/**
 * 反转链表
 *
 * @author gaoyunfeng
 */
public class ReverseList {


    /**
     * @param head
     * @return
     */
    public ListNode reverseList(ListNode head) {
        ListNode current = null;
        while (head != null) {
            ListNode next = head.next;
            head.next = current;
            current = head;
            head = next;
        }
        return current;
    }

    /**
     * 递归反转
     *
     * @param head
     * @return
     */
    public ListNode reverse2(ListNode head) {
        if (head.next == null) {
            return head;
        }
        ListNode last = reverse2(head.next);
        head.next.next = head;
        head.next = null;
        return last;
    }
}
