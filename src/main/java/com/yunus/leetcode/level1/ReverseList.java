package com.yunus.leetcode.level1;

/**
 * 反转链表
 *
 * @author gaoyunfeng
 */
public class ReverseList {


    public Node reverseList(Node head) {
        Node current = null;
        while (head != null) {
            Node next = head.next;
            head.next = current;
            current = head;
            head = next;
        }
        return current;
    }

    class Node {
        int data;
        Node next;
    }

    Node reverse2(Node head) {
        if (head.next == null) {
            return head;
        }
        Node last = reverse2(head.next);
        head.next.next = head;
        head.next = null;
        return last;
    }
}
