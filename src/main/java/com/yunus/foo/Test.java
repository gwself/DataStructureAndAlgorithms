package com.yunus.foo;

import com.yunus.leetcode.ListNode;

/**
 * @author gaoyunfeng
 * @Description:
 * @date 2020/11/25 15:34
 */
public class Test {

    public static void main(String[] args) {

    }

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode node1 = headA;
        ListNode node2 = headB;
        while (node1 != node2) {
            node1 = node1.next;
            if (node1.next == null) {
                node1 = headB;
            }
            node2 = node2.next;
            if (node2.next == null) {
                node2 = headA;
            }
        }
        return node2;
    }
}
