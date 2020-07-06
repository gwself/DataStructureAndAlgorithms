package com.yunus.leetcode.level1;

/**
 * 判断链表是否有环
 *
 * @author gaoyunfeng
 */
public class HasCycleListNode {

    public boolean hashCycle(ListNode chain) {
        if (chain == null || chain.next == null) {
            return false;
        }
        ListNode fast = chain.next;
        ListNode slow = chain;
        while (fast != slow) {
            if (fast == null || slow == null) {
                return false;
            }
            fast = chain.next.next;
            slow = chain.next;
        }
        return true;
    }

    class ListNode {
        int value;
        ListNode next;

        ListNode(int value) {
            this.value = value;
        }
    }
}
