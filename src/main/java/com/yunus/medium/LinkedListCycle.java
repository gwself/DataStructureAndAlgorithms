package com.yunus.medium;

import com.yunus.utils.ListNode;
import com.yunus.utils.Utils;

/**
 * 循环链表
 */
class LinkedListCycle {

    public static void main(String[] args) {
        ListNode cycleChain = Utils.getCycleChain();
        System.out.println(hasCycle(cycleChain));
    }


    public static boolean hasCycle(ListNode head) {
        if (head == null || head.next == null) {
            return false;
        }
        //使用快慢指针，若指针相遇则判断有环
        ListNode fast = head;
        ListNode slow = head;
        while (fast.next.next != null && slow.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) {
                return true;
            }
        }
        return false;
    }
}