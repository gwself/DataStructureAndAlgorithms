package com.yunus.leetcode.level1;

/**
 * 判断链表是否有环
 *
 * @author gaoyunfeng
 */
public class HasCycleListNode {

    public boolean hashCycle(ListNode chain) {
        ListNode quick = chain;
        ListNode slow = chain;
        //当快指针能够走到头表示无环
        while (quick != null && quick.next != null) {
            quick = quick.next.next;
            slow = slow.next;
            if (quick == slow) {
                return true;
            }
        }
        return false;
    }

    /**
     * 返回环的入口节点，如果没有环，返回null
     *
     * @param head 头节点
     * @return
     */
    public ListNode detectCycle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;

            if (fast == slow) {
                ListNode slow2 = head;
                while (slow2 != slow) {
                    slow = slow.next;
                    slow2 = slow2.next;
                }
                return slow;
            }
        }
        return null;
    }

    class ListNode {
        int value;
        ListNode next;

        ListNode(int value) {
            this.value = value;
        }
    }
}
