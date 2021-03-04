package com.yunus.leetcode.level2;

import com.yunus.leetcode.ListNode;

/**
 * @author gaoyunfeng
 * @Description: 面试题 02.05. 链表求和
 * @date 2021/3/4 16:04
 */
public class AddTwoNumbers {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        } else if (l2 == null) {
            return l1;
        }
        ListNode head = null;
        ListNode current = null;
        int temp = 0;
        while (l1 != null || l2 != null) {
            int value1 = l1 == null ? 0 : l1.val;
            int value2 = l2 == null ? 0 : l2.val;
            temp = value1 + value2 + temp;
            if (head == null) {
                head = new ListNode(temp % 10);
                current = head;
            } else {
                current.next = new ListNode(temp % 10);
                current = current.next;
            }
            l1 = l1 == null ? null : l1.next;
            l2 = l2 == null ? null : l2.next;
            temp = temp / 10;
        }
        if (temp != 0) {
            current.next = new ListNode(temp);
        }
        return head;
    }
}
