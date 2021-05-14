package com.yunus.foo;

import com.yunus.leetcode.ListNode;

/**
 * @author gaoyunfeng
 * @Description:
 * @date 2020/11/25 15:34
 */
public class Test {

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        // 边界条件判断
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }
        ListNode head = new ListNode(Integer.MIN_VALUE);
        ListNode tail = head;
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                tail.next = new ListNode(l1.val);
                l1 = l1.next;
            } else {
                tail.next = new ListNode(l2.val);
                l2 = l2.next;
            }
            tail = tail.next;
        }
        tail.next = l1 == null ? l2 : l1;
        return head.next;
    }
}
