package com.yunus.algorithms.medium;

/**
 * Given a linked list, determine if it has a cycle in it.
 * <p>
 * Follow up:
 * Can you solve it without using extra space?
 * <p>
 * Tags: Linkedlist, Two pointers
 */
class LinkedListCycle {

    public static void main(String[] args) {
        LinkedListCycle cycle = new LinkedListCycle();
        cycle.hasCycle(new ListNode(1));
    }

    /**
     * Runnner's technique
     * Check the next and next next of faster node is slower node or not.
     */
    public boolean hasCycle(ListNode head) {
        if(head == null || head.next == null){
            return false;
        }
        //使用快慢指针，若指针相遇则判断有环
        ListNode fast = head;
        ListNode slow = head;
        while(fast.next.next != null && slow.next != null){
            fast = fast.next.next;
            slow = slow.next;
            if(fast == slow){
                return true;
            }
        }
        return false;
    }

    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }
}