package com.yunus.easy;


import com.yunus.utils.ListNode;

/**
 * 反转链表
 */
public class ReverseLinkedList {

    public static void main(String[] args) {
        ListNode chain = new ListNode();
        chain.val = 1;
        ListNode two = new ListNode();
        chain.next = two;
        two.val = 2;
        ListNode three = new ListNode();
        two.next = three;
        three.val = 3;
    }

    /**
     * 递归方式
     *
     * @param head 头
     * @return
     */
    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode newHead = reverseList(head.next);
        head.next.next = head;
        head.next = null;
        return newHead;
    }

    /**
     * 记录临时节点 交换
     *
     * @param head
     * @return
     */
    public ListNode reverseList2(ListNode head) {
        ListNode newHead = null;
        while (head != null) {
            ListNode next = head.next;
            head.next = newHead;
            newHead = head;
            head = next;
        }
        return newHead;
    }


    /**
     * @param head
     * @return
     */
    public ListNode reverseList3(ListNode head) {
        ListNode cur = head;
        ListNode prev = null;
        while (cur != null) {
            ListNode next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
        }
        return prev;
    }
}