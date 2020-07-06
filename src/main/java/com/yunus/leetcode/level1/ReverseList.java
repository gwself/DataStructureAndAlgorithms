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
}
